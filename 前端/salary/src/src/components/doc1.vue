<template>
    <div class="doc1">
        <h3>员工扣款清单填写</h3>
        <el-form ref="form" :model="form" label-width="120px">
            <el-form-item label="职工号" style="height: 20px;"><el-input v-model="form.userId" onkeyup="value=value.replace(/[^\d]/g,'')" oninput="if(value.length>8)value=value.slice(0,8)"></el-input></el-form-item>
            <el-form-item label="姓名" style="height: 20px;"><el-input v-model="form.name" oninput="if(value.length>15)value=value.slice(0,15)"></el-input></el-form-item>
            <el-form-item label="房费" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.room"></el-input></el-form-item>
            <el-form-item label="水电费" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.waterElectric"></el-input></el-form-item>
            <el-form-item label="托儿费" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.children"></el-input></el-form-item>
            <el-form-item label="借支扣款" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.advance"></el-input></el-form-item>
            <el-form-item label="其他扣款" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.other"></el-input></el-form-item>
            <el-form-item label="扣款总计" style="height: 20px;"><el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="form.deductTotal"></el-input></el-form-item>
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
          room:'',
          waterElectric:'',
          children:'',
          advance:'',
          other:'',
          deductTotal:'',
          submitUserId:'',

        }
      }
    },
    methods: {
    upload() {
      //上传表单里面的信息
        let postData = this.$qs.stringify({
            userid:this.form.userId,
            name:this.form.name,
            room:this.form.room,
            waterElectric:this.form.waterElectric,
            children:this.form.children,
            advance:this.form.advance,
            other:this.form.other,
            deductTotal:this.form.other,
            submitUserId:this.form.submeitUserId,
            submitDate:Date(),
        })
        //请求接口
        this.$axios({
            method: 'post',
            url:'/uploadDeduct',
            data:postData
        }).then(_ =>{
          
        alert("提交成功！")

        })
        .catch(_ => {"内部异常"});}
    
    }
  }
</script>
<style scoped>
.doc1{
    width: 70%;
    margin-left: 15%;
    font-size: 15px;
    
}
a{
    text-decoration: none;
    color: white;
}
</style>