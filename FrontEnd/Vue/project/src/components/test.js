const express = require('express');
const multer = require('multer');
const AWS = require('aws-sdk');
const axios = require('axios');
const iconvLite = require('iconv-lite');
const { ResetQueue } = require('pdfjs-dist');

const router = express.Router();

// multer 미들웨어 파싱 (비 저장)
// MemoryStorage 사용 예상
const upload = multer();

// 아마존 S3 스토어 연결
const s3 = new AWS.S3({
    region: 'ap-northeast-2',
    accessKeyId: process.env.S3_ACCESS_KEY_ID,
    secretAccessKey: process.env.S3_SECRET_ACCESS_KEY,
});

const msToString = (time) => {
    if (time === 0) {
        return "00:00:00.000";
    } else {
        const hour = (time / 3600000) >= 1 ? parseInt(time/3600000) : 0;
        const min = (time / 60000) >= 1 ? (time / 60000) >= 60 ? parseInt(time / 60000) - 60 >= 1 ? parseInt(time / 60000) - 60 : 0 : parseInt(time / 60000) : 0;
        const sec = (time % 60000) >= 1 ? parseInt(time % 60000 / 1000) >= 1 ? parseInt(time % 60000 / 1000) : 0 : parseInt(time / 1000) >= 1 ? parseInt(time / 1000) : 0;
        const mill = time % 1000;
        const ooHour = (hour / 10) >= 1 ? hour : `0${hour}`;
        const ooMin = (min / 10) >= 1 ? min : `0${min}`;
        const ooSec = (sec / 10) >= 1 ? sec : `0${sec}`;
        const oooMill = (mill / 100) >= 1 ? mill : (mill / 10) >= 1 ? `0${mill}` : `00${mill}`;
        return `${ooHour}:${ooMin}:${ooSec}.${oooMill}`;
    }
}

async function translateLang(req,track){
    try{
        // var start = new Date().getTime();
        let tempList = [];
        for(let k = 0; k<track.length; k++){
            //번역기에 텍스트를 보내서 transTrack 에 저장
            const transTrack =  await axios.post('https://dmtcloud.kr/translate-text',{
                // 번역할 언어
                "to" : req.body.to,
                // 현재 언어
                "from" : req.body.from,
                // 현재 언어 텍스트
                "text" : track[k]
            });

            if (transTrack?.data[0]?.translations === null){
                return res.status(403).send("번역 오류");
            }            
            //data[0] : to(번역할 언어).transation(번역)
            let transtracks = transTrack.data[0].translations.split("\n");
            tempList = tempList.concat(transtracks);
            // console.log(tempList)
        }
        var end = new Date().getTime();
        // console.log("번역시간: "+ end - start);
        return tempList

    }catch(error){
        console.log(error)
    }
}



router.get('/', (req, res) => {
    return res.status(200).send('연결 안정적');
});

router.post('/presigned', upload.single('fileKey'), async (req, res, next) => {
    const params = {
        Bucket: process.env.S3_BUCKET,
        Key: 'videoes/' + req.file.originalname,
        Expires: 60 * 10,
    }
    try {
        //console.log(req.file);
        const signedUrlPut = await s3.getSignedUrlPromise("putObject", params);
        return res.send(signedUrlPut);
    } catch (error) {
        next(error);
    }
});

router.delete('/file/delete/:filename', async (req, res, next) => {
    try {
        const deleteRes = await s3.deleteObjects({
            Bucket: process.env.S3_BUCKET,
            Delete: {
                Objects: [{ 
                    Key: `videoes/${req.params.filename}`
                }],
                Quiet: false
            },
        }, (err, data) => {
            if (err) { console.log(err); }
            console.log('s3 deleteObject ', data);
            return res.status(200).send('파일 삭제');
        });
    } catch (error) {
        next(error);
    }
});

