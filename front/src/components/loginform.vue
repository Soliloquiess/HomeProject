<template>
    <div>
        <div class="form-group">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" ref="id" placeholder="ID를 입력하세요" v-model="id" />
        </div>
        <div class="form-group">
            <label for="pw">PW</label>
            <input type="password" class="form-control" id="pw" ref="pw" placeholder="pw를 입력하세요" v-model="pw" />
        </div>
        <div class="text-right">
            <button class="btn btn-info" @click="checkHandler">로그인</button>
            <button class="btn btn-warning" @click="login">카카오톡 로그인</button>
            <br>
            <button class="btn btn-info" @click="join">회원가입</button>
            <br>
            <img src="@/assets/kakao login.png" @click="move">
            <br>
            <img src="@/assets/kakao.png" @click="loginWithKakao()">
        </div>
    </div>
</template>

<script>
import axios from "axios";
const storage = window.sessionStorage;
export default {
    data() {
        return {
            id: "",
            pw: "",
        };
    },
    methods: {
        checkHandler() {
            let err = true;
            let msg = "";
            !this.id && !this.pw && ((msg = "ID, 비밀번호를 입력해주세요"), (err = false), this.$refs.id.focus());

            if (!err) alert(msg);
            else this.loginHandler();
        },
        loginHandler() {
            axios
                .post("http://localhost:8080/happyhouse/userinfo/Login", {
                    id: this.id,
                    pw: this.pw,
                })
                .then(({ data }) => {
                    console.log(data);
                    storage.setItem("kind", 2);
                    storage.setItem("id", data.data.id);
                    storage.setItem("nickname", data.data.nickname);
                    this.move();
                });
        },
        login() {
            storage.setItem("kind", 1);
            location.href = "http://localhost:8080/happyhouse/userinfo/kakaoLogin";
        },
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
};
</script>

<style></style>
