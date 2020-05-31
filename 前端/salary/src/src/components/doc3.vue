<template>
    <div class="doc3">
        <h3>员工工资变动清单填写</h3>
        <el-form ref="form" :model="form" label-width="120px">
            <el-form-item label="职工号" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.userId" oninput="if(value.length>8)value=value.slice(0,8)"></el-input></el-form-item>
            <el-form-item label="姓名" style="height: 20px;"><el-input v-model="form.name" oninput="if(value.length>15)value=value.slice(0,15)"></el-input></el-form-item>
            <el-form-item label="改动前工资" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.beforeMoney"></el-input></el-form-item>
            <el-form-item label="改动后工资" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.afterMoney"></el-input></el-form-item>
            <el-form-item label="申请人职工号" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.submitUserId" oninput="if(value.length>8)value=value.slice(0,8)"></el-input></el-form-item>
            
            <el-form-item>
                <el-button type="success" round="" @click="upload()">提交</el-button>
                <el-button type="info" round="">
                    <router-link to="/Senddoc">取消</router-link>
                    </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
  export default {
    data() {
      return {
        form: {
          userId:'',
          name:'',
          beforeMoney:'',
          waterElectric:'',
          afterMoney:'',
          submitUserId:'',

        }
      }
    },
    methods: {
    upload() {
        let postData = this.$qs.stringify({
            userid:this.form.userId,
            name:this.form.name,
            beforeMoney:this.form.beforeMoney,
            afterMoney:this.form.afterMoney,
            submitUserId:this.form.submeitUserId,
            submitDate:Date(),
        })
        this.$axios({
            method: 'post',
            url:'/uploadChange',
            data:postData
        }).then(_ =>{
          
        alert("提交成功！")

        })
        .catch(_ => {"内部异常"});}
    
    }
  }
</script>
<style scoped>
.doc3{
    width: 70%;
    margin-left: 15%;
    font-size: 15px;
    
}
a{
    text-decoration: none;
    color: white;
}
</style>