router.get('/file/list', async (req, res, next) => {
    let objects = [];
    let listResponse;

    try {    
        do {
            listResponse = await s3.listObjectsV2({
                Bucket: process.env.S3_BUCKET,
                Prefix: 'videoes/'
            }).promise();
            objects = objects.concat(listResponse.Contents.slice(1));
            if (listResponse.IsTruncated) {
                params.ContinuationToken = listResponse.NextContinuationToken;
            }
        } while (listResponse.IsTruncated);
        res.status(200).send(objects);
    } catch (error) {
        next(error);
    }
});

router.get('/track/:filename', async (req, res, next) => {
    try {
        let timeStamp = [];
        let track = [];

        await s3.getObject({
            Bucket: process.env.S3_BUCKET,
            Key: `tracks/${req.params.filename}.vtt`
        }, (err, data) => {
            if (err) {
                console.log(err);
                res.send("자막 파일이 존재하지 않음.");
            } else {
                const body = new Buffer.from(data?.Body).toString('utf8');
                if(body.toString().indexOf('WEBVTT') === -1) {
                    res.send('파일을 찾을 수 없거나, 파일이 손상되었습니다.');
                }

                // 트랙을 시간과 대사 배열로 저장.
                // 여러 줄인 경우 줄바꿈 문자를 통한 하나의 인덱스에 저장.
                const tracks = body.toString().substring(body.toString().search(/(((\d\d:\d\d)|(\d\d)):\d\d.\d\d\d) --> (((\d\d:\d\d)|(\d\d)):\d\d.\d\d\d)/gm)).split('\n');
                for (let [index, str] of tracks.entries()) {
                    if (/(((\d\d:\d\d)|(\d\d)):\d\d.\d\d\d) --> (((\d\d:\d\d)|(\d\d)):\d\d.\d\d\d)/gm.test(str)) {
                        // 시간인 경우
                        const start = str.substring(0, str.indexOf('-')).trim();
                        const end = str.substring(str.lastIndexOf('>') + 1).trim();
                        timeStamp.push({ "start": start, "end": end });
                    } else {
                        if (str === '' || index === 0) continue;
                        else {
                            if (/(((\d\d:\d\d)|(\d\d)):\d\d.\d\d\d) --> (((\d\d:\d\d)|(\d\d)):\d\d.\d\d\d)/gm.test(tracks[index-1])) {
                                // 한줄 대사
                                track.push(str);
                            } else {
                                // 여러줄 대사
                                let temp = track.pop();
                                if (temp === undefined) continue;
                                track.push(temp.concat(`\n${str}`));
                            }
                        }
                    }
                }
            }

            // JSON 파싱
            let trackToJson = [];
            const fullTrack = track.join('\n');
            for (let [index] of timeStamp.entries()) {
                trackToJson.push({
                    "start": timeStamp[index].start,
                    "end": timeStamp[index].end,
                    "text": track[index]
                });
            }
            res.status(200).json({ "segment": trackToJson, "text": fullTrack });
        });
    } catch (error) {
        next(error);
    }
});

router.post('/recognition', async (req, res, next) => {
    let timeStamp = [];
    let trackArray = [];
    let trackVTT = "WEBVTT\n\n";
    let trackSRT = "";
    let count = 1;
    try {
        //console.log("받은 파일 URL : ", req.body.fileURL);
        const naverResponse = await axios.post(`${process.env.NAVER_INVOKE_URL}/recognizer/url`, {
            "url": req.body.fileURL,
            "language": "enko",
            "completion": 'sync',
            "diarization.enable": 'false',
            "resultToObs": 'false'
        }, {
            headers: {
                "X-CLOVASPEECH-API-KEY": `${process.env.NAVER_SECRET_KEY}`,
                "Content-Type": "application/json"
            }
        });

        if (naverResponse.data.message === "Succeeded") {
            const segments = naverResponse.data.segments;
            for (const [index, segment] of segments.entries()) {
                const startTime = msToString(segment.start);
                const srtStartTime = startTime.replace('.', ',');
                const endTime = msToString(segment.end);
                const srtEndTime = endTime.replace('.', ',');
                timeStamp.push({ "start": startTime, "end": endTime });
                trackArray.push(segment.text);
                trackVTT += `${startTime} --> ${endTime}\n${segment.text}\n\n`;
                trackSRT += `${count}\n${srtStartTime} --> ${srtEndTime}\n${segment.text}\n\n`
                count++;
            }

            await s3.putObject({
                Bucket: process.env.S3_BUCKET,
                Key: `tracks/${req.body.fileName}.vtt`,
                Body: trackVTT
            }, (err, data) => {
                if (err) res.status(400).send("자막 생성 에러");
                if (req.body.ext === 'srt') {
                    res.status(200).json({
                        "track": trackSRT,
                        "segment": trackArray,
                        "timeline": timeStamp
                    });
                } else {
                    res.status(200).json({
                        "track": trackVTT,
                        "segment": trackArray,
                        "timeline": timeStamp
                    });
                }
            });
        } else {
            res.status(301).json({
                "message": "파일 인식 실패",
                "timeStamp": [],
                "trackURL" : ""
            });
        }
    } catch (error) {
        next(error);
    }
});

