const express = require('express');
const app = express()
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended : true}));
app.set('view engine','ejs');

var db;
const MongoClient = require('mongodb').MongoClient;
MongoClient.connect('mongodb+srv://admin:lager96!@cluster0.1uynodw.mongodb.net/?retryWrites=true&w=majority',
function(에러,client){
    if(에러){
        return console.log(에러)
    }

    db = client.db('test');
    db.collection('post').insertOne({_id : 0, 이름 : 'hantae', 나이 : 27},function(에러,결과){
        console.log("DB연결")
    });

    app.listen(8080,function(){
        console.log("listening on 8080")
    })
})


//누군가가 /pet 으로 방문을 하면 ..
//pet 관련된 안내물을 띄워주자

app.get('/pet',function(req,res){
    res.send('펫용품 쇼핑 페이지입니다.');
});

app.get('/beauty',function(req,res){
    res.send("뷰티용품 쇼핑 페이지입니다.")
});

app.get('/',function(req,res){
    res.sendFile(__dirname + '/index.html')
});

app.get('/write',function(req,res){
    res.sendFile(__dirname+'/write.html')
})

//어떤 사람이 /add 경로로 POST 요청을 하면..
// ?? 을 실행해주세요

app.post('/add',function(요청,응답){
    db.collection('counter').findOne({name : '게시물갯수'},function(에러,결과){
        console.log(결과.totalPost);
        let 총게시물갯수 = 결과.totalPost;
    db.collection('post').insertOne({_id : 총게시물갯수 + 1, 제목 : 요청.body.title, 날짜 : 요청.body.date},function(에러,결과){
        console.log("저장완료");
        db.collection('counter').updateOne({name : '게시물갯수'},{$inc : {totalPost:1}},function(에러,결과){
            if(에러){
                return console.log(에러)
            }
        })
        })
    });
})





app.get('/list',function(요청,응답){
    db.collection('post').find().toArray(function(에러,결과){
        console.log(결과);
        응답.render('list.ejs',{posts : 결과});

    });
        // 디비에 저장된 post라는 collections 안에 모든 데이터를 꺼내주세요.
})


