import Vue from "vue";
import VueRouter from "vue-router";
import HouseInfo from "@/components/house/HouseInfo.vue";
import HouseInfoRead from "@/components/house/HouseInfoRead.vue";
import Login from "@/components/login/Login.vue";
import Auth from "@/components/login/Auth.vue";
import Register from "@/components/login/Register.vue";
import Board from "@/views/Board.vue";
import QnaBoard from "@/components/Board/QnaBoard.vue";
import NoticeBoard from "@/components/Board/NoticeBoard.vue";
import NewsBoard from "@/components/Board/NewsBoard.vue";
import SimpleBoard from "@/components/Board/SimpleBoard.vue";

Vue.use(VueRouter);

const routes = [
  // {
  //   path: "/",
  //   name: "Home",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ "../views/Home.vue"),
  // },
  { path: "/houseinfo", component: HouseInfo },
  { path: "/houseinforead/:no", component: HouseInfoRead },

  { path: '/userinfo/login', component: Login },
  { path: '/userinfo/auth', component: Auth },
  { path: '/userinfo/register', component : Register},
  
  { path: '/board', component: Board,SimpleBoard },
  { path: '/board/qna', component: QnaBoard },
  { path: '/board/notice', component: NoticeBoard },
  { path: '/board/news', component: NewsBoard },


  /////////////////////////////////////////////////////////////////////////////////////////////

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