router.post('/track/create', async (req, res, next) => {
    try {
        await s3.putObject({
            Bucket: process.env.S3_BUCKET,
            Key: `tracks/${req.body.fileName}${req.body.ext === "srt" ? ".srt" : ".vtt"}`,
            Body: req.body.track
        }, (err, data) => {
            if (err) res.status(400).send("업로드 에러");
            res.status(200).send("자막 업로드 완료");
        });
    } catch (error) {
        next(error);
    }
});

router.post('/track/trans', async (req, res, next) => {
    try {
        const tracks = req.body.track;
        let newTrack = [];
        // 로직
        if (tracks.length > 180) {
            let count = parseInt(tracks.length / 100);
            for (let i = 0; i < count; i++) {
                const text = tracks.slice(i*100, (i+1)*100).join("\n\n");
                const transTrack = await axios.post('https://dmtcloud.kr/translate-text', {
                    "to": req.body.to,
                    "from": req.body.from,
                    "text": text
                });
                if (transTrack?.data[0]?.translations === null) {
                    return res.status(403).send("번역 오류");
                }
                const temp = transTrack.data[0].translations.split("\n");
                newTrack = newTrack.concat(temp);
            }
            const text = tracks.slice(parseInt(tracks.length / 100) * 100).join("\n\n");
            const transTrack = await axios.post('https://dmtcloud.kr/translate-text', {
                "to": req.body.to,
                "from": req.body.from,
                "text": text
            });
            if (transTrack?.data[0]?.translations === null) {
                return res.status(403).send("번역 오류");
            }
            const temp = transTrack.data[0].translations.split("\n");
            newTrack = newTrack.concat(temp);
            res.status(200).json({
                "from": req.body.from,
                "to": req.body.to,
                "translations": newTrack
            });
        } else {
            const track = req.body.track.join("\n\n");
            const transTrack = await axios.post('https://dmtcloud.kr/translate-text', {
                "to": req.body.to,
                "from": req.body.from,
                "text": track
            });
            if (transTrack?.data[0]?.translations === null) {
                return res.status(403).send("번역 오류");
            }
            newTrack = transTrack.data[0].translations.split("\n");
            res.status(200).json({
                "from": req.body.from,
                "to": req.body.to,
                "translations": newTrack
            });
        }
    } catch (error) {
        next(error);
    }
});


