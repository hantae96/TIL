<template>
  <img alt="Vue logo" src="./assets/logo.png">
  
  <div class = "menu">
    <a v-for = "작명 in 메뉴들" :key="작명">{{작명}}</a>
  </div>
  
<DiscountPage/>

<ModalPage/>
<!-- 제품 소개 개요 -->
  <div class = "salePage">
    <div v-for = "(data,i) in dataSet" :key="i">
    <img :src = "dataSet[i].image" class = "room-img">
<!-- 클릭 이벤트가 발생하면 모달창을 띄운다. 추가적으로 누른거 변수에다가 i를 갱신하면 몇번째 모달창을 눌렀는 지 알 수 있다. -->
    <h4 @click = "모달창열렸니 = true; 누른거 = i">{{data.title}}</h4>
    
    <p>{{dataSet[i].price}}원</p>
    </div>
  </div>

<DiscountPage/>

</template>

<script>
// 데이터 셋 받아옴
import data from "./assets/oneroom.js";
import DiscountPage from "./Discount-page.vue";
import ModalPage from "./Modal-page.vue";

export default {
  name: 'App',
  // 데이터를 저장할 때 객체 자료형으로 저장
  data(){
    return {
    dataSet : data,
      누른거 : 0,
      모달창열렸니 : false,
      신고수 : [0,0,0],
      스타일 : "color :blue",
      products : ['역삼동','호평동','중계동'],
      prices : [60,50,70],
      메뉴들 : ['Hone','Shop','About'],
    }
  },
  methods :{
    increase(i){
      this.신고수[i]++;
    },
  },
  components: {
    // 외부에서 받아온 컴포넌트를 내부 컴포넌트로 등록
    DiscountPage: DiscountPage,
    ModalPage : ModalPage,
}
}
</script>

<style>

body{
  margin : 0,
}
div {
  box-sizing: border-box;
}
.black-bg{
  width : 100%; height : 100%;
  background : rgba(0,0,0,0.5);
  position: fixed; padding: 20px;
}

.white-bg{
  position: relative;
  top :  30px;
  left : 50%;
  transform: translate(-50%, 0%);
  width : 80%;
  height: 50%;
  background : white;
  padding: 20px;
  border-radius: 5%;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.menu {
  background-color: darkmagenta;
  padding : 15px;
  border-radius: 5px;
}

.menu a {
  color : white;
  padding : 10px;
}

.room-img{
  width : 100%;
  margin-top: 40px;
}

</style>
