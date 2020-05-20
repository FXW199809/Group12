<template>
    <div class="Senddoc">
        <div class="selectDoc">
            <p style="line-height: 10px;"> 请点击按钮下载模板文件</p><hr>
            <div><el-button @click="downloadFile(Subsidy)">点击下载员工补贴清单表模板</el-button></div>
            <div><el-button @click="downloadFile(Deduct)">点击下载员工扣款清单表模板</el-button></div>
            <div><el-button @click="downloadFile(Change)">点击下载员工工资变动清单表模板</el-button></div>
            <div><el-button @click="downloadFile(ErrorInfo)">点击下载员工错误信息表模板</el-button></div>
        </div>
        <div class="PostDoc">
            <p style="line-height: 10px;"> 请点击按钮选择要上传的文件</p>
            <hr>
            <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="3"
                :on-exceed="handleExceed"
                :file-list="fileList">
                <el-button size="small" type="primary" icon="el-icon-upload" @click="uploadFile(Subsidy)">点击上传员工补贴清单表</el-button>
            </el-upload>
            
            <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="3"
                :on-exceed="handleExceed"
                :file-list="fileList">
                <el-button size="small" type="primary" icon="el-icon-upload" @click="uploadFile(Change)">点击上传员工工资变动清单表</el-button>
            </el-upload>
            <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="3"
                :on-exceed="handleExceed"
                :file-list="fileList">
                <el-button size="small" type="primary" icon="el-icon-upload" @click="uploadFile(Deduct)">点击上传员工错误信息清单表</el-button>
            </el-upload>
            <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="3"
                :on-exceed="handleExceed"
                :file-list="fileList">
                <el-button size="small" type="primary" icon="el-icon-upload" @click="uploadFile(ErrorInfo)">点击上传员工扣款清单表</el-button>
            </el-upload>

            </div>
            
        </div>
</template>



<script>
import Vue from 'vue'
  export default {
      data() {
      return {
        downloadFile:'',
        uploadFile:'',
        fileList: []
      };
    },
    methods: {
        //method方法
        //下载文件
        download (data) {
        if (!data) {
            return
        }
        let url = window.URL.createObjectURL(new Blob([data]));
        let link = document.createElement('a');
        link.style.display = 'none';
        link.href = url;
        link.setAttribute('download');
        document.body.appendChild(link);
        link.click();
    },
      downloadFile(Subsidy){
        Vue.axios.post('/downloadSubsidyExcel',{params:{}}).then((response) =>{
          this.download(response.data);
          alert("下载成功！");

        }).catch(_ =>{
          "内部异常"
        });
      },
      downloadFile(Deduct){
        Vue.axios.post('/downloadDeductExcel',{params:{}}).then((response) =>{
          this.download(response.data);
          alert("下载成功！");

        }).catch(_ =>{
          "内部异常"
        });
      },
      downloadFile(Change){
        Vue.axios.post('/downloadChangeExcel',{params:{}}).then((response) =>{
          this.download(response.data);
          alert("下载成功！");

        }).catch(_ =>{
          "内部异常"
        });
      },
      downloadFile(ErrorInfo){
        Vue.axios.post('/downloadErrorExcel',{params:{}}).then((response) =>{
          this.download(response.data);
          alert("下载成功！");

        }).catch(_ =>{
          "内部异常"
        });
      },
      //上传文件
      uploadFile(Subsidy){
        Vue.axios.post('/uploadSubsidy',{params:{SubsidyExcelFile:this.uploadFile}}).then((response) =>{
          alert("上传成功！");

        }).catch(_ =>{
          "内部异常"
        });
      
    },
    uploadFile(Deduct){
        Vue.axios.post('/uploadDeduct',{params:{DeductExcelFile:this.uploadFile}}).then((response) =>{
          alert("上传成功！");

        }).catch(_ =>{
          "内部异常"
        });
      
    },
    uploadFile(ErrorInfo){
        Vue.axios.post('/uploadError',{params:{ErrorExcelFile:this.uploadFile}}).then((response) =>{
          alert("上传成功！");

        }).catch(_ =>{
          "内部异常"
        });
      
    },
    uploadFile(Change){
        Vue.axios.post('/uploadChange',{params:{ChangeExcelFile:this.uploadFile}}).then((response) =>{
          alert("上传成功！");

        }).catch(_ =>{
          "内部异常"
        });
      
    }
    }
  }
</script>
<style scoped>
.Senddoc{
    width: 80%;
    margin: 0 auto;
    
}
.selectDoc{
    margin-top: 20px;
    margin-bottom: 20px;
    border: 3px solid #ccc;
    width: 70%;
    margin-left: 15%;
    border-radius: 10px;
}
.el-button{
  width:500px;
  margin-bottom: 8px;

}
.PostDoc{
    margin-top: 20px;
    margin-bottom: 20px;
    border: 3px solid #ccc;
    width: 70%;
    margin-left: 15%;
    border-radius: 10px;
}
.send{
    display: inline-block;
    text-align: center;
    width: 45%;
    margin: 0 auto;
}
ul{
    font-size: 15px;
    font-family: '宋体';
}
</style>
