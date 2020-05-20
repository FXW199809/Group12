<template>
  <div>
    hello登录成功<el-button type="text" @click="logout">退出</el-button><el-button type="text" @click="change">修改密码</el-button>
  </div>
</template>

<script>
  export default{
    methods:{
      logout(){
        window.sessionStorage.clear();
        this.$router.push('/login');
      },
      change(){
        this.$router.push('/change');
        /* this.$message.info("联系管理员修改密码"); */

      }
    }
  }
</script>

<style>
  #app{
    background-image: url(../assets/zhmm.jpg);
  }
  .el-button{
    height: 50px;
  }
</style>
