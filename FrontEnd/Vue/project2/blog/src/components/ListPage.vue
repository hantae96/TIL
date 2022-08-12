<template>
    <div class = "mainTemplete">

        <div v-for = "(data,i) in blogData" :key="i">
            <h5 @click = "$router.push(`/detail/${i}`)">{{data.title}}</h5>
            <p>{{data.date}}</p>
        </div>

    </div>
</template>

<script>
export default{
    name : "listPage",
    props : {
        blogData : Array
    }
}
</script>

<style>
</style>