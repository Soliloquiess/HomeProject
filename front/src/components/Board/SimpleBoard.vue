<template>
<div class="boardList">
    <section class="board">
    <span>QnA</span>
        <li v-for="qna in qnalist" :key="qna.num">
        <span @click="showQna(qna.num)">
            {{ qna.num }}. {{ qna.title }}
        </span>
        </li>
    </section>
    <section class="board">
    <span>NOTICE</span>
        <li v-for="notice in noticelist" :key="notice.num">
        <span @click="showNotice(notice.num)">
            {{ notice.num }}. {{ notice.title }}
        </span>
        </li>
    </section>
    <section class="board">
    <span>NEWS</span>
        <li v-for="news in newslist" :key="news.num">
        <span @click="showNews(news.num)">
            {{ news.num }}. {{ news.title }}
        </span>
        </li>
    </section>
</div>
</template>
<script>
export default {
  name:"SimpleBoard",
  created() {
        console.log(this.$store);
        this.$store.dispatch("ALLQNA");
        this.$store.dispatch("ALLNOTICE");
        this.$store.dispatch("ALLNEWS");
    },
	computed:{
		qnalist(){
			return this.$store.state.qnalist;
		},
    noticelist(){
			return this.$store.state.noticelist;
		},
    newslist(){
			return this.$store.state.newslist;
		}
	},
	methods: {
		// showQna(num) {
		// 	this.$router.push("/detail/" + num);
		// },
	},
}
</script>
<style scoped>
.footer {
  /* position: absolute; */
  top: 1em;
  width: 100%;
  /* text-align: center; */
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  padding: 0em 0em;
  /* color: #ffebee; */
}
div.boardList{
  width: 100%;
  height: 100%;
}
section.board{
  display: inline-block;
  width: 25%;
  height: 100%;
  /* padding: 15%; */
  margin: 10px;
  border: 1px solid black;    
  /* background-color: rgb(22, 141, 238); */
}

li {
  text-align: left;
  padding-left: 5%;
  border-bottom: 1px solid black;
}

</style>
