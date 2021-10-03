<template >

  <div id="formDiv" >
    <el-form :model="user" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="user.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="user.name"></el-input>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="user.age"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="user.email"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="register()">注册</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
    export default {
        name: "Register",
        data () {
           return {
            user: {
              userName:'',
              password:'',
              name: '',
              age: '',
              email: ''
              }
           }
        },
      methods:{
          register(){
            let url ='http://localhost:80/user/save';
            this.axios.post(url,this.user).then(resq=>{
              console.log(resq)
              var result =resq.data;
              console.log(result)
              if (result.success){
                this.$message({
                  message:result.message,
                  type:'success'
                });
                this.user=result.data;
                setTimeout(() => {
                  this.$router.push({path:'/home'})
                },500);
              } else {
                if (result.data == null) {
                  this.$message.error(result.message);
                } else {
                  this.$message.error(result.message + ":" + result.data);
                }
              }
            }).catch(error=>{
              alert(error);
            });
          }
      }
    }
</script>

<style scoped>
  #formDiv{
    padding-left:500px;
    width: 500px;

  }
</style>
