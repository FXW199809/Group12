<template>
    <div class="ChangeInfo">
    <div class="center clearfix">
        <p>修改个人基本信息</p>
		<form action="" method="POST" id="bd">
			<div id="zt">
				<p><label>职工号:</label><input type="text" name="zgh" /> </p>
				<p><label>院&nbsp;&nbsp;&nbsp;&nbsp;系:</label><input type="text" name="yx" /> </p>
				<p><label>姓&nbsp;&nbsp;&nbsp;&nbsp;名:</label><input type="text" name="name" /> </p>
				<p><label>性&nbsp;&nbsp;&nbsp;&nbsp;别:</label><input type="text" name="sex" /> </p>
				<p><label>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</label><input type="text" name="email" /></p>
				<p><label>手机号:</label><input type="text" name="phone" /> </p>
			</div>
			<p>
			    <input type="button" name="xg" value="修改密码" id="an1"/>
			    <input type="button" name="qt" value="确认修改" id="an2"/>
			</p>
		</form>
    </div>
    </div>

</template>

<script>
export default {
  data() {
        return {
           date:"",
           week:"",
           info: {},
           timer:null
        }
    },
  computed:{
        activeIndex(){
            return this.$route.path.replace('/','')
            }
  },
  methods:{
        postInfo: function(){
            this.$axios.get('http://localhost:8080')
            .then(response => (this.info = response))
            .catch(function (error) {
                console.log(error);
                });
            },
        skip(a){
            this.$router.push(a)
            },
        handleSelect(key, keyPath) {
            console.log(this);
            console.log(key, keyPath);
        }
        
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