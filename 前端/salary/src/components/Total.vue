<template>
   <div class="Total">
       <p>用户行为统计</p><hr>
       <div class="Total1">
    <div class="top">
        <div class="modle Page"><br>页面访问<br>{{Page}}次</div>
        <div class="modle CodeError"><br>代码异常<br>{{CodeError}}次</div>
        <div class="modle DianJi"><br>点击次数<br>{{DianJi}}次</div>
        <div class="modle QueryError"><br>请求异常<br>{{QueryError}}次</div>
        <div class="modle InputData"><br>输入数据<br>{{InputData}}次</div>
    </div>
    <el-table 
    :data="census.slice((currpage-1)*pagesize,currpage*pagesize)" 
    min-height="350" 
    style="width: 100%;"
    :header-cell-style="{background:'#eef1f6',color:'#606266'}">
            <el-table-column prop="id" label="#" width="50"> </el-table-column>
            <el-table-column prop="etme" label="时间点" width="150"> </el-table-column>
            <el-table-column prop="path" label="页面" width="166"> </el-table-column>
            <el-table-column prop="type" label="动作" width="150"> </el-table-column>
            <el-table-column prop="classname" label="元素id/class" width="150"> </el-table-column>
            <el-table-column prop="Value" label="值" width="400"> </el-table-column>
    </el-table>
    <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currpage"
                :page-size="pagesize"
                layout="total, sizes, prev, pager, next, jumper"
                :total= "census.length">
            </el-pagination>
</div>
    </div>
</template>
<script>
import Vue from 'vue'
export default Vue.extend({
    data() {
        return {
            Page:'',
            CodeError:'',
            DianJi:'',
            QueryError:'',
            InputData:'',
            census:[],
            pagesize: 10,
            currpage: 1
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
    //获取用户行为数据
    getCensus(){
        //获取表格数据
        Vue.axios.get('/getcensusList').then((response) => (
        // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
            this.census = response.data
            //console.log(response.data.tSalary[0])
        )).catch((error) => {
        // catch 指请求出错的处理
        //console.log(error);
        console.log("nooooooo");
        });
        //获取页面访问次数
        Vue.axios.get('/getPage').then((response) => (
            this.Page = response.data
        )).catch((error) => {
        console.log("nooooooo");
        });
        //获取代码异常次数
        Vue.axios.get('/CodeError').then((response) => (
            this.CodeError = response.data
        )).catch((error) => {
        console.log("nooooooo");
        });
        //获取点击次数次数
        Vue.axios.get('/DianJi').then((response) => (
            this.DianJi = response.data
        )).catch((error) => {
        console.log("nooooooo");
        });
        //获取请求异常次数
        Vue.axios.get('/PageError').then((response) => (
            this.QueryError = response.data
        )).catch((error) => {
        console.log("nooooooo");
        });
        //获取输入数据次数
        Vue.axios.get('/InputData').then((response) => (
            this.InputData = response.data
        )).catch((error) => {
        console.log("nooooooo");
        });
    }      
  },
  mounted: function(){
      this.getCensus();
  }
})
</script>
<style scoped>
.Total{
    width: 80%;
    margin-left: 10%;
}
.modle{
    margin-top: 10px;
    margin-left: 15px;
    margin-right: 15px;
    margin-bottom: 10px;
    display: inline-block;
    height: 80px;
    width: 15%;
    font-family: '楷体';
}
.Page{
    background-color: thistle;
}
.CodeError{
    background-color: darkseagreen;
}
.DianJi{
    background-color: cornsilk;
}
.QueryError{
    background-color: rosybrown;
}
.InputData{
    background-color: plum;
}
</style>