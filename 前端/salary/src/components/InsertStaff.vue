<template>
    <div class="InsertStaff">
        <h3>新增员工信息</h3>
        <el-form ref="form" :model="form" label-width="80px" rules="FormRules">
            <el-form-item label="员工姓名" style="height: 25px;">
                <el-input v-model="form.name" oninput="if(value.length>15)value=value.slice(0,15)"></el-input>
            </el-form-item>
            <el-form-item label="职工号" style="height: 25px;">
                <el-input v-model="form.UserId" onkeyup="value=value.replace(/[^\d]/g,'')" 
                oninput="if(value.length>8)value=value.slice(0,8)"></el-input>
            </el-form-item>
            <el-form-item label="身份证号" style="height: 25px;">
                <el-input v-model="form.IdCard" onkeyup="value=value.replace(/[^\d]/g,'')" 
                oninput="if(value.length>18)value=value.slice(0,18)"></el-input>
            </el-form-item>
            <el-form-item label="籍贯" style="height: 25px;">
                    <el-cascader
	                    :options="country"
	                    v-model="form.JiGuan"
                        :props="{ expandTrigger: 'hover' }"
	                    @change="handleChange"
                        placeholder="请选择籍贯"
	                    :separator="' '">
                    </el-cascader>
            </el-form-item>
            <el-form-item label="民族" style="height: 25px;">
                <el-select v-model="form.MinZu" placeholder="请选择民族">
                    <el-option
                    v-for="item in MinZu"
                    :key="item.vlaue"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="初始密码" style="height: 25px;">
                <el-input v-model="form.password" type="password" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" 
                oninput="if(value.length>8)value=value.slice(0,8)"></el-input>
            </el-form-item>
            <el-form-item label="用户权限" style="height: 25px;">
                <el-radio-group v-model="form.right_name">
                <el-radio label="登录"></el-radio>
                <el-radio label="上传"></el-radio>
                <el-radio label="管理"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="银行卡号" style="height: 25px;">
                <el-input v-model="form.bankCard"  onkeyup="value=value.replace(/[^\d]/g,'')" oninput="if(value.length>19)value=value.slice(0,19)"></el-input>
            </el-form-item>
            <!--院系选项框，动态的从数据库读取 -->
            <el-form-item label="院系" style="height: 25px;">
                <el-select v-model="form.department_id" placeholder="请选择院系">
                    <el-option
                    v-for="item in options"
                    :key="item.departmentId"
                    :label="item.departmentName"
                    :value="item.departmentId">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="职称" style="height: 25px;">
                <el-radio-group v-model="form.title">
                    <el-radio label="助教"></el-radio>
                    <el-radio label="讲师"></el-radio>
                    <el-radio label="副教授"></el-radio>
                    <el-radio label="教授"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="最高学位" style="height: 25px;">
                <el-radio-group v-model="form.XueWei">
                    <el-radio label="学士"></el-radio>
                    <el-radio label="硕士"></el-radio>
                    <el-radio label="博士"></el-radio>
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
import options from '../router/country_data.js'
import minzu from '../router/minzu_data.js'
  export default {
    data() {
      return {
        country:options ,  //存放城市数据
        //56民族数据
        MinZu:minzu,
        options: [],
        form: {
          name: '',
          UserId: '',
          password: '',
          IdCard: '',
          JiGuan: [],
          MinZu: '', 
          XueWei: '',
          bankCard: '',
          department_id: '',
          title: '',
          right_name: '',
          working_age: '',
        }
      }
    },
mounted: function () {
 　this.getData();
　},
    methods: {
        handleChange(value) {
        console.log(value);
      },
        //获取院系选项信息
        getData:function(){
            let data={}
            this.$axios.post('/getDepartmentList',data).then(response => {
                // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                //this.options.label=response.data.departmentName,
                //this.options.value=response.data.departmentId
                //console.log(response.data.tSalary[0])
                this.options=response.data
            }).catch((error) => {
                // catch 指请求出错的处理
                //console.log(error);
                console.log("nooooooo");
            });
    },
    //防止SQL注入的判断
    AntiSqlValid(oField ){
        re= /select|update|delete|exec|count|'|"|=|;|>|<|%/i;
        if ( re.test(oField.value) ){
        alert("请您不要在参数中输入特殊字符和SQL关键字！"); //注意中文乱码
        oField.value = "";
        oField.className="errInfo";
        oField.focus();
        return false;
        }},
        /*
        check_phone() {
      if (!/^1[34578]\d{9}$/.test(this.form.UserId)) {
        alert("格式错误");
        this.form.UserId = "";
      } else {
        alert("格式正确");
      }
    },*/
    
    addUser() {
        
        
        let postData = this.$qs.stringify({
            userid:this.form.UserId,
		    password:this.form.password,
            name:this.form.name,
            id_card:this.form.IdCard,
            degree:this.form.XueWei,
            nation:this.form.MinZu,
            origin1:this.form.JiGuan[0],
            origin2:this.form.JiGuan[1],
            bankCard:this.form.bankCard,
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
