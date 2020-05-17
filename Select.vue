<template>
<div class="Select">
<div class="center clearfix">
        <div id="center-top" style="margin-top: 15px;">
            <!--查询框-->
            <el-input placeholder="请输入职工号进行查询" v-model="UserId" class="input-with-select">
                <el-button slot="append" icon="el-icon-search" @click="doGet"></el-button>
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
            <el-table-column prop="yearMonthDate" label="时间" width="79"> </el-table-column>
    </el-table>
    </div>
    <div class="selectCenter"></div>
    </div>
</div>
</template>
<script>
import Vue from 'vue';
export default {
  data() {
        return {
           date:"",
           week:"",
           salary: [],
           timer:null,
           itemList:[],
           resData:[],
           postData:[],
           UserId:''
        }
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
        /*postInfo: function(){
            //this.$api.post('user/login.do(地址)', {
            Vue.axios.get('http://www.mocky.io/v2/5eaf8c923300007e829f4456', {
                "userId": "111"
            }, response => {
            if (response.status >= 200 && response.status < 300) {
                console.log(response.data);//请求成功，response为成功信息参数
                this.info = response.data;
            } else {
                console.log(response.message);//请求失败，response为失败信息
            }
            });
        },*/
        doGet(){
        // 发起get请求, {params:{ userId: document.getElementById("userId") }}
        Vue.axios.get('/getStaffSearch', {params:{ UserId: this.UserId }}).then((response) => (
          // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
         this.salary = response.data
         //console.log(response.data.tSalary[0])
        )).catch((error) => {
          // catch 指请求出错的处理
          //console.log(error);
          console.log("nooooooo");
        });
      },
      /*,
      doPost(){
        // 提示：该方式传递的参数是json格式，如上传不成功，需检查后台接收的方式是不是application/x-www-form-urlencoded默认格式，jquery中ajax请求的就是application/x-www-form-urlencoded，后台需要body-parser解码
        Vue.axios.post('/api/post', {
          // 此参数就是写到请求体中的参数
          stuName: '盖聂',
          height: 180
        }).then((response) => {
          console.log(response);
          console.log(response.data);
          this.postData = response.data;
        }).catch((error) => {
          console.log(error);
        });
      },
      */
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