<template>
  <div>
    <div class="usertable">
      <el-row class="usersavebtn">
            <el-input v-model="input" placeholder="请输入内容" style="width: 50%;">
                <el-button slot="append" icon="el-icon-search" @click="search()"></el-button>
            </el-input>
      </el-row>
      <el-table :data="tableData" stripe="width:100%">
            <el-table-column prop="userId" label="职工号" width="100"> </el-table-column>
            <el-table-column prop="name" label="姓名" width="100"><template slot-scope="scope">
          <div v-html="scope.row.name"></div>
        </template></el-table-column>
            <el-table-column prop="idCard" label="身份证号" width="170"> </el-table-column>
            <el-table-column prop="origin" label="籍贯" width="140"> </el-table-column>
            <el-table-column prop="nation" label="民族" width="140"> </el-table-column>
            <el-table-column prop="degree" label="最高学位" width="140"> </el-table-column>
            <el-table-column prop="email" label="邮箱" width="160"> </el-table-column>
            <el-table-column prop="telephone" label="电话" width="140"> </el-table-column>
            <el-table-column prop="bankCard" label="银行卡" width="200"> </el-table-column>
            <el-table-column prop="department_name" label="所属院系" width="140"> </el-table-column>
            <el-table-column prop="title" label="职称" width="100"> </el-table-column>
            <el-table-column prop="working_age" label="工龄" width="100"> </el-table-column>     
      </el-table>
      <!-- <el-pagination background
      layout="prev,pager,next"
      :total="total"
      :page-size="params.size"
      :current-page="params.page"
      @current-change="changePage"
      style="float: right;"></el-pagination> -->
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import moment from "moment";
  export default{
    data(){
      return{
          input:'',
          tableData:{
          userId:'',
          name:'',
          idCard: '',
          origin: '',
          nation: '', 
          degree: '',
          email:'',
          telephone:'',
          bankCard:'',
          department_name:'',
          title:'',
          working_age:'',
          }
      }
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
    methods:{
      search(){
       Vue.axios.get('http://localhost:8090/search', {params:{ keyword: this.input }}).then((response) => {
            this.tableData = response.data;
          }).catch((error) => {
            console.log(error);
            
          });
      }
    }
  }
  /* export default{


  data(){
    return{
      searchData:""
    }
  },
  } */
</script>

<style>
.el-button{
  height: 40px;
  margin-left: 10px;
}
/*.el-row{
  height: 40px;
  margin: 40px ;

} */
.usertable{
  margin: 0 auto;
  width: 90%;
  position: relative;
}
.usersavebtn{
  height: 80px;
}
</style>
