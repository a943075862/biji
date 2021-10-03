<template>
  <div id="formDiv">

    <el-form :model="user" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="user.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login()">登录</el-button>
      </el-form-item>
    </el-form>

  </div>

</template>

<script>
    export default {
        name: "Login",
      data(){
          return {
            user: {
              userName: '',
              password: ''
            }
        }
      },
      methods: {
          login() {
            let url ='http://localhost:80/user/login';
            this.axios.post(url,this.user).then(resp=>{
              var result =resp.data;
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
    padding-left: 700px;
    width: 500px;
  }
</style>
