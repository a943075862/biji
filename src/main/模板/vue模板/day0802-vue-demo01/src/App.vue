<template>
  <div id="app">

    <span>
      <router-link to="/home">首页</router-link>
      <router-link to="/user/10">用户页</router-link>
      <router-link to="/login">登录</router-link>
      <router-link to="/register">注册</router-link>
    </span>

    <hr>
    <!--  定义路由出口-->
    <router-view/>
  </div>


</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
