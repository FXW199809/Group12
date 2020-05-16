<template>
    <div>
    <div class="ttop">
        <div id="topimg">
            <a target="_blank" class="p4">财务管理员
                {{ this.info }}
            </a>
            <a target="_blank" class="p5">登录/退出登录</a>
        </div>
    </div>
    <div class="top">
        <div class="topinside">
            <!-- <input type="button" class="btn" value="主页">
            <input type="button" class="btn" value="账号管理">
            <input type="button" class="btn" value="提交表单">
            <input type="button" class="btn" value="查看账单"> -->
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
                <el-menu-item index="ManageFrame" class="btn2" @click="skip('Payhome')">主页</el-menu-item>
                <el-menu-item index="ManageUser1" class="btn2" @click="skip('ManageUser1')">账号管理</el-menu-item>
                <el-menu-item index="3" class="btn2" @click="skip('Examine')">工资发放</el-menu-item>
                <el-menu-item index="Select" class="btn2" @click="skip('Select')">员工查询</el-menu-item>
                <el-menu-item index="ChangeInfo" class="btn2" @click="skip('ChangeInfo')">个人信息修改</el-menu-item>
                <el-menu-item index="6" class="btn2" @click="skip('SalaryGather')">数据汇总</el-menu-item>
            </el-menu>
        </div>
    </div>
    <div class="center clearfix">
            <el-button type="text" @click="dialogFormVisible = true">导出工资表</el-button>
                <el-dialog title="导出工资表" :visible.sync="dialogFormVisible">
                <el-form :model="form">
                    <el-form-item label="选择保存地址" :label-width="formLabelWidth">
                    <el-input v-model="form.address" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="编辑文档名称" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="选择文档格式" :label-width="formLabelWidth">
                    <el-select v-model="form.region" placeholder="请选择文档格式">
                        <el-option label=".xsl" value="firstLayout"></el-option>
                    </el-select>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="dialogFormVisible = false , doExport()">确 定</el-button>
                </div>
                </el-dialog>
            <el-table :data="salary.slice((currpage-1)*pagesize,currpage*pagesize)" height="350" border style="width: 100%">
            <el-table-column prop="userId" label="职工号" width="79"> </el-table-column>
            <el-table-column prop="name" label="姓名" width="79"> </el-table-column>
            <el-table-column prop="baseSalary" label="基本工资" width="79"> </el-table-column>
            <el-table-column prop="jobSalary" label="职务工资" width="79"> </el-table-column>
            <el-table-column prop="workingAgeSalary" label="工龄工资" width="79"> </el-table-column>
            <el-table-column prop="food" label="副食补贴" width="79"> </el-table-column>
            <el-table-column prop="coal" label="煤油补贴" width="79"> </el-table-column>
            <el-table-column prop="transport" label="交通补贴" width="79"> </el-table-column>
            <el-table-column prop="subsidy1" label="备补1" width="79"> </el-table-column>
            <el-table-column prop="subsidy2" label="备补2" width="79"> </el-table-column>
            <el-table-column prop="sumSalary" label="应发工资" width="79"> </el-table-column>
            <el-table-column prop="room" label="房费" width="79"> </el-table-column>
            <el-table-column prop="waterElectric" label="水电费" width="79"> </el-table-column>
            <el-table-column prop="children" label="托儿费" width="79"> </el-table-column>
            <el-table-column prop="advance" label="借支扣款" width="79"> </el-table-column>
            <el-table-column prop="other" label="其他扣款" width="79"> </el-table-column>
            <el-table-column prop="deductTotal" label="扣款总计" width="79"> </el-table-column>
            <el-table-column prop="takeHomeSalary" label="实发工资" width="79"> </el-table-column>
            <el-table-column prop="yearMonthDate" label="时间" width="79"> </el-table-column>
    </el-table>
    <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currpage"
                :page-size="pagesize"
                layout="total, sizes, prev, pager, next, jumper"
                :total= "salary.length">
            </el-pagination>
        <div class="GatherCenter">
        </div>
    </div>
    <div class="foot">
        <p>
            <a class="p1" target="_blank">
                <i class="icon"></i>
                四川师范大学官方微博
            </a>
        </p>
        <br>
        <p class="p2">2017级4班第12小组版权所有（技术支持：2017级4班第12小组）联系电话：028-8488888</p>
    </div>
    </div>

</template>

<script>
import Vue from 'vue';

export default {
    
  data() {
        return {
           date:"",
           week:"",
           info: {},
           timer:null,
           salary:[],
           dialogFormVisible: false,
            form: {
            address: '',
            name: '',
            region: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
            },
            formLabelWidth: '120px',
            pagesize: 10,
            currpage: 1,
            fileList: []
        }
        
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  
  methods:{
        //每页条数改变时触发
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.pagesize = val;
      },
      //当前页面改变时触发
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.currpage = val;
      },
        open() {
            this.$message({
                message: '恭喜你，导出成功',
                type: 'success'
            });
        },
        skip(a){
            this.$router.push(a)
            },
        handleSelect(key, keyPath) {
            console.log(this);
            console.log(key, keyPath);
        },
        getStaffGather(){
            Vue.axios.get('/getStaffGather').then((response) => (
                // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                this.salary = response.data
                //console.log(response.data.tSalary[0])
            )).catch((error) => {
                // catch 指请求出错的处理
                //console.log(error);
                console.log("nooooooo");
            });
        },
        doExport(){
            var judge;
            Vue.axios.get('/exportSalaryManager', {
                params: {
                    fileName: this.form.name,
                    filePath: this.form.address
                }
            }).then((response) => (
                // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                //this.salary = response.data
                //judge = response.data
                //console.log("my2:" + response.data)
                this.open()
            )).catch((error) => {
                // catch 指请求出错的处理
                //console.log(error);
                console.log("nooooooo");
            });
            //console.log("my" + judge == "true");
            //console.log("my2:" + judge);
            //if(judge == "true"){
                
            //}
        }
        
        
  },
  mounted: function(){
      this.getStaffGather();
  }
  
}
</script>

<style scoped>
    @import "../css/PayFrame.css";
    @import "../css/SalaryGather.css";
</style>