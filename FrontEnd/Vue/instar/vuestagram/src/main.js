import App from './App.vue'
import store from './store.js'
import { createApp } from 'vue'

import mitt from 'mitt'
createApp(App).mount('#app')

let emitter = mitt();
let app = createApp(App)

// Vue 에서 전연변수 보관함 == globalProperties
app.config.globalProperties.emitter = emitter;

app.use(store).mount('#app')
