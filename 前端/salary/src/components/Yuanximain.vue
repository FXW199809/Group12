<template>
  <div class="hello">
    <div class="ttop">
        <div id="topimg">
            <a target="_blank" class="p4">院系管理员
                {{ this.resData }}
            </a>
            <router-link class="p5" to="/"><i class="el-icon-right"></i>退出登录</router-link>
        </div>
    </div>
  <div class="head">
        <router-link to="/Yuanximain">主页</router-link>
        <router-link to="/Senddoc">提交表单</router-link>
        <router-link to="/details">查看账单</router-link>
        <router-link to="/Yuanxi/ChangeInfo">个人信息修改</router-link>
  </div>
  <div class="center">
    <router-view></router-view>
  </div>
  <div class="foot">
        <p>
            <a class="p1" target="_blank">
                <i class="icon"></i>
                四川师范大学官方微博
            </a>
        </p>
        <br>
        <p class="p2">2017级4班第12小组版权所有（技术支持：2017级4班第12小组）联系电话：028-8488888</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Yuanximain'
}
</script>
<style scoped>
/* logo部分 */
.ttop {
    width: 100%;
    height: 117px;
    background-color: #d7d7d7;
}
#topimg {
    background: url("../assets/top.png") 100%/100%  no-repeat;
    margin: 0 auto;
    width: 1000px;
    height: 117px;
}
.p4 {
    display: inline-block;
    margin-top: 45px;
    font-weight: bold;
    margin-left: 600px;
    color: black;
    font-size: 17px;
}
.p5 {
    margin-left: 100px;
    font-size: 13px;
    color: #2e77e6;
}
/* 导航栏部分 */
.head{
    background-color: #01836c;
    line-height: 35px;
    text-align: center;
    margin: auto;
    left: 20%;
}
.head > a{
    display: inline-block;
    color: white;
    text-decoration: none;
    width: 15%;
    border: 1px solid #01836c;
}
.head > a:hover{
    color: #01836c;
    background-color: #fff;
}
/*center*/
.center{
    min-height: 450px;
}


/******************底部****************/
.foot {
    width: 100%;
    height: 120px;
    background-color: #01836c;
    color: #88c674;
    text-align: center;
}
.icon {
    display: inline-block;
    background: url("../assets/icon1.png") 100%/100% no-repeat;
    width: 20px;
    height: 20px;
}
.p1 {
    font-size: 14px;
    color: #88c674;
    text-decoration: none;
}
.p2 {
    font-size: 10px;
}
</style>