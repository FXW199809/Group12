<template>
    <div class="Senddoc">
        <div class="selectDoc">
            <p style="line-height: 10px;"> 请点击按钮下载模板文件</p><hr>
            <ul>
                <li><p style="display: inline-block; margin-right:120px;">xxx学院员工工资扣除表单模板.xls</p>
                <el-button style="margin-left:20px;" size="mini" class="filter-item" type="primary" icon="el-icon-download" @click="handleExportKouchu(scope.row)">下载模板</el-button></li>
                 <li><p style="display: inline-block; margin-right:120px;">xxx学院员工工资奖金表单模板.xls</p>
                <el-button style="margin-left:20px;" size="mini" class="filter-item" type="primary" icon="el-icon-download" @click="handleExportJiangJin(scope.row)">下载模板</el-button></li>
            </ul>
            

        </div>
        <div class="PostDoc">
            <p style="line-height: 10px;"> 请点击按钮选择要上传的文件</p>
            <hr>
            <div class="send left">
                <p style="font-size: 10px;">员工工资奖金表单</p>
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
                <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
                <div slot="tip" class="el-upload__tip">只能上传xls/xlsx文件，且不超过500kb</div>
            </el-upload>
            </div>
            <div class="send right">
                <p style="font-size: 10px;">员工工资扣除表单</p>
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
                <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
                <div slot="tip" class="el-upload__tip">只能上传xls/xlsx文件，且不超过500kb</div>
            </el-upload>
            </div>
            
        </div>
    </div>
</template>



<script>
  export default {
      data() {
      return {
        fileList: []
      };
    },
    methods: {
        //method方法
        handleExportKouchu(row){
            const url="/user/downloadExcelKouchu"/*接口文件*/
            const options = {snapshotTime:formatDate(new Date(row.snapshotTime), 'yyyy-MM-dd hh:mm')}
            exportExcel(url,options)
        },
        handleExportJiangJin(row){
            const url="/user/downloadExcelJiangJin"/*接口文件*/
            const options = {snapshotTime:formatDate(new Date(row.snapshotTime), 'yyyy-MM-dd hh:mm')}
            exportExcel(url,options)
        },
        handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
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
