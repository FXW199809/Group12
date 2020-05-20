<template>
    <div class="ChangeInfo">
    <div class="center clearfix">
        <p>修改个人基本信息</p>
		<form action="" method="POST" id="bd">
			<div id="zt">
				<p><label>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</label><input type="text" name="email" /></p>
				<p><label>手机号:</label><input type="text" name="phone" /> </p>
                <p><label>银行卡:</label><input type="text" name="phone" /> </p>
			</div>
			<p>
			    <input type="button" name="xg" value="修改资料" id="an1"/>
			    <input type="button" name="qt" value="确认修改" id="an2"/>
			</p>
		</form>
    </div>
    </div>

</template>

<script>
    import Vue from 'vue'
export default {
  data() {
        return {

           salary:[],
           dialogFormVisible: false,
            form: {
            email:'',
            telephone:'',
            bank_card:'',
            address: '',
            name: '',
            region: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
            },
            formLabelWidth: '120px',
        }
        
    },
    //页面跳转
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
        skip(a){
            this.$router.push(a)
            },
        handleSelect(key, keyPath) {
            console.log(this);
            console.log(key, keyPath);
        },
        ChangeInfo(){
            Vue.axios.get('/ChangeInfo').then((response) => (
                // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
               this.salary = responce.data
                //console.log(response.data.tSalary[0])
            )).catch((error) => {
                // catch 指请求出错的处理
                //console.log(error);
                console.log("nooooooo");
            });
        },
        
        
        
  },
  mounted: function(){
      this.ChangeInfo();
  }
  
}
</script>

<style scoped>
.center{
    width: 46%;
    margin-left: 28%;

}
#bd{
	background-color: #FFFFFF;
	width: 500px;
	height: 400px;
	font-size: 18px;
}
#zt p{
	margin: 10px;
	padding-left: 50px;
}
#zt label{
	width: 80px;
	display: inline-block;
	/* text-align: right; */
	margin-right: 20px;
}
#zt input{
	width: 240px;
	height: 30px;
}


#an1{
    width: 100px;
    height: 35px;
    margin: 0 90px;
    color: white;
    background-color: lightseagreen;
    border-radius: 5px;
    border: 0 solid;
}
#an2{
    width: 100px;
    color: white;
    background-color: lightseagreen;
    border-radius: 5px;
    border: 0 solid;
    height: 35px;
}

</style>