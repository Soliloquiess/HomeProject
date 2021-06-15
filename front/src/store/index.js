import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userName: '',
    platform: '',
    qnalist:[],
    newslist:[],
    noticelist:[],
    qna:null,
  },
  getters: {
    qna(state) {
      return state.qna;
    },
},
  mutations: {
    setUser(state, payload) {
      state.userName = payload.name;
      state.platform = payload.platform;
    },
    ALLQNA(state, payload){
      state.qnalist = payload.qnalist;
    },
    SHOWQNA:(state,payload)=>{
        state.qna=payload.qna;
    },
    ALLNEWS(state, payload){
      state.newslist = payload.newslist;
    },
    ALLNOTICE(state, payload){
      state.noticelist = payload.noticelist;
    },
  },
  actions: {
    ALLQNA: (store)=>{
      axios
          .get("http://localhost/board/qna/list")
          .then((response)=>{
              store.commit("ALLQNA", {qnalist: response.data});
          })
          .catch((response)=>{
              console.log(response.data);
          });
    },
    SHOWQNA: (store, payload) => {
			console.log(payload);
			axios
				.get("http://localhost/board/qna/list/" + payload.num)
				.then((response) => {
					store.commit("SHOWQNA", { qna: response.data }); //call mutation
				})
				.catch((exp) => alert("조회 처리에 실패하였습니다." + exp));
		},    
    ADDQNA: (store,payload)=>{
        axios
            .post("http://localhost/board/qna/add",payload)
            .then((response)=>{
                console.log(payload);
                console.log(response);
                store.dispatch("ALLQNA");
            })
            .catch(()=>{
                console.log(payload);
            });
    },
    ALLNEWS: (store)=>{
      axios
          .get("http://localhost/board/news/list")
          .then((response)=>{
              store.commit("ALLNEWS", {newslist: response.data});
          })
          .catch((response)=>{
              console.log(response.data);
          });
    },
    ALLNOTICE: (store)=>{
      axios
          .get("http://localhost/board/notice/list")
          .then((response)=>{
              store.commit("ALLNOTICE", {noticelist: response.data});
          })
          .catch((response)=>{
              console.log(response.data);
          });
    },
  },
  modules: {
  }
});