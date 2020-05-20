<template>
    <div class="doc4">
        <h3>员工工资错误清单填写</h3>
        <el-form ref="form" :model="form" label-width="120px">
          <el-form-item label="记录标识" style="height: 20px;"><el-input v-model="form.id"></el-input></el-form-item>
            <el-form-item label="职工号" style="height: 20px;"><el-input v-model="form.userId"></el-input></el-form-item>
            <el-form-item label="姓名" style="height: 20px;"><el-input v-model="form.name"></el-input></el-form-item>
            <el-form-item label="事项" style="height: 20px;"><el-input v-model="form.item"></el-input></el-form-item>
            <el-form-item label="错误数据" style="height: 20px;"><el-input v-model="form.wrongData"></el-input></el-form-item>
            <el-form-item label="修正数据" style="height: 20px;"><el-input v-model="form.revisedData"></el-input></el-form-item>
            <el-form-item label="申请人职工号" style="height: 20px;"><el-input v-model="form.submitUserId"></el-input></el-form-item>
           
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
          item:'',
          wrongData:'',
          revisedData:'',
          submitUserId:'',

        }
      }
    },
    methods: {
    upload() {
        let postData = this.$qs.stringify({
            id:this.form.id,
            userid:this.form.UserId,
            name:this.form.name,
            item:this.form.item,
            wrongData:this.form.wrongData,
            revisedData:this.form.revisedData,
            submitUserId:this.form.submeitUserId
        })
        this.$axios({
            method: 'post',
            url:'/uploadError',
            data:postData
        }).then(_ =>{
          
        alert("提交成功！")

        })
        .catch(_ => {"内部异常"});}
    
    }
  }
</script>
<style scoped>
.doc4{
    width: 70%;
    margin-left: 15%;
    font-size: 15px;
    
}
a{
    text-decoration: none;
    color: white;
}
</style>