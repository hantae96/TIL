<template>
    <div>
        <div v-if = "step == 0">
            <div v-for = "(data,i) in UserData" :key = "i">
                <PostSection v-bind:UserData = "data"/>
            </div>
        </div>
        

        <!-- 글작성페이지 -->
        <div v-if = "step == 1">
            <div class="upload-image" v-bind:style = "`background-image : url(${img})`"></div>
               <textarea @input="send($event)" class="write-box">write!</textarea> 
        </div>      

        <!-- 필터선택페이지 -->
        <div v-if = "step == 2">
            <div class="upload-image" v-bind:style = "`background-image : url(${img})`" ></div>
            <div class="filters">
                <FilterBox v-for = "(item,i) in filter" :key = "i" v-bind:img="img" v-bind:item="item">
                    {{item}}
                </FilterBox>

            </div>
        </div>
    </div>
</template>
<script>
import PostSection from './PostSection.vue'
import FilterBox from './FilterBox.vue';

export default{
    data(){
        return {
            filter : [ "aden", "_1977", "brannan", "brooklyn", "clarendon", "earlybird", "gingham", "hudson", 
                    "inkwell", "kelvin", "lark", "lofi", "maven", "mayfair", "moon", "nashville", "perpetua", 
                        "reyes", "rise", "slumber", "stinson", "toaster", "valencia", "walden", "willow", "xpro2"],
        }
    },
    components : {
        PostSection : PostSection,
        FilterBox : FilterBox
    },
    props : {
        UserData : Array,
        step : Number,
        img : String,
    },
    methods : {
        send(event){
            this.$emit('sendText',event.target.value);
        }
    }
    }
</script>
<style>
.upload-image{
width: 100%;
height: 450px;
background: cornflowerblue;
background-size : cover;
}
.filters{
display: flex;
overflow-x:scroll;
white-space: nowrap;
}
.filter-1 {
width: 100px;
height: 100px;
background-color: cornflowerblue;
margin: 10px 10px 10px auto;
padding: 8px;
display: inline-block;
color : white;
background-size: cover;
}
.filters::-webkit-scrollbar {
height: 5px;
}
.filters::-webkit-scrollbar-track {
background: #f1f1f1; 
}
.filters::-webkit-scrollbar-thumb {
background: #888; 
border-radius: 5px;
}
.filters::-webkit-scrollbar-thumb:hover {
background: #555; 
}
.write-box {
border: none;
width: 90%;
height: 100px;
padding: 15px;
margin: auto;
display: block;
outline: none;
}
</style>