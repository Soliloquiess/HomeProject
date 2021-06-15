<template>  
  <div>
    <div class="col-lg-3"></div>
    <div class="col-lg-6" style="text-align:center">
      <h1>Q&A</h1>
      <section style="border:1px solid black;">
        <transition-group name="list" tag="ul">
            <li v-for="qna in qnalist" :key="qna.num" class="shadow" style="border-bottom:1px solid black;">
              <!-- <i v-if="todo.done=='Y'" class="checkBtn fas fa-check-circle" aria-hidden="true"></i>
              <i v-else class="checkBtn far fa-check-circle" aria-hidden="true" @click="updateTodo(todo.no)"></i> -->
              <span @click="showQna(qna.num)">
                {{ qna.num }}. {{ qna.title }} 
                {{qna.content}}
              </span>
            </li>
        </transition-group>
      </section>
    </div>
    <div class="col-lg-3"></div>
  </div>
</template>

<script>
export default {
  created() {
		console.log(this.$store);
		this.$store.dispatch("ALLQNA");

	},
	computed:{
		qnalist(){
			return this.$store.state.qnalist;
		}
	},
	methods: {
		showQna(num) {
			//화면이 바뀌어야 함
			this.$router.push("/detail/" + num);
		},
	},
}
</script>
<style scoped>
	.del {
		text-decoration: line-through;
	}
	ul {
		list-style-type: none;
		padding-left: 0px;
		margin-top: 0;
		text-align: left;
	}
	li {
		display: flex;
		min-height: 50px;
		height: 50px;
		line-height: 50px;
		margin: 0.5rem 0;
		padding: 0 0.9rem;
		background: white;
		border-radius: 5px;
	}
	.checkBtn {
		line-height: 45px;
		color: #62acde;
		margin-right: 5px;
	}
	.removeBtn {
		margin-left: auto;
		color: #de4343;
	}

	.list-enter-active,
	.list-leave-active {
		transition: all 1s;
	}
	.list-enter,
	.list-leave-to {
		opacity: 0;
		transform: translateY(30px);
	}
</style>