<template>
<div id="Managemessage">
    <div class="add" style="margin-top: 15px;margin-bottom: 5px;">
      <el-button type="info">
        <router-link to="/InsertStaff"><i class="el-icon-plus"></i>点击新增员工</router-link></el-button>
    </div>
    <div class="table-center">
      <el-table 
      :data="tableData.slice((currpage-1)*pagesize,currpage*pagesize)" 
      min-height="350" 
      border 
      style="width: 100%">
            <el-table-column prop="userId" label="职工号" width="100"> </el-table-column>
            <el-table-column prop="name" label="姓名" width="100"> </el-table-column>
            <el-table-column prop="password" label="密码" width="140"> </el-table-column>
            <!--新增-->
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
            <el-table-column prop="right_name" label="权限" width="100"> </el-table-column>
            <!-- 操作-->
            <el-table-column fixed="right" label="操作" width="150" align="center">
              <template scope="scope">
                <el-button size="mini" class="Del-com" @click="DelTabColOne(scope.$index,scope.row)" ><i class="el-icon-delete"></i></el-button>
                <el-button size="mini" class="Upd-com" @click="UpdTabColOne(scope.$index,scope.row)" ><i class="el-icon-edit"></i></el-button>
              </template>
            </el-table-column>
       
      </el-table>
      
    <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currpage"
                :page-size="pagesize"
                layout="total, sizes, prev, pager, next, jumper"
                :total= "tableData.length">
            </el-pagination>
    </div>
    <!--删除提示弹出-->
    <el-dialog title="提示" :visible.sync="centerDialogVisible" width="30%"  center>
      <span>此条数据会永久删除？是否继续</span>
      <span slot="footer" class="dialog-footer">
      <el-button @click="centerDialogVisible = false">取 消</el-button>
    <!--这个deleteRow方法才是真正删除数据的方法，与后台交互的方法，注意：遇到有弹出框操作的通常都有2个方法，一个调弹窗，一个真正删除 -->
     <el-button type="primary" @click="deleteRow">确 定</el-button>
     </span>
  </el-dialog>
  <!-- 修改用户-->  
<el-dialog title="编辑用户信息" :visible="editUserForm" size="tiny" :modal-append-to-body='false' @close='closeDialog'>
  <el-form ref="editsForm" :model="editsForm" label-width="80px">
    <el-form-item label="职工号">
      <el-input  v-model="editsForm.userId" max-length="10" disabled="disabled"></el-input>
    </el-form-item>
    <el-form-item label="姓名">
      <el-input v-model="editsForm.name" disabled="disabled"></el-input>
    </el-form-item>
    <el-form-item label="院系">
      <el-input v-model="editsForm.department_name" disabled="disabled"></el-input>
    </el-form-item>
    
    <el-form-item label="密码">
      <el-input type="password" v-model="editsForm.password" disabled="disabled"></el-input>
    </el-form-item>
<!-- 新增 -->
    <el-form-item label="身份证号">
      <el-input v-model="editsForm.idCard" disabled="disabled"></el-input>
    </el-form-item>
    <el-form-item label="籍贯">
      <el-input v-model="editsForm.origin" disabled="disabled"></el-input>
    </el-form-item>
    <el-form-item label="民族">
      <el-input v-model="editsForm.nation" disabled="disabled"></el-input>
    </el-form-item>
    <el-form-item label="最高学位">
      <el-radio-group v-model="editsForm.degree">
          <el-radio label="学士"></el-radio>
          <el-radio label="硕士"></el-radio>
          <el-radio label="博士"></el-radio>
      </el-radio-group>
      <!--
      <el-input v-model="editsForm.XueWei" disabled="disabled"></el-input>
      -->
    </el-form-item>


    <el-form-item label="邮箱">
      <el-input type="email" v-model="editsForm.email"></el-input>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="editsForm.telephone" onkeyup="value=value.replace(/[^\d]/g,'')" oninput="if(value.length>11)value=value.slice(0,11)"></el-input>
    </el-form-item>
    <el-form-item label="银行卡">
      <el-input v-model="editsForm.bankCard" onkeyup="value=value.replace(/[^\d]/g,'')" oninput="if(value.length>19)value=value.slice(0,19)"></el-input>
    </el-form-item>
    <el-form-item label="职称">
      <el-radio-group v-model="editsForm.title">
                <el-radio label="助教"></el-radio>
                <el-radio label="讲师"></el-radio>
                <el-radio label="副教授"></el-radio>
                <el-radio label="教授"></el-radio>
                </el-radio-group>
    </el-form-item>
    <el-form-item label="工龄">
      <el-input-number v-model="editsForm.working_age" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
    </el-form-item>
    <el-form-item label="权限">
          <el-radio-group v-model="editsForm.right_name">
                <el-radio label="登录"></el-radio>
                <el-radio label="上传"></el-radio>
                <el-radio label="管理"></el-radio>
          </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="updateUser()">确定</el-button>
      <el-button @click="editUserForm = false">取消</el-button>
    </el-form-item>
  </el-form>
