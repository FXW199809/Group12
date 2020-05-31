<template>
  <div class="change_container">
    
    <h2 style="margin-top:10px;padding:50px;">修改密码</h2>
    <div class="change_box">
      <!-- <div class="avatar_box">
        <img src="../assets/logo.png" />
      </div> -->
      <el-form class="user-account-key" ref="form" :model="form" :rules="rules" label-width="100px" >
        <el-form-item label="账号" prop="id">
          <el-input type="text" placeholder="请输入账号" v-model="form.id"></el-input>
        </el-form-item>
        <el-form-item label="原密码" prop="password">
          <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
        </el-form-item>

      <el-form-item label="新密码" prop="newPassword">
        <el-input type="password" placeholder="请输入新密码" v-model="form.newPassword"></el-input>
      </el-form-item>

      <el-form-item class="btns">
        <el-button type="primary" @click="onSubmit('form')">保存</el-button>
        <el-button @click="$refs['form'].resetFields()">重置</el-button>
      </el-form-item>
       </el-form>


    </div>

  </div>
</template>
<style scoped>
  .change_container{
  width: 100%;
  height:  700px;
  margin: 0 auto;
  padding: 0;
  background-image: url(../assets/zhmm.jpg);
  }
.change_box{
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
  }
/*.avatar_box{
  height: 130px;
  width: 130px;
  border: 1px solid #eee;
  border-radius: 50%;
  padding: 10px;
  box-shadow: 0 0 10px #ddd;
  position: absolute;
  left: 50%;
  transform: translate(-50%,-70%);
  background-color: #fff;}
  img{
  width: 100%;
  height: 100%;
  border-radius: 50%;
  background-color: #eee;}*/
  .btns{
    display: flex;
    justify-content: flex-end;
  }
  .user-account-key{
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;

  }
</style>
<script>

  import axios from 'axios'

  export default{
    data(){
      let validateNewPassword=(rule,value,callback)=>{
        if(value===this.form.password){
          callback(new Error('新密码不能和原密码相同'))
        }else{
          callback()
        }
      }

      return{
        form:{},
        rules:{
          id:[
            {required:true,message:'请输入账号id',trigger:'blur'}
          ],
          password:[
            {required:true,message:'请输入原密码',trigger:'blur'}
          ],
          newPassword:[
            {required:true,message:'请设置新密码',trigger:'blur'},
            {validator:validateNewPassword,trigger:'blur'}
          ]
        }
      }
    },
    methods:{
      onSubmit(formName){
        /* this.$refs[formName].validate(valid=>{
          if(valid){
            let{newPassword,password}=this.form
            updatePassword({newPassword,password}).then(()=>{
              this.$message.success('密码已修改')
            })
          }else{
            this.$message.error('请正确填写')
            return false
          }
        }) */
       axios.post("/change",
        {

        },
        {
          params:{
            userID:this.form.id,
            oldPassword:this.form.password,
            newPassword:this.form.newPassword
          }
        }
        ).then(
        //res=>console.log(res),
        //this.$router.push('/index')
        res=>{
          //if(this.form.oldPassword!==this.form.newPassword)
          if(res.data==200){
            this.$router.push('/login');
            this.$message.success('修改密码成功');
          }else{
            this.$message.error('不存在，错误');
          }}
/*
         res=>{
          if(this.form.oldPassword!==this.form.newPassword){
            this.$router.push('/login');
            this.$message.success('修改密码成功');
          } 
        }*/


          //this.$router.push('/login')
        ).catch(err=>console.log(err));

      }
    },
  }
</script>

