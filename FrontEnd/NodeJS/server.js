const express = require('express');
const app = express()
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended : true}));

app.listen(8080,function(){
    console.log("listening on 8080")
});

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


app.post('/newpost',function(요청,응답){
    응답.send('전송완료');
    console.log(요청.body)
    console.log(__dirname)
})