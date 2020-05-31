<template>
    <div class="doc2">
        <h3>员工补贴清单填写</h3>
        <el-form ref="form" :model="form" label-width="120px">
            <el-form-item label="职工号" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.userId" oninput="if(value.length>8)value=value.slice(0,8)"></el-input></el-form-item>
            <el-form-item label="姓名" style="height: 20px;"><el-input v-model="form.name" oninput="if(value.length>15)value=value.slice(0,15)"></el-input></el-form-item>
            <el-form-item label="副食补贴" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.food"></el-input></el-form-item>
            <el-form-item label="煤油补贴" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.coal"></el-input></el-form-item>
            <el-form-item label="交通补贴" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.transport"></el-input></el-form-item>
            <el-form-item label="备补1" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.subsidy1"></el-input></el-form-item>
            <el-form-item label="备补2" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.subsidy2"></el-input></el-form-item>
            <el-form-item label="补贴总计" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.subsidyTotal"></el-input></el-form-item>
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
          food:'',
          coal:'',
          transport:'',
          subsidy1:'',
          subsidy2:'',
          subsidyTotal:'',
          submitUserId:'',

        }
      }
    },
    methods: {
    upload() {
        let postData = this.$qs.stringify({
            userid:this.form.userId,
            name:this.form.name,
            food:this.form.food,
            coal:this.form.coal,
            transport:this.form.transport,
            subsidy1:this.form.subsidy1,
            other:this.form.other,
            subsidyTotal:this.form.subsidyTotal,
            submitUserId:this.form.submeitUserId,
            submitDate:Date(),
        })
        this.$axios({
            method: 'post',
            url:'/uploadSubsidy',
            data:postData
        }).then(_ =>{
          
        alert("提交成功！")

        })
        .catch(_ => {"内部异常"});}
    
    }
  }
</script>
<style scoped>
.doc2{
    width: 70%;
    margin-left: 15%;
    font-size: 15px;
    
}
a{
    text-decoration: none;
    color: white;
}
</style>