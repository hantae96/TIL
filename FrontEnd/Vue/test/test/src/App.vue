<template>
<div>
  <div id="app">
    {{message}}
  </div>

  <div id="app-3">
    <p v-if="seen">이제 나를 볼 수 있어요</p>
    <ol>
      <li v-for="todo in todos" :key="todo">
        {{todo.text}}
      </li>
    </ol>
  
  </div>

</div>
</template>

<script>


export default {
  name: 'App',
  data(){
    return{
      message : "안녕하세요 Vue!",
      seen : true,
      todos: [
      { text: 'JavaScript 배우기' },
      { text: 'Vue 배우기' },
      { text: '무언가 멋진 것을 만들기' }
    ]
    }
  },
  components: {
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
