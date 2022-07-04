<template>
<div>
  <img alt="Vue logo" src="./assets/logo.png">
  
  <div class = "menu">
    <a v-for = "작명 in 메뉴들" :key="작명">{{작명}}</a>
  </div>
  
<DiscountPage/>

<ModalPage v-bind:dataSet="dataSet" v-bind:누른거 = "누른거" v-bind:모달창열렸니 = "모달창열렸니"/>

<!-- 카드 소개 페이지 컴포넌트화 -->
  <cardPage v-bind:data="dataSet[i]" v-for = "(value,i) in dataSet" :key="i"/>

<DiscountPage/>
</div>
</template>

<script>
// 데이터 셋 받아옴
import data from "./assets/oneroom.js";
import DiscountPage from "./Discount-page.vue";
import ModalPage from "./Modal-page.vue";
import cardPage from "./card-page.vue";

export default {
  name: 'App',
  // 데이터를 저장할 때 객체 자료형으로 저장
  data(){
    return {      
    오브젝트 :{name : 'kim', age : 20},
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
    cardPage : cardPage,
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



</style>
