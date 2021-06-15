<template>
  <div>
    <h3>Auth</h3>
    <div v-if="logincheck == 0">
        <div class="text-right">
            <span>로그인 해주세요</span>
            <button class="btn btn-primary" @click="login">로그인</button>
        </div>
    </div>
    <div v-else>
        <div class="text-right">
            <span> {{name}} 님 환영합니다</span>
            <button class="btn btn-primary" @click="change">개인정보 변경</button>
            <button class="btn btn-primary" @click="logout">로그아웃</button>
        </div>
    </div>
  </div>
</template>

<script>import { getKakaoToken, getKakaoUserInfo } from "../../service.js";

import axios from "axios";
const storage = window.sessionStorage;

export default {
    name: 'Auth',
    created() {

  if (storage.getItem("kind") != 0) this.logincheck = storage.getItem("kind");
        this.nickname = storage.getItem("nickname");
        console.log("login created" + this.logincheck);
        if (this.logincheck == 1) this.getdata();

        if (this.$route.query.code) {
            this.setKakaoToken();
        }
    },

    data() {
        return {
            logincheck: 0,
            nickname: "ssafy",
        };
    },
    
    methods: {
        getdata() {
            axios.get("http://localhost:9999/happyhouse/userinfoR/getkakao").then(({ data }) => {
                console.log(data);
                storage.setItem("data", JSON.stringify(data.data));
                storage.setItem("token", data.data.token);
                storage.setItem("id", data.data.id);
                storage.setItem("nickname", data.data.nickname);
                this.nickname = storage.getItem("nickname");
            });
        },



        async setKakaoToken () {
            console.log('카카오 인증 코드', this.$route.query.code);
            const { data } = await getKakaoToken(this.$route.query.code);
            if (data.error) {
                alert('카카오톡 로그인 오류입니다.');
                this.$router.replace('/login');
                return;
            }
            window.Kakao.Auth.setAccessToken(data.access_token);
            // this.$cookies.set('access-token', data.access_token, '1d');
            // this.$cookies.set('refresh-token', data.refresh_token, '1d');
            await this.setUserInfo();
            
        },
        async setUserInfo () {
            const res = await getKakaoUserInfo();
            const userInfo = {
                name: res.kakao_account.profile.nickname,
                platform: 'kakao',
            };
            this.$store.commit('setUser', userInfo);
        },
        login() {
            storage.setItem("kind", 1);
            location.href = "http://localhost:9999/happyhouse/userinfo/kakaoLogin";
        },
        move() {
            location.href = "http://localhost:8080";
        },
        join() {
            this.$router.push("/userinfo/normaljoin");
        },
        
    }
}
</script>

<style>

</style>