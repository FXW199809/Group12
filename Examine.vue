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
                <el-menu-item index="ManageFrame" class="btn2" @click="skip('ManageFrame')">主页</el-menu-item>
                <el-menu-item index="ManageUser1" class="btn2" @click="skip('ManageUser1')">账号管理</el-menu-item>
                <el-menu-item index="3" class="btn2" @click="skip('Examine')">工资发放</el-menu-item>
                <el-menu-item index="Select" class="btn2" @click="skip('Select')">员工查询</el-menu-item>
                <el-menu-item index="3" class="btn2" @click="skip('ChangeInfo')">个人信息修改</el-menu-item>
                <el-menu-item index="ChangeInfo" class="btn2">数据汇总</el-menu-item>
            </el-menu>
        </div>
    </div>
        <div class="center clearfix"> 
            <div id="nav">
                <el-row>
                    <el-button type="info" plain @click="skip('Examine')">工资变动审核</el-button>
                    <el-button type="info" plain @click="skip('Examine2')">补贴审核</el-button>
                    <el-button type="info" plain @click="skip('Examine3')">扣款审核</el-button>
                    <el-button type="info" plain @click="skip('Examine4')">出错信息审核</el-button>
                    <el-button type="info" plain @click="skip('Examine5')">工资审核</el-button>
                </el-row>

                <!--<ul>
                    <li><input class="examine" type="button"  value="工资变动审核"></li>
                    <li><input class="examine" type="button" @click="skip('Examine2')" value="补贴审核"></li>
                    <li><input class="examine" type="button" @click="skip('Examine3')" value="扣款审核"></li>
                    <li><input class="examine" type="button" @click="skip('Examine4')" value="出错信息审核"></li>
                    <li><input class="examine" type="button" @click="skip('Examine5')" value="工资审核"></li>
                </ul>
                -->
            </div>   
            
            <el-table :data="change.slice((currpage-1)*pagesize,currpage*pagesize)" style="width: 100%" max-height="550">
                <el-table-column fixed prop="id" label="id" width="120"> </el-table-column>
                <el-table-column prop="userId" label="职工号" width="120"> </el-table-column>
                <el-table-column prop="name" label="姓名" width="120"> </el-table-column>
                <el-table-column prop="beforeMoney" label="改动前工资" width="120"> </el-table-column>
                <el-table-column prop="afterMoney" label="改动后工资" width="120"> </el-table-column>
                <el-table-column prop="submitUserId" label="申请职工号" width="120"> </el-table-column>
                <el-table-column prop="submitDate" label="提交日期" width="120"> </el-table-column>
                <el-table-column fixed="right" label="操作" width="120">
                    <template slot-scope="scope">
                        <el-button
                            @click.native.prevent="deleteRow(scope.$index, change)" @click="ratify(scope.row.id)" type="text" size="small">
                            批准
                        </el-button>
                        <el-button
                            @click.native.prevent="deleteRow(scope.$index, change)" @click="reject(scope.row.id)" type="text" size="small">
                            驳回
                        </el-button>
                    </template>
                </el-table-column>
            </el-table> 
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currpage"
                :page-size="pagesize"
                layout="total, sizes, prev, pager, next, jumper"
                :total= "change.length">
            </el-pagination>
            <div class="examineCenter">

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

</template>

<script>
import Vue from 'vue'
export default {
  data() {
        return {
           date:"",
           week:"",
           info: {},
           timer:null,
           tabPosition: 'left',
           change: [],//存放查询到的数据集
           pagesize:10,
           currpage: 1
        }
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
      //每页条数改变时触发
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.pagesize = val;
      },
      //当前页面改变时触发
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.currpage = val;
      },
        ratify(value){
            Vue.axios.get('/updateChangeStatus', {
                params: {
                    id: value,
                    status: 1
                }
            }).then((responce)=>(
                //this.change = responce.data
                console.log("ok")
            )).catch((error)=>{
                console.log(error);
            })
        },
        reject(value){
            Vue.axios.get('/updateChangeStatus', {
                params: {
                    id: value,
                    status: 2
                }
            }).then((responce)=>(
                console.log("ok")
            )).catch((error)=>{
                console.log(error);
            })
        },
        deleteRow(index, rows) {
            rows.splice(index, 1);
        },
        getChangeList(){
            Vue.axios.get('/getChangeList').then((responce)=>(
                this.change = responce.data
            )).catch((error)=>{
                console.log(error);
            })
        },
        skip(a){
            this.$router.push(a)
            },
        handleSelect(key, keyPath) {
            console.log(this);
            console.log(key, keyPath);
        }
        
  },
  mounted:function(){
      this.getChangeList();
  }
}
</script>
<style scoped>
    @import "../css/examines/change-audit.css";
    @import "../css/PayFrame.css";

</style>
<style lang="less">
    /*********通过.el-card /deep/ 可以只更改当前页面的元素样式
el-card__body可以在浏览器中找到 不能加scoped,否则改变不了样式  
********************/  
.el-row{ 
    width: 150px;
    /deep/.el-button{
        width: 150px;
        padding: 10px;
        margin: 0;
    }
    //去掉刷新页面时自带的margin
    /deep/.el-button+.el-button{
        margin: 0;
    }
}
.el-table{
    margin-top: 30px;
}

</style>