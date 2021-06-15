<template>
    <div id="nav" style="border-bottom:1px solid black;margin-bottom:20px">
    <!-- <div id="nav" :style="{ backgroundImage: 'url(' + require('@/assets/헤더.jpg') + ')' }"> -->
        <span>
        <ul class="main-menu">
        <!-- <li><router-link to="/">홈</router-link></li> -->
        <li><router-link to="/houseinfo">집찾기</router-link></li>
        <li>
        </li>
        <!-- </li> -->
        <li><router-link to="/board/notice">공지사항</router-link></li>
        <li><router-link to="/board/qna">Q&A</router-link></li>

        <li><router-link to="/board/news">News</router-link></li>
        <li><router-link to="/userinfo/login">개인정보</router-link></li>

      </ul>
      
      </span>
        
    </div>
</template>

<script>
import axios from "axios";
export default {    
    methods: {
        checklogin(){

        }
    },
};
</script>

<style scoped>
#header {
    background-repeat: no-repeat;
    background-size: 100%;
    /* background-color: aqua; */
    height: 100px;
    color: black;
}


#nav .main-menu,
.sub-menu {
  margin: 0;
  padding: 0;
  list-style: none;
  display: inline;
}
#nav .main-menu > ul {
  display: inline;
}
#nav .main-menu > li {
  display: inline;
  padding: 30px;
}
#nav .main-menu > li:hover .sub-menu {
  opacity: 1;
  visibility: visible;
}
#nav .main-menu > li > a {
  padding: 8px 16px;
  font-size: 25px;
  text-align: center;
}
</style>


