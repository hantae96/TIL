<template>
    <!-- 모달 -->
  <div class = 'black-bg' v-if = "모달창열렸니 == true">
    <div class  = "white-bg">
      <h4>{{dataSet[누른거].title}}</h4>
      <p>가격 : {{dataSet[누른거].price}}</p>
      <p>설명 : {{dataSet[누른거].content}}</p>
      <img :src = "dataSet[누른거].image" style = "width : 60%">
      <hr>
      <!-- props는 read-only이기 때문에, 받아온거 수정하면 안됨 -->
      <!-- 밑에 코드에서 click 이벤트를 통해서 부모에서 받아온 모달창열렸니 변수를 false로 수정하기 떄문에 -->
      <!-- <button @click = "모달창열렸니 = false"><strong>x</strong></button> -->
    </div>
  </div>
</template>

<script>
    export default{
        name : 'ModalPage',
        // step2 : 자식은 props로 받은거 등록
        // props : {데이터이름 : 자료형 이름}
        props : {
          dataSet : Object,
          누른거 : Number,
          모달창열렸니 : Boolean,
        }
    }
</script>

<style>
</style>