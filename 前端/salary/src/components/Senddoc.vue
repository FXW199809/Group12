<template>
  <div class="Senddoc">
    <div class="left">
      <router-link to="/Senddoc"><el-button><i class="el-icon-edit">点击填写员工扣款清单</i></el-button></router-link>
      <router-link to="/doc2"><el-button><i class="el-icon-edit">点击填写员工补贴清单</i></el-button></router-link>
      <router-link to="/doc3"><el-button><i class="el-icon-edit">点击填写员工变动清单</i></el-button></router-link>
      <router-link to="/doc4"><el-button><i class="el-icon-edit">点击填写员工出错清单</i></el-button></router-link>
    </div>
    <div class="right">
      <router-view></router-view>
    </div>
  </div>
</template>
<style scoped>
.Senddoc{
  width:80%;
  margin: 0 auto;
  min-height: 500px;
  padding: 0;
}
.left{
  display: inline-block;
  width: 20%;
  margin-top: 10px;
  vertical-align: top;
  height: 100%;
  border: 2px solid #ccc;
  border-radius: 5px;
  padding-top: 10px;
  padding-bottom: 30px;
  background-color: rgb(165, 189, 174);
}
.el-button{
  margin-top: 10px;
}
.right{
  display: inline-block;
  width: 75%;
  margin-top: 10px;
  top:0px;
  vertical-align: top;
  border: 3px solid #ccc;
  border-radius: 7px;
  height: 100%;
}
</style>