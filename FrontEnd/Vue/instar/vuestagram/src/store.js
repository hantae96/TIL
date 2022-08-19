import { createStore } from 'vuex'

const store = createStore({
  state(){
    return {
      name : 'kim'
    }
  },

  mutations : {
    이름변경(state){
        state.name = 'park'
    }
  }
})

export default store;

