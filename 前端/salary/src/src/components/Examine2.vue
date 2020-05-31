<template>
    <div class="Examine2">
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
              
              
            <el-table :data="Subsidy.slice((currpage-1)*pagesize,currpage*pagesize)" style="width: 100%" max-height="550">
                <el-table-column fixed prop="id" label="id" width="120"> </el-table-column>
                <el-table-column prop="userId" label="职工号" width="120"> </el-table-column>
                <el-table-column prop="name" label="姓名" width="120"> </el-table-column>
                <el-table-column prop="food" label="副食补贴" width="120"> </el-table-column>
                <el-table-column prop="coal" label="煤油补贴" width="120"> </el-table-column>
                <el-table-column prop="transport" label="交通补贴" width="120"> </el-table-column>
                <el-table-column prop="subsidy1" label="备补1" width="120"> </el-table-column>
                <el-table-column prop="subsidy2" label="备补2" width="120"> </el-table-column>
                <el-table-column prop="subsidyTotal" label="补贴总计" width="120"> </el-table-column>
                <el-table-column prop="submitUserId" label="申请人职工号" width="120"> </el-table-column>
                <el-table-column prop="submitDate" label="提交日期" width="120"> </el-table-column>
                <el-table-column fixed="right" label="操作" width="120">
                    <template slot-scope="scope">
                        <el-button
                            @click.native.prevent="deleteRow(scope.$index, Subsidy)" @click="ratify(scope.row.id)" type="text" size="small">
                            批准
                        </el-button>
                        <el-button
                            @click.native.prevent="deleteRow(scope.$index, Subsidy)" @click="reject(scope.row.id)" type="text" size="small">
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
                :total= "Subsidy.length">
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
           Subsidy: [],
           pagesize: 10,
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
            Vue.axios.get('/updateSubsidyStatus', {
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
            Vue.axios.get('/updateSubsidyStatus', {
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
        getSubsidyList(){
            Vue.axios.get('/getSubsidyList').then((responce)=>(
                this.Subsidy = responce.data
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
      this.getSubsidyList();
  }
}
</script>
<style scoped>
.Examine2{
    width: 80%;
    margin-left: 10%;
}

</style>