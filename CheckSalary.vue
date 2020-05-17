<template>
    <div>
        <div class="ttop">
            <div id="topimg">
            <a target="_blank" class="p4">财务管理员
                {{ this.info }}
            </a>
            <a target="_blank" class="p5">登录/退出登录</a>
            </div>
        </div>

        <div class="top">
            <div class="topinside">
            <!-- <input type="button" class="btn" value="主页">
            <input type="button" class="btn" value="账号管理">
            <input type="button" class="btn" value="提交表单">
            <input type="button" class="btn" value="查看账单"> -->
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
                 <el-menu-item index="Payhome" class="btn" @click="skip('Payhome')">主页</el-menu-item>
                <el-menu-item index="ManageUser2" class="btn" @click="skip('ManageUser2')">账号管理</el-menu-item>
                <el-menu-item index="SendDoc" class="btn" @click="skip('SendDoc')">提交表单</el-menu-item>
                <el-menu-item index="details" class="btn" @click="skip('details')">查看账单</el-menu-item>
            </el-menu>
            </div>
        </div>

     <div class="center clearfix">
        <div id="send">
        
            <div id="main">
            <form action="" method="get">
                <h3>查看我的工资信息：</h3><br/>
                <label><input name="File" type="radio" value=""/>我的工资信息</label><br/><br/>
            </form>
                <h4>我的工资：</h4>
                    <table id="customers">
<tr>
<th>时间</th>
<th>职工号</th>
<th>姓名</th>
<th>基本工资</th>
<th>职务工资</th>
<th>工龄工资</th>
<th>补贴</th>
<th>扣款</th>
<th>实发工资</th>
</tr>

 <tr>
<td>Bill Gates</td>
<td>Bill Gates</td>
<td>Bill Gates</td>
<td>Bill Gates</td>
<td>Bill Gates</td>
<td>Bill Gates</td>
<td>Bill Gates</td>
<td>555 77 854</td>
<td>555 77 855</td>
</tr>

                    </table>
                   

            <button>打印我的工资</button>
        

        </div>

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
    </div>

</template>

<script>
export default {
  data() {
        return {
           date:"",
           week:"",
           info: {},
           timer:null
        }
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
        postInfo: function(){
            this.$axios.get('http://localhost:8080')
            .then(response => (this.info = response))
            .catch(function (error) {
                console.log(error);
                });
            },
        skip(a){
            this.$router.push(a)
            },
        handleSelect(key, keyPath) {
            console.log(this);
            console.log(key, keyPath);
        }
        
  }
}
</script>

<style scoped>
/**************最上面的部分**************/
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

/*************顶部*********************/
.top {
    width: 100%;
    height: 30px;
    background-color: #01836c;
}
.topinside {
    width: 1000px;
    height: 100%;
    margin: 0 auto;
    background-color: #01836c;
}

.btn {
    background-color: #01836c;
    width: 250px;
    height: 30px;
    padding: 0;
    border: 0;
    text-align: center;
    font-size: 17px;
    float: left;
    line-height: 30px;
    color: white;
}
.el-menu {
    background-color: #01836c;
}
.btn2 {
    background-color: #01836c;
    width: 166px;
    height: 30px;
    padding: 0;
    border: 0;
    text-align: center;
    font-size: 17px;
    float: left;
    line-height: 30px;
    color: white;
}



/**************中部****************/
.center {
    width: 1100px;
    margin: 0 auto;
}
#left_side {
    float: left;
    width: 476px;
    height: 310px;
    margin-top: 74px;
    margin-left: 50px;
    margin-bottom: 74px;
    background: url("../assets/image1.png") 100%/100% no-repeat;
}
#right_side {
    float: left;
    margin-left: 74px;
    margin-bottom: 74px;
    width: 476px;
    height: 310px;
    margin-top: 74px;
}
.p3 {
    display: inline;
    color: black;
    font-size: 24px;
}
#customers
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#customers td, #customers th 
  {
  font-size:1em;
  border:1px solid #00FFFF;
  padding:1px 1px 2px 7px;
  }

#customers th 
  {
  font-size:1.1em;
  text-align:left;
  padding-top:5px;
  padding-bottom:4px;
  background-color:	#7FFFD4;
  color:#ffffff;
  }

#customers tr.alt td 
  {
  color:#000000;
  background-color:#EAF2D3;
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

/**********清除浮动**************/
.clearfix:after{
    content: "";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
}
.clearfix {
    *zoom: 1;/*ie6清除浮动的方式 *号只有IE6-IE7执行，其他浏览器不执行*/
}


</style>