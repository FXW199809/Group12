<template>
    <div class="SalaryGather">
    <div class="center clearfix">
            <el-table :data="salary" height="250" border style="width: 100%">
            <el-table-column prop="userId" label="职工号" width="79"> </el-table-column>
            <el-table-column prop="name" label="姓名" width="79"> </el-table-column>
            <el-table-column prop="baseSalary" label="基本工资" width="79"> </el-table-column>
            <el-table-column prop="jobSalary" label="职务工资" width="79"> </el-table-column>
            <el-table-column prop="workingAgeSalary" label="工龄工资" width="79"> </el-table-column>
            <el-table-column prop="food" label="副食补贴" width="79"> </el-table-column>
            <el-table-column prop="coal" label="煤油补贴" width="79"> </el-table-column>
            <el-table-column prop="transport" label="交通补贴" width="79"> </el-table-column>
            <el-table-column prop="subsidy1" label="备补1" width="79"> </el-table-column>
            <el-table-column prop="subsidy2" label="备补2" width="79"> </el-table-column>
            <el-table-column prop="sumSalary" label="应发工资" width="79"> </el-table-column>
            <el-table-column prop="room" label="房费" width="79"> </el-table-column>
            <el-table-column prop="waterElectric" label="水电费" width="79"> </el-table-column>
            <el-table-column prop="children" label="托儿费" width="79"> </el-table-column>
            <el-table-column prop="advance" label="借支扣款" width="79"> </el-table-column>
            <el-table-column prop="other" label="其他扣款" width="79"> </el-table-column>
            <el-table-column prop="deductTotal" label="扣款总计" width="79"> </el-table-column>
            <el-table-column prop="takeHomeSalary" label="实发工资" width="79"> </el-table-column>
            <el-table-column prop="yearMonthDate" label="时间" width="79"> </el-table-column>
    </el-table>
        <div class="GatherCenter">
        </div>
    </div>
    </div>

</template>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>

    import Vue from 'vue'
export default {
  data() {
        return {
           date:"",
           week:"",
           info: {},
           timer:null,
           salary:[],
           dialogFormVisible: false,
            form: {
            address: '',
            name: '',
            region: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
            },
            formLabelWidth: '120px',
        }
        
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
        
        skip(a){
            this.$router.push(a)
            },
        handleSelect(key, keyPath) {
            console.log(this);
            console.log(key, keyPath);
        },
        getSalarySearch(){
            Vue.axios.get('/getSalarySearch').then((response) => (
                // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                this.salary = response.data
                //console.log(response.data.tSalary[0])
            )).catch((error) => {
                // catch 指请求出错的处理
                //console.log(error);
                console.log("nooooooo");
            });
        },
        
        
        
  },
  mounted: function(){
      this.getSalarySearch();
  }
  
}
</script>

<style scoped>
.SalaryGather{
    margin: 0 auto;
}
/**************************查询工资前端样式**********************/
.center{
    width: 80%;
    margin-left: 10%;
}
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