<template>
    <div>
      <h1>用户界面</h1>
      <p>{{user.id}}</p>
    </div>
</template>

<script>
    export default {
        name: "User",
      data(){
          return{
            user:{
              id:this.$route.params.id,//获取路由参数   id: 就是路由表注册路由信息时path的路径参数
            }
          }
      }
    }
</script>

<style scoped>

</style>
