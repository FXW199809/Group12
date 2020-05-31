<template>
    <div class="HomePage">
      <div id="right_side">
        <div class="todayDate p3">
            <h2 class="p3">尊敬的老师欢迎您：今天是</h2>
            <hr>{{ date}}
            <br>{{ week }}
        </div>
      </div>
      <div class="block">
        <el-carousel :interval="4000" type="card" height="200px">
          <el-carousel-item v-for="item in 6" :key="item">
            
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>

</template>

<script>
export default {
  data() {
        return {
           date:"",
           week:"",
           timer:null
        }
    },
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
        timeFormate(timeStamp) {
            let year = new Date(timeStamp).getFullYear();
            let weeks = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
            let wk = new Date(timeStamp).getDay();
            let month =new Date(timeStamp).getMonth() + 1 < 10? "0" + (new Date(timeStamp).getMonth() + 1): new Date(timeStamp).getMonth() + 1;
            let date =new Date(timeStamp).getDate() < 10? "0" + new Date(timeStamp).getDate(): new Date(timeStamp).getDate();
            //let hh =new Date(timeStamp).getHours() < 10? "0" + new Date(timeStamp).getHours(): new Date(timeStamp).getHours();
            //let mm =new Date(timeStamp).getMinutes() < 10? "0" + new Date(timeStamp).getMinutes(): new Date(timeStamp).getMinutes();
            // let ss =new Date(timeStamp).getSeconds() < 10? "0" + new Date(timeStamp).getSeconds(): new Date(timeStamp).getSeconds();
            // return year + "年" + month + "月" + date +"日"+" "+hh+":"+mm ;
            this.date = year + "年" + month + "月" + date +"日";
            this.week = weeks[wk];
            console.log(this.date);
        },
     // 定时器函数
    nowTimes() {
      this.timeFormate(new Date());
      this.timer = setTimeout(this.nowTimes, 30 * 1000);
    }
  },
  //调用定时器
    created() {
    this.nowTimes();
  },
   //销毁定时器
  beforeDestroy: function() {
    if (this.timer) {
        console.log("销毁定时器")
       clearTimeout(this.timer); //在Vue实例销毁前，清除我们的定时器
    }
  }
}
</script>

<style scoped>
.HomePage{
  width: 80%;
  margin-left: 10%;
}
  .el-carousel__item:nth-child(2n) {
    background-image: url(../assets/slide1.jpg);
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-image: url(../assets/image1.png);
  }
  .block{
    margin-top: 50px;
  }
</style>