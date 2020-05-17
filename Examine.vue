<template>
    <div class="Examine">
        <div class="center clearfix"> 
            <div id="nav" style="margin-top: 15px;">
                <el-row>
                    <el-button type="info" plain @click="skip('Examine')">工资变动审核</el-button>
                    <el-button type="info" plain @click="skip('Examine2')">补贴审核</el-button>
                    <el-button type="info" plain @click="skip('Examine3')">扣款审核</el-button>
                    <el-button type="info" plain @click="skip('Examine4')">出错信息审核</el-button>
                    <el-button type="info" plain @click="skip('Examine5')">工资审核</el-button>
                </el-row>
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
.Examine{
    width: 80%;
    margin-left: 10%;
}

</style>