// RealTrack에서 오는 API
router.post('/track/format', async(req, res, next) => {

    let timeStamp = [];
    let track = "";
    let mode = "vtt";
    let trackVTT = "WEBVTT\n\n";
    let trackSRT = "";
    let newTrack = [];

    try{
        timeStamp = req.body.timeline;
        // track = req.body.track.join("\n\n");
        track = req.body.track
        mode = req.body.mode;
        
        // translateLang 함수가 작동하는데 시간이 걸려서 await 구문으로 기다려야 정상적으로 동작
        newTrack=newTrack.concat(await translateLang(req,track))   
        
        // 모드가 vtt 일때
        if(mode === "srt"){
            // 타임스태프와 뉴트랙의 길이를 비교해서 더 짧은 길이로 for 문 순회
            for(let i = 0; i< (timeStamp.length <= newTrack.length ? timeStamp.length : newTrack.length); i++){
                    // 초 이하 구분자가 . 인걸 , 으로 바꿔주는 코드
                    let srtStartTime = timeStamp[i].start.replace('.', ',');
                    let srtEndTime = timeStamp[i].end.replace('.', ',');
                    // 포맷팅 문단번호 \n 시작시간 --> 끝시간\n 번역한 언어
                    trackSRT += `${i+1}\n${srtStartTime} --> ${srtEndTime}\n${newTrack[i]}\n\n`
            }
            return res.status(200).send(trackSRT);
        
        // 모드가 srt 일때, 위에 코드와 동일함
        } else {
            for (let i = 0; i < (timeStamp.length <= newTrack.length ? timeStamp.length : newTrack.length); i++) {
                let startTime = timeStamp[i].start;
                let endTime = timeStamp[i].end;
                trackVTT += `${startTime} --> ${endTime}\n${newTrack[i]}\n\n`;
            }
            return res.status(200).send(trackVTT);   
        }
        
    } catch (error) {
        next(error);

    }
          
       
});


    // try {
    //     timeStamp = req.body.timeline;
    //     track = req.body.track.join("\n\n");
    //     mode = req.body.mode;

    //     const transTrack = await axios.post('https://dmtcloud.kr/translate-text', {
    //         "to": req.body.to,
    //         "from": req.body.from,
    //         "text": track
    //     });
            // es6 객체가 true면 ? 다음 
    //     if (transTrack?.data[0]?.translations === null) {
    //         res.status(403).send("번역 오류");
    //     }

    //     const newTrack = transTrack.data[0].translations.split("\n");
    //     if (mode === "srt") {
    //         for (let i = 0; i < (timeStamp.length <= newTrack.length ? timeStamp.length : newTrack.length); i++) {
    //             let srtStartTime = timeStamp[i].start.replace('.', ',');
    //             let srtEndTime = timeStamp[i].end.replace('.', ',');
    //             trackSRT += `${i+1}\n${srtStartTime} --> ${srtEndTime}\n${newTrack[i]}\n\n`
    //         }
    //         res.status(200).send(trackSRT);
    //     } else {
    //         for (let i = 0; i < (timeStamp.length <= newTrack.length ? timeStamp.length : newTrack.length); i++) {
    //             let startTime = timeStamp[i].start;
    //             let endTime = timeStamp[i].end;
    //             trackVTT += `${startTime} --> ${endTime}\n${newTrack[i]}\n\n`;
    //         }
    //         res.status(200).send(trackVTT);
    //     }
    // } catch (error) {
    //     next(error);
    // }

//

router.get('/download/:filename', async (req, res, next) => {
    try {
        const fn = () => {
            if (req.headers['user-agent'].includes("MSIE") || req.headers['user-agent'].includes("Trident")) {
                return encodeURIComponent(req.params.filename).replace(/\\+/gi, "%20");
            } else if (req.headers['user-agent'].includes("Chrome")) {
                return iconvLite.encode(req.params.filename, "UTF-8");
            } else if (req.headers['user-agent'].includes("Opera")) {
                return iconvLite.decode(iconvLite.encode(req.params.filename, "UTF-8"), 'ISO-8859-1');
            } else if (req.headers['user-agent'].includes("Firefox")) {
                return iconvLite.decode(iconvLite.encode(req.params.filename, "UTF-8"), 'ISO-8859-1');
            }
            return req.params.filename;
        }
        
        res.attachment(fn().toString());
        const downloadS3 = await s3.getObject({
            Bucket: process.env.S3_BUCKET,
            Key: 'tracks/' + fn()
        }).createReadStream();
        downloadS3.pipe(res);
    } catch (error) {
        next(error);
    }
});

router.post('/downloadRT/:filename', async (req, res, next) => {
    try {

    } catch (error) {
        next(error);
    }
});

module.exports = router;