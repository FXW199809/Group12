<template>
<div class="Select">
<div class="center clearfix">
        <div id="center-top" style="margin-top: 15px;">
            <el-date-picker
              v-model="value2"
              type="month"
              placeholder="选择月" @change="filDate">
            </el-date-picker>
              <!--查询框-->
            <el-input placeholder="请输入职工号进行查询" v-model="UserId" class="input-with-select">
                <el-button slot="append" icon="el-icon-search" @click="doGet()"></el-button>
            </el-input>
        </div>
        <div class="table-center">
        <el-table :data="salary" style="width: 100%">
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
            <el-table-column fixed prop="yearMonthDate" label="时间" width="79"> </el-table-column>
    </el-table>
    </div>
    <div class="selectCenter"></div>
    </div>
</div>
</template>
<script>
import Vue from 'vue';
import moment from "moment";
export default {
  data() {
        return {
           date:"",
           week:"",
           salary: [],
           salaryConst: [],
           timer:null,
           itemList:[],
           resData:[],
           postData:[],
           UserId:'',
           value2: '',
        }
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
        filDate() {
          //this.doGet();
          //获取选择的日期并且转换成YYYY-MM-DD格式
          var filtDate = moment(this.value2).format("YYYY-MM-DD");
          //提取月份并+1
          var secondDate = parseInt(filtDate.slice(5,7));
          //console.log(filtDate);
            console.log(secondDate);
            var dataTable = this.salaryConst.filter(dataTable => {
              var nowDate = dataTable.yearMonthDate;
              return parseInt(nowDate.slice(5,7)) == parseInt(filtDate.slice(5,7)) || parseInt(nowDate.slice(5,6)) == parseInt(filtDate.slice(5,7));
              //大于等于开始日期或者小于等于结束日期
            });
            this.salary = dataTable;
        },
        doGet(){
        // 发起get请求, {params:{ userId: document.getElementById("userId") }}
          Vue.axios.get('/getStaffSearch', {params:{ UserId: this.UserId }}).then((response) => {
            // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
            this.salary = response.data;
            this.salaryConst = response.data;
            //console.log(response.data.tSalary[0])
          }).catch((error) => {
            // catch 指请求出错的处理
            //console.log(error);
            console.log("nooooooo");
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
/**************中部*/
.center {
    width: 80%;
    margin: 0 auto;
}
.el-input {
        width: 230px;
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


/**************************查询工资前端样式**********************/
.selectCenter{
    width: 800px;
    height: 220px;
    margin: 0 auto;
}
#center-top p{
    padding-top: 20px;
    padding-left: 40px;
    font-size: 20px;
    font-weight: bold;
}
</style>