</el-dialog>
</div>
</template>
<script>
import Vue from 'vue'
export default {
  name: 'Managemessage',
  data(){
    return {
      editUserForm:false,
      editsForm:{
          userId:'',
          name:'',
          password:"",
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
          right_name:'',
        },
        tableData: [
          {
            userId:'20171104',
            name:'潘成花',
            password:'psd1234',

            idCard:'620121199907275023',
            origin:'甘肃兰州',
            nation:'汉族',
            degree:'博士',

            email:'1105504914@qq.com',
            telephone:'18198015646',
            bankCard:'1389027490324',
            right_name:'登录',
            title:'教授',
            working_age:2,
            department_name:'计算机科学学院'

          }
        ],
        //接收指定删除数据的userid
        listId:'',
        //接收指定删除数据的的索引
        listIndex:'',
        centerDialogVisible:false,
        dialogVisible: false,
        multipleSelection: [],
        pagesize: 10,
        currpage: 1,
        fileList: []
  }
  },
  methods: {
    //获取用户表信息
    getData:function(){
      Vue.axios.get('/getUserInfoList').then((response) => (
                // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                this.tableData = response.data
                //console.log(response.data.tSalary[0])
            )).catch((error) => {
                // catch 指请求出错的处理
                //console.log(error);
                console.log("nooooooo");
            });
    },
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
    //删除行数据
    DelTabColOne(index,row){
                //将表格传过来的对象付给formSelect
                this.formSelect=row;
                //把单行删除的对象的id赋给listId，当出现弹出框时，会有2个点击函数，
                //这是一定要把从表格传过来数据付给vue实例中定义的对象，这样才会
               // 在哪都会调用到~~，另外push是专属于数组的赋值方法
                this.listId=this.formSelect.userId;
                //将删除的对象的索引付给listIndex
                this.listIndex=index;
                //显示删除弹出框
                this.centerDialogVisible = true;
                
    },
     deleteRow:function(){
              this.centerDialogVisible=false;
              Vue.axios.get('/deleteUser', {params:{ userid: this.listId }}).then((response) =>{
                  alert("删除成功！")
                  this.getData();
                  })
                .catch(_ => {"内部异常"});
            },
      // 点击模态框关闭按钮关闭模态框
      closeDialog(){
        this.editUserForm = false;
      },
          // 点击编辑按钮
          UpdTabColOne(index,row){
          this.editUserForm = true; //编辑信息模态框显示
          this.editsForm = Object.assign({}, row);  //获得所有数据显示在编辑信息模态框里面
          },
          // 点击编辑信息弹框的确定按钮
          updateUser() {
            let postData = this.$qs.stringify({
            userid:this.editsForm.userId,
		        password:this.editsForm.password,
            name:this.editsForm.name,
            email:this.editsForm.email,
            telephone:this.editsForm.telephone,
            bankCard:this.editsForm.bankCard,
            departmentName:this.editsForm.department_name,
            title:this.editsForm.title,
            workingAge:this.editsForm.working_age,
            right_name:this.editsForm.right_name,
            //新增用户信息列
            id_card:this.editsForm.idCard,
            degree:this.editsForm.degree,
            nation:this.editsForm.nation,
            origin:this.editsForm.origin
        })
        this.$axios({
            method: 'post',
            url:'/updateUser',
            data:postData
        }).then(_ =>{
          
        alert("修改成功！")
        this.getData();
        })
        .catch(_ => {"内部异常"});}
        },
　mounted: function () {
 　this.getData();
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