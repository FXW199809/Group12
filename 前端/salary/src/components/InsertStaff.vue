<template>
    <div class="InsertStaff">
        <h3>新增员工信息</h3>
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="员工姓名" style="height: 25px;">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="职工号" style="height: 25px;">
                <el-input v-model="form.UserId"></el-input>
            </el-form-item>
            <el-form-item label="初始密码" style="height: 25px;">
                <el-input v-model="form.password" type="password"></el-input>
            </el-form-item>
            
            <el-form-item label="用户权限" style="height: 25px;">
                <el-radio-group v-model="form.right_name">
                <el-radio label="登录"></el-radio>
                <el-radio label="上传"></el-radio>
                <el-radio label="管理"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="银行卡号" style="height: 25px;">
                <el-input v-model="form.BankCard"></el-input>
            </el-form-item>
            <el-form-item label="院系" style="height: 25px;">
                <el-select v-model="form.department_id" placeholder="请选择院系">
                    <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="职称" style="height: 25px;">
                <el-radio-group v-model="form.title">
                <el-radio label="教授"></el-radio>
                <el-radio label="高级教授"></el-radio>
                <el-radio label="普通教师"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="工龄" style="height: 25px;">
                <el-input-number v-model="form.working_age" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
            </el-form-item>
            <el-form-item>
                <el-button type="success" round="" @click="addUser(form)">立即新增</el-button>
                <el-button type="info" round="">
                    <router-link to="/ManageMessage">取消新增</router-link>
                    </el-button>
            </el-form-item>
        </el-form>

    </div>
</template>
<script>
  export default {
    data() {
      return {
          options: [{
          value: '11',
          label: '计算机科学学院'
        }],
        form: {
          name: '',
          UserId: '',
          password: '',
          BankCard: '',
          department_id: '',
          title: '',
          right_name: '',
          working_age: '',
        }
      }
    },
    methods: {
    addUser() {
        let postData = this.$qs.stringify({
            userid:this.form.UserId,
		    password:this.form.password,
            name:this.form.name,
            bankCard:this.form.BankCard,
            departmentId:this.form.department_id,
            title:this.form.title,
            workingAge:this.form.working_age,
            right_name:this.form.right_name
        })
        this.$axios({
            method: 'post',
            url:'/addUser',
            data:postData
        }).then(_ =>{
          
        alert("新增成功！")

        })
        .catch(_ => {"内部异常"});}
    
    }
  }
</script>
<style scoped>
.InsertStaff{
    width: 45%;
    margin-left: 25%;
    font-size: 15px;
    
}
a{
    text-decoration: none;
    color: white;
}
</style>