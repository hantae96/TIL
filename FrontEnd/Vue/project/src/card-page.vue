<template>
  <!-- 제품 소개 개요 -->
  <div class = "salePage">
    <div v-for = "(data,i) in dataSet" :key="i">
    <img :src = "dataSet[i].image" class = "room-img">
<!-- 클릭 이벤트가 발생하면 모달창을 띄운다. 추가적으로 누른거 변수에다가 i를 갱신하면 몇번째 모달창을 눌렀는 지 알 수 있다. -->
<!-- <h4 @click = "모달창열렸니 = true; 누른거 = i">{{data.title}}</h4> -->
    
    <p>{{dataSet[i].price}}원</p>
    </div>
  </div>
</template>

<script>
export default {
    name : "cardPage",
    props : {
        dataSet : Object,
        누른거 : Number,
        모달창열렸니 : Boolean,
    }
}
</script>

<style>
    .room-img{
        width : 100%;
        margin-top: 40px;
    }   
</style>