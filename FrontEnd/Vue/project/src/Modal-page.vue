<template>
    <!-- 모달 -->
  <div class = 'black-bg' v-if = "모달창열렸니 == true">
    <div class  = "white-bg">
      <h4>{{dataSet[누른거].title}}</h4>
      
      <p>가격 : {{dataSet[누른거].price}}</p>
      <p>설명 : {{dataSet[누른거].content}}</p>
      <img :src = "dataSet[누른거].image" style = "width : 60%">
      <hr>
      <!-- <button @click = "모달창열렸니 = false"><strong>x</strong></button> -->
    </div>
  </div>
</template>

<script>
    export default{
        name : 'ModalPage',
        props : {
          dataSet : Object,
          누른거 : Number,
          모달창열렸니 : Boolean,
        }
    }
</script>

<style>
</style>