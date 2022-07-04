<template>
  <!-- 제품 소개 개요 -->
  <div class = "salePage">
    <img :src = "data.image" class = "room-img">
<!-- 클릭 이벤트가 발생하면 모달창을 띄운다. 추가적으로 누른거 변수에다가 i를 갱신하면 몇번째 모달창을 눌렀는 지 알 수 있다. -->
        <h4>{{data.title}}</h4>   
        <p>{{data.price}}원</p>
  </div>
</template>

<script>
export default {
    name : "cardPage",
    props : {
        data : Object,
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