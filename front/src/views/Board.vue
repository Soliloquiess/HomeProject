<template>
    <div id="board">
        <span>
            <router-link to="/board/qna">QnA</router-link> | 
            <router-link to="/board/news">관련 뉴스</router-link> | 
            <router-link to="/board/notice">공지사항</router-link>
        </span>
        <SimpleBoard/>
    </div> 
</template>

<script>
import SimpleBoard from "../components/Board/SimpleBoard.vue";
export default {
    components: {
        SimpleBoard,
    },
}
</script>

<style>

</style>