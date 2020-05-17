<template>
<div id="Managemessage">
    <div class="add" style="margin-top: 15px;">
      <el-button type="info">
        <router-link to="/InsertStaff"><i class="el-icon-plus"></i>点击新增员工</router-link></el-button>
    </div>
    <div class="table-center">
      <el-table 
      :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)" 
      style="width: 100%" 
      ref="multipleTable"
      tooltip-effect="dark"
      @selection-change="handleSelectionChange">
            <el-table-column prop="userId" label="职工号" width="100"> </el-table-column>
            <el-table-column prop="name" label="姓名" width="100"> </el-table-column>
            <el-table-column prop="password" label="密码" width="140"> </el-table-column>
            <el-table-column prop="email" label="邮箱" width="160"> </el-table-column>
            <el-table-column prop="telephone" label="电话" width="140"> </el-table-column>
            <el-table-column prop="BankCard" label="银行卡" width="200"> </el-table-column>
            <el-table-column prop="department_name" label="所属院系" width="140"> </el-table-column>
            <el-table-column prop="title" label="职称" width="100"> </el-table-column>
             <el-table-column prop="working_age" label="工龄" width="100"> </el-table-column>
            <el-table-column prop="right_name" label="权限" width="100"> </el-table-column>

            <el-table-column fixed="right" label="操作" width="150" align="center">
              <template>
                <el-button size="mini" class="Del-com" @click="DelTabColOne()" ><i class="el-icon-delete"></i></el-button>
                
                <router-link to="/UpdateMessage"><el-button size="mini" class="Upd-com"><i class="el-icon-edit"></i></el-button></router-link>
              </template>
              
            </el-table-column>
       
      </el-table>
      <div style="text-align: center;margin-top: 30px;">
      <el-pagination
        background
        layout="prev, pager, next"
        :total="total"
        @current-change="current_change">
      </el-pagination>
    </div>
    </div>
</div>
</template>
<script>
export default {
  name: 'Managemessage',
  data(){
    return {
        tableData: [
          {
            userId: '2017110431',
            name: '潘成花',
            password: 'snq92eio',
            email: '1105504914@qq.com',
            telephone: '18198015646',
            BankCard: '23r79739048329048-02320',
            department_name: '计算机科学学院',
            title: '高级教授',
            working_age: 1,
            right_name: ["All"]
          }
        ],
        dialogVisible: false,
        multipleSelection: [],
        total: 0,
        pagesize:10,
        currentPage:1
  }
  },
  methods: {
     handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      DelTabColOne(){
        
        const url="/api/del"/*删除用户信息接口文件*/
        alert("删除成功！")
        location.reload();

      },
      UpdTabColOne(){
        alert("修改成功！")
      },

      current_change:function(currentPage){
        this.currentPage = currentPage;
      },
　　　　mounted: function () {
 　　　　this.addUser();
　　　　}
  }
}

</script>
<style scoped>
a{
  text-decoration: none;
  color: white;
}
#Managemassage{
  margin: 0 auto;
  text-align: center;
  width: 80%;
  margin-left: 10%;
}
.table-center{
  margin-left: 10%;
  margin-right: 10%;
}
el-button{
  display: inline-block;
}
.Del-com{
  background-color: red;
  color: white;
}
.Upd-com{
  background-color: green;
  color: white;
}
</style>