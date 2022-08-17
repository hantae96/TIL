<template>
  <div>
    <!-- class 바인딩 -->
    <slot></slot>
    <div :class = "item" class="filter-item" :style="`background-image:url(${img})`"></div> 
    
  </div>
</template>

<script>
export default {
  name: 'FilterBox',
  props: {
    img : String,
    item : String,
  }
}
</script>
<style scoped>
    .filter-item {
    width: 100px;
    height: 100px;
    margin: 10px 10px 10px auto;
    padding: 8px;
    display: inline-block;
    color : white;
    background-size: cover;
    background-position : center;
    }
</style>
