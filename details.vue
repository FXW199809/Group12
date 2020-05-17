<template>
    <div class="details">
        <p>院系季度账单查询</p>
    <div class="center clearfix">
		<div id="m">
			<div id="box">
				<h3>2020年第一季度（1~3月）</h3>
				<div id="p">
					<p>计算机科学学院</p>
					<p>员工：12人</p>
					<p>工资总计：120000元</p>
				</div>
				<a id="boxzj">点击查看详情</a>
			</div>
			<div id="box">
				<h3>2020年第一季度（4~6月）</h3>
				<div id="p">
					<p>计算机科学学院</p>
					<p>员工：12人</p>
					<p>工资总计：120000元</p>
				</div>
				<a id="boxzj">点击查看详情</a>
			</div>
			<div id="box">
				<h3>2020年第一季度（7~9月）</h3>
				<div id="p">
					<p>计算机科学学院</p>
					<p>员工：12人</p>
					<p>工资总计：120000元</p>
				</div>
				<a id="boxzj">点击查看详情</a>
			</div>
			<div id="box">
				<h3>2020年第一季度（10~12月）</h3>
				<div id="p">
					<p>计算机科学学院</p>
					<p>员工：12人</p>
					<p>工资总计：120000元</p>
				</div>
				<a id="boxzj">点击查看详情</a>
			</div>
            <br>
			<a id="gd">查看更多>>></a>
		</div>
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
    width: 70%;
    margin: 0 auto;
}
#box{
    display: inline-block;
    width: 30%;
    border: 1px solid black;
    margin-bottom: 5px;
}
</style>