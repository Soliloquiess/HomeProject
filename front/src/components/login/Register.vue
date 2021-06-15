<template>
  <form  @submit.prevent="handleSubmit">
    <h3> Sign up</h3>
    <div class = "form-group">
      <label>이름</label>
      <!--v-modal: 데이터 바인딩-->
      <input type = "text" class = "form-control" v-modal="first_name" placeholder="이름"/>
    </div>

    <div class = "form-group">
      <label>성</label>
      <input type = "text" class = "form-control" v-modal="last_name" placeholder="성"/>
    </div>

    <div class = "form-group">
      <label>이메일</label>
      <input type = "email" class = "form-control" v-modal="email" placeholder="E-mail"/>
    </div>

    <div class = "form-group">
      <label>비밀번호</label>
      <input type = "password" class = "form-control"  v-modal="password" placeholder="비밀번호"/>
    </div>

    <div class = "form-group">
      <label>비밀번호 확인</label>
      <input type = "password" class = "form-control" v-modal="password_confirm" placeholder="비밀번호 확인"/>
    </div>    

    <button class = "btn btn-primary btn-block">Sign up</button>
  </form>
</template>

<script>
export default {
  name : 'Register',

  data(){ //변수저장
    return{
      first_name:'',
      last_name:'',
      email:'',
      password:'',
      password_confirm:''
    }

  },
  methods:{
    handleSubmit(){ //이벤트 등록
      const data = {  //json객체로 넘김
        first_name : this.first_name,
        last_name : this.last_name,
        email : this.email,
        password : this.password,
        password_confirm:this.password_confirm
      }
      console.log(data);
    }
  }
}

</script>

<style>
.input {
  width: 50%;
}
</style>