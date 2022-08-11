Vue.component('base-checkbox',{
    model : {
        props : 'checked',
        event : 'change'
    },
    props :{
        checked : Boolean
    },
    template :
    <input
    type = "checkbox"
    v-bind:checked="checked"
    v-on:change = "$emit('change',$event.target.checked)"
})