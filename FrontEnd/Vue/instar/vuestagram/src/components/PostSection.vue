<template>
    <div>
        <div class="post">
            <div class="post-header">
                <div class="profile"></div>
                <span class="profile-name">{{UserData.name}}</span>
            </div>
            <div class="post-body" :style = "{backgroundImage : `url(${UserData.postImage})`}"></div>
            <div class="post-content">
                <p>{{`${UserData.likes} Likes ❤`}}</p>
                <p><strong>글쓴이아이디</strong> {{UserData.content}}</p>
                <p class="date">{{UserData.date}}</p>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    props : {
        UserData : Object,
        number : Number,
    }
}
</script>
<style>
.post {
    width: 100%;
}

.profile {
    background-image: url("https://placeimg.com/100/100/arch");
    width: 30px;
    height: 30px;
    background-size: 100%;
    border-radius: 50%;
    float: left;
}

.profile-name {
    display: block;
    float: left;
    padding-left: 10px;
    padding-top: 7px;
    font-size: 14px;
}

.post-header {
    height: 30px;
    padding: 10px;
}

.post-body {
    background-image: url("https://placeimg.com/640/480/animals");
    height: 450px;
    background-position: center;
    background-size: cover;
}

.post-content {
    padding-left: 15px;
    padding-right: 15px;
    font-size: 14px;
}

.date {
    font-size: 11px;
    color: grey;
    margin-top: -8px;
}
</style>