<template>
<div>
  <img alt="Vue logo" src="./assets/logo.png">
  
  <div class = "menu">
    <a v-for = "작명 in 메뉴들" :key="작명">{{작명}}</a>
  </div>
  
<DiscountPage/>

<transition name ="fade">
  <!-- props 문법 -->
  <ModalPage v-bind:dataSet="dataSet" v-bind:누른거 = "누른거" v-bind:모달창열렸니 = "모달창열렸니" @modalClose = "모달창열렸니 = false"/>
  <!-- step1 : 보낼 데이터 부모에서 전송 <ModalPage :데이터이름작명 = "실제 데이터 이름"/>  -->
</transition>

<!-- 카드 소개 페이지 컴포넌트화 -->
<cardPage @openModal ="모달창열렸니 = true; 누른거 = $event" v-bind:data="dataSet[i]" v-for = "(value,i) in dataSet" :key="i"/>
<DiscountPage v-if="showDiscount==true"/>

<button @click="priceSort()">가격순정렬</button>
<button @click="sortBack()">되돌리기</button>
</div>
</template>

<script>
// 데이터 셋 받아옴
import data from "./assets/oneroom.js";
import DiscountPage from "./components/Discount-page.vue";
import ModalPage from "./Modal-page.vue";
import cardPage from "./card-page.vue";

export default {
  name: 'App',
  // 데이터를 저장할 때 객체 자료형으로 저장
  data(){
    return {      
      오브젝트 :{name : 'kim', age : 20},
      dataSet : data,
      originDataSet : [...data],
      누른거 : 0,
      모달창열렸니 : false,
      showDiscount : true,
      신고수 : [0,0,0],
      스타일 : "color :blue",
      products : ['역삼동','호평동','중계동'],
      prices : [60,50,70],
      메뉴들 : ['Hone','Shop','About'],
      
    }
  },
  methods :{
    // 메소드 선언
    increase(i){
      this.신고수[i]++;
    },
    test(){
      console.log(this.메뉴들[1])
    },
    priceSort(){
      this.originDataSet = this.dataSet
      this.dataSet.sort(function(a,b){
        return a.price-b.price
      });
    },
    sortBack(){
      this.dataSet = [...this.originDataSet] 
    }
  },
  components: {
    // 외부에서 받아온 컴포넌트를 내부 컴포넌트로 등록
    DiscountPage: DiscountPage,
    ModalPage: ModalPage,
    cardPage: cardPage,
  },
  mounted(){
    setTimeout(()=>{
      this.showDiscount = false;
    },2000);
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
  position: fixed; 
  padding: 20px;
  top : 0px;
}

.white-bg{
  position: relative;
  top :  30px;
  left : 50%;
  transform: translate(-50%, 0%);
  width : 80%;
  height: 80%;
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

.start{
  opacity: 0;
  transition: all 1s;
}

.end {
  opacity: 1;
}
/* 입장 */
/* 시작 */
.fade-enter-from{
  opacity: 0;
  transform: translateY(-1000px);
}
.fade-enter-active{
  transition: all 1s;
}
/* 끝 */
.fade-enter-to{
  opacity: 1;
  transform: translateY(0px);
}

/* 퇴장 */

/* 시작 */
.fade-leave-from{
  opacity: 1;
  transform : translateY(0px)
}
.fade-leave-active{
  transition: all 1s;
}
/* 끝 */
.fade-leave-to{
  opacity: 0;
    transform: translateY(-1000px);

}


</style>
