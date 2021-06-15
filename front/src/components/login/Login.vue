<template>
  <div>
    <div class="col-lg-5"></div>
    <form class="col-lg-2">
      <h3>Login</h3>
      <div class = "form-group">
        <label> id</label>
        <input type ="id" class= "form-control" placeholder="ID"/>
      </div>

      <div class = "form-group">
        <label>Password</label>
        <input type = "password" class = "form-control" placeholder="Password">
      </div>

      <button class = "btn btn-primary btn-block">login</button>
      <button class = "btn btn-primary btn-block">register</button>
      <img src="@/assets/kakao_login_medium_narrow.png" @click="loginWithKakao()">
      
    </form>
    <div class="col-lg-5"></div>
  </div>
</template>

<script>
export default {
  name:'Login',
  methods: {
    loginWithKakao() {
      const params = {
        redirectUri: "http://localhost:8080/userinfo/auth",
      };
      window.Kakao.Auth.authorize(params);
    },
    loginCheck() {
      if(localStorage.getItem("kakao_71db6ec25973f7a0bd4a8a578dd5f55e")){
        localStorage.clear();
      }
    }
  },
}
</script>

<style>
.input {
  width: 50%;
}
</style>