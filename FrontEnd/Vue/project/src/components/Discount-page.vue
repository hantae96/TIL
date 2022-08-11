<template>
<!-- 할인 배너 -->
  <div class = "DiscountPage">
    <h4>지금 결제하면 {{num}}% 할인</h4>
  </div>
</template>

<script>
export default{
    name : 'DiscountPage',
    data(){
        return {
          num : 30
        }
    },

    created(){
      setInterval(()=> {
        if(this.num ==0){
          stop
        }else{
          this.num--;
        }
      },1000)
    }
}
</script>

<style>
.DiscountPage{
  background: #eee;
  padding : 10px;
  margin : 10px;
  border-radius: 5px;
}
</style>