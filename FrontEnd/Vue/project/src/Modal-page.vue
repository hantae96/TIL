<template>
    <!-- 모달 -->
  <div class = 'black-bg' v-if = "모달창열렸니 == true">
    <div class  = "white-bg">
      <h4>{{dataSet[누른거].title}}</h4>
      <p>가격 : {{dataSet[누른거].price}}</p>
      <p>설명 : {{dataSet[누른거].content}}</p>
      <img :src = "dataSet[누른거].image" style = "width : 60%">
      <!-- $event -> 쌩 자바스크립트에서 addEventLisener 역할 -->
      <!-- addEventLisener(function(e){ 이렇게 쓰는데 안에 e역할이다}) -->
      
      <!-- <input @input ="month = $event.target.value"> -->
      <!-- 데이터 저장할때 위에 코드 약어 -->
      
      <input v-model = "month">
      <p>{{month}} 개월 선택함 : {{dataSet[누른거].price * Number(month)}}원</p>
      <!-- props는 read-only이기 때문에, 받아온거 수정하면 안됨 -->
      <!-- 밑에 코드에서 click 이벤트를 통해서 부모에서 받아온 모달창열렸니 변수를 false로 수정하기 떄문에 -->
      <button @click = "[$emit('modalClose')]"><strong>닫기</strong></button>
      <textarea v-model="message"  placeholder="메모를 입력하세요!!"></textarea>

    <div class="memoArea">
      <ul>
        <li style = "white-space: pre-line;">{{message}}</li>
      </ul>
    </div>
    </div>
  </div>
</template>

<script>
    export default{
        name : 'ModalPage',
        data(){
          return {
            month : 1,
            message : [],
            refineMemo : [],
          }
        },
        watch : {
          //month를 감시하는 도구
          month(a){
            if(this.checkEng(a)){
              alert("문자아니라고")
            }
          },
          date(){
            
          }
        },
        // step2 : 자식은 props로 받은거 등록
        // props : {데이터이름 : 자료형 이름}
        props : {
          dataSet : Object,
          누른거 : Number,
          모달창열렸니 : Boolean,
        },

        methods : {
          refine(text){
            console.log("Test")
            var temp = []
            for(let i = 0; i<text.length; i++){
              if(text[i]=="\n"){
                this.refineMemo.concat(temp)
              }else{
                temp.push(text[i])
              }
            }
            return this.refineMemo
          },
          checkEng(str){
            const regExp = /[a-zA-Z]/g;
            if(regExp.test(str)){
              return true;
            }else{
              return false;
            }
          }
          }
        }

</script>

<style>
  button{
    background-color: red;
  }
  input{
    display: block;
    border: 1px solid black;
    margin: auto;
  }
  textarea{
    display: block;
    margin : auto;
    margin-top : 20px;
    border: 1px solid black;
  }
</style>