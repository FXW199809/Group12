<template>
  <div class="login_container">
    <div class="login_box">
      <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="80px">
        <el-form-item label="用户名" prop="name">
          <el-input id="name" v-model="loginForm.name" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input id="password" v-model="loginForm.password" placeholder="请输入密码" type="password"></el-input>
        </el-form-item>

        <el-form-item >
          <el-radio-group v-model="loginForm.radio">
            <el-radio label="用户"></el-radio>
            <el-radio label="院系"></el-radio>
            <el-radio label="财务"></el-radio>
          </el-radio-group>
        </el-form-item>

        <!-- <el-radio-group v-model="radio">
          <el-radio :label="3">用户</el-radio>
          <el-radio :label="6">院系</el-radio>
          <el-radio :label="9">财务</el-radio>
        </el-radio-group> -->


        <!-- 按钮 -->
        <el-form-item class="btns">
          <!-- <el-button type="text" @click="forgetpassword">忘记密码</el-button> -->
          <el-button type="text" @click="change">修改密码</el-button>
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="infor" @click="resetLoginForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  //import Vue from 'vue'
  import axios from 'axios'
  export default{
    data(){
      return{
        //登录表单的数据绑定对象
        loginForm:{
          name:'',
          password:'',
          radio:''
        },
        //表单验证
        loginFormRules:{
          name:[
            {required:true,message:"请输入用户名",trigger:"blur"},
            {min:2,max:20,message:"长度在2-20个字符",trigger:"blur"}
          ],
          password:[
            {required:true,message:"请输入密码",trigger:"blur"},
            {min:2,max:16,message:"长度在2-16个不同字符",trigger:"blur"}

          ]
        }
        /* radio:3 */
      }
    },
    methods:{
      //重置表单
      resetLoginForm(){
        this.$refs.loginFormRef.resetFields();
      },
      login(){
        //this.$router.replace('/index');

       /* if(this.loginForm.name==='wzz'&&this.loginForm.password==='123'){
          //this.$router.push('/index');
          this.$router.push('/HelloWorld');
        }else if(this.loginForm.name==='ddd'&&this.loginForm.password==='789'){
          this.$router.push('/Yuanximain');
        }else if(this.loginForm.name==='ptuser'&&this.loginForm.password==='564'){
          this.$router.push('/Normalmain');
        }
        else{
          this.$message.error("登录失败");
          document.getElementById('name').value='';
          document.getElementById('password').value='';
          document.getElementById('username').focus();
        }
 */
        if(this.loginForm.userID!==""||this.loginForm.password!==""){
         axios.post("/login",
        {
          /* name:"lily",
          password:"123" */
        },
        {
          params:{
            name:this.loginForm.name,
            password:this.loginForm.password,

            radio:this.loginForm.radio

          }
        }
        ).then(
        //res=>console.log(res)

        res=>{

          if(res.data=="用户"){
            this.$router.push('/Normalmain');
            window.sessionStorage.setItem("token","res"+this.loginForm.password);
            console.log(res);
            this.$message.success('登录成功');

          }else if(res.data=="院系"){
            this.$router.push('/Yuanximain');
            window.sessionStorage.setItem("token","res"+this.loginForm.password);
            console.log(res);
            this.$message.success('登录成功');
          }else if(res.data=="财务"){
            this.$router.push('/HelloWorld');
            window.sessionStorage.setItem("token","res"+this.loginForm.password);
            console.log(res);
            this.$message.success('登录成功');
         /* } */

          /* if(res.data==200){
          this.$router.push('/Normalmain');

          console.log(res);
          this.$message.success('登录成功');

          window.sessionStorage.setItem("token","res"+this.loginForm.password); */

          }else{
            this.$message.error('用户名或者密码错误');
            document.getElementById('name').value='';
            document.getElementById('password').value='';
            document.getElementById('username').focus();
          }
        }).catch(

        function(error){
          console.log(error)
        }

        /* err=>console.log(err) */

        );


       }else{
         this.$message.warning('没有填写完整');
       }



        /* this.$axios.post('/login',{
          name:this.loginForm.name,
          password:this.loginForm.password
        }).then(function(response){
          console.log(response);
        }).catch(function(error){
          console.log(error);
        }); */



         /* this.$refs.loginFormRef.validate(async status=>{
          if(!status) return this.$message.error('格式错误')
          const{data:res}=await this.$http.post('/login',this.loginForm)
          if(res!==200) return this.$message.error('用户名或者密码错误')
          window.sessionStorage.setItem('token','fhsdhfshfiudhfuishfuisdhfui')
          this.$message.success('登录成功')
          await this.$router.push('/index')
        })
 */


        /* this.$axios.post('/login',{
          name:this.loginForm.name,
          password:this.loginForm.password
        }).then(successResponse=>{
          if(successResponse.data.code==200){
            this.$router.push('/index')
          }else if(successResponse.data.code==400){
            alert('用户名或者密码错误')

          }
        }).catch(failResponse=>{

        }) */




        /* let _this=this;
        if(this.loginForm.name===''||this.loginForm.password===''){
          alert('用户名和密码不能为空');
        }else{
          this.axios({
            method:'post',
            url:'/login',
            data:_this.loginForm
          }).then(res=>{
            console.log(res.data);
            alert('登录成功');
          }).catch(error=>{
            alert('用户名或者密码错误');
            console.log(error);
          });
        } */

       /* this.$http.post('/login',{
        name:this.loginForm.name,
        password:this.loginForm.password
      }).then(res=>{
        console.log('登录成功');
      }) */


       /* this.axios({
        method:'post',
        url:'/login',
        data:{
          name:this.loginForm.name,
          password:this.loginForm.password
        }
      }).then(res=>{
        console.log(res);
      })
 */


      },
      change(){
        this.$router.push('/change');
        /* this.$message.info("联系管理员修改密码"); */

      }
      /* ,
          forgetpassword(){
            this.$message.info("联系管理员找回密码");

          } */

        }
      };
</script>
<style scoped>
.login_container{
  width: 100%;
  height:  700px;
  margin: 0 auto;
  padding: 0;
  background-image: url(../assets/zhmm.jpg);
}
.login_box{
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);

}
.el-form-item{
  margin: 20px 5px;
  height: 50px;
}
.btns{
  margin-top: 20px;
    display: flex;
    justify-content: flex-end;
  }
  .el-message{
    height: 50px;
  }


.el-radio-group{
  height: 20px;
}


/*
.login_container{
  width: 100%;
  height:  700px;
  margin: 0 auto;
  padding: 0;

  background-image: url(../assets/zhmm.jpg);
}
.login_box{
  width: 40%;
  height: 300px;
  background-color: #fff;
  border: 1px solid black;
  border-radius: 3px;
  margin-left: 30%;
  margin-top: 10%;

}
.el-form-item{
  margin: 20px 5px;
  height: 50px;
}
.btns{
  margin-top: 30px;
  display: flex;
  justify-content: flex-end;
}
.el-message{
  height: 50px;
}
*/

</style>
