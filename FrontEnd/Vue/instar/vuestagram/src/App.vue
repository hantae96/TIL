<template>
  <div class="mainTemplate">
    <div class="header">
      <ul class="header-button-left">
        <li>Cancel </li>
      </ul>
      <ul class="header-button-right">
        <li v-if = "step ==2" @click = "step = 1">Next</li>
        <li v-if = "step ==1" @click = "publish()">Post</li>
      </ul>
      <img src="./assets/logo.png" class="logo" />
    </div>

    <div class = "tab-container">
      <button class="btn-hover color-1"  @click = "step = 0">post</button>
      <button class="btn-hover color-2" @click = "step = 1">write</button>
      <button class="btn-hover color-3" @click = "step = 2">filter</button>
    </div>

    <!-- 상위 하위 컴포넌트가 어떻게 연결되 있는지 확인!! -->
    <!-- 무지성으로 props 전송하지말자 -->
    <!-- custom event는 보낸 상위 컴포넌트에서 받아야 한다!! -->
    <ContainerPage v-bind:UserData = "UserData" v-bind:step = "step" v-bind:img = "img" @sendText ="context=$event" />
    <button @click ="more()">더보기</button>

    <div class="footer">
      <ul class="footer-button-plus">
        <!-- 인풋을 여러개 받고 싶으면 멀티플 선택창에서 accept = "image/*" -->
        <!-- <input @change = "upload" multiple type="file" id="file" class="inputfile" /> -->
        <input @change = "upload" type="file" id="file" class="inputfile" />
        <label for="file" class="input-plus">+</label>
      </ul>
    </div>
  </div>
  
  <!-- 동적인 UI 만드는법
  UI 현재 상태를 데이터 만들기
  상태에 따라 HTML이 어떻게 보일지 -->
  <!-- <div  v-show = "step==0">내용0</div>
  <div  v-show = "step==1">내용1</div>
  <div  v-show = "step==2">내용2</div>
  <button @click = "step = 0">버튼0</button>
  <button @click = "step = 1">버튼1</button>
  <button @click = "step = 2">버튼2</button> -->
</template>

<script>
import UserData from './assets/UserData.js'
import ContainerPage from './components/ContainerPage.vue'
import axios from 'axios'


export default {
  name: 'App',
  data(){
    return {
      UserData : UserData,
      test : 1,
      count : 0,
      step : 0,
      img : "",
      context : '',

    }
  },
  components: {
    ContainerPage : ContainerPage,
  },
  methods : {
    more(){
      axios.get(`https://codingapple1.github.io/vue/more${this.count}.json`)
      .then((result)=>{
        this.count++;
        // 요청성공시 실행할 코드~~
        console.log(result.data);
        this.UserData.push(result.data);
      })
      .catch((error)=>{
        console.log(error)
      })
    },
    upload(e){
      let file = e.target.files;
      this.step = 2;
      this.img= URL.createObjectURL(file[0]);
    },
    publish(){
      let newPost =   {
            name: "Karina",
            userImage: "https://placeimg.com/100/100/arch",
            postImage: this.img,
            likes: 36,
            date: "May 15",
            liked: false,
            content: this.context,
            filter: "perpetua"
          }
      this.UserData.unshift(newPost);
      this.step = 0;
    }
  }
}
</script>

<style>

body {
  margin: 0;
}
ul {
  padding: 5px;
  list-style-type: none;
}

button{
  border : none;
  
}
.logo {
  width: 22px;
  margin: auto;
  display: block;
  position: absolute;
  left: 0;
  right: 0;
  top: 13px;
}
.header {
  width: 100%;
  height: 40px;
  background-color: white;
  padding-bottom: 8px;
  position: sticky;
  top: 0;
}
.header-button-left {
  color: skyblue;
  float: left;
  width: 50px;
  padding-left: 20px;
  cursor: pointer;
  margin-top: 10px;
}
.header-button-right {
  color: skyblue;
  float: right;
  width: 50px;
  cursor: pointer;
  margin-top: 10px;
}
.footer {
  width: 100%;
  position: sticky;
  bottom: 0;
  padding-bottom: 10px;
  background-color: white;
}
.footer-button-plus {
  width: 80px;
  margin: auto;
  text-align: center;
  cursor: pointer;
  font-size: 24px;
  padding-top: 12px;
}
.sample-box {
  width: 100%;
  height: 600px;
  background-color: bisque;
}
.inputfile {
  display: none;
}
.input-plus {
  cursor: pointer;
}
#app {
  box-sizing: border-box;
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}

.tab-container{
  display: flex;
  justify-content: space-around;
}
* {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

.buttons {
    margin: 10%;
    text-align: center;
}

.btn-hover {
    width: 200px;
    font-size: 16px;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
    margin: 20px;
    height: 55px;
    text-align:center;
    border: none;
    background-size: 300% 100%;

    border-radius: 50px;
    moz-transition: all .4s ease-in-out;
    -o-transition: all .4s ease-in-out;
    -webkit-transition: all .4s ease-in-out;
    transition: all .4s ease-in-out;
}

.btn-hover:hover {
    background-position: 100% 0;
    moz-transition: all .4s ease-in-out;
    -o-transition: all .4s ease-in-out;
    -webkit-transition: all .4s ease-in-out;
    transition: all .4s ease-in-out;
}

.btn-hover:focus {
    outline: none;
}

.btn-hover.color-1 {
    background-image: linear-gradient(to right, #25aae1, #40e495, #30dd8a, #2bb673);
    box-shadow: 0 4px 15px 0 rgba(49, 196, 190, 0.75);
}
.btn-hover.color-2 {
    background-image: linear-gradient(to right, #f5ce62, #e43603, #fa7199, #e85a19);
    box-shadow: 0 4px 15px 0 rgba(229, 66, 10, 0.75);
}
.btn-hover.color-3 {
    background-image: linear-gradient(to right, #667eea, #764ba2, #6B8DD6, #8E37D7);
    box-shadow: 0 4px 15px 0 rgba(116, 79, 168, 0.75);
}

</style>
