// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
//限制用户输入数据为数字与固定长度
Vue.directive('enterNumber', {
  inserted: function (el) {
    el.addEventListener("keypress",function(e){
      e = e || window.event;
      let charcode = typeof e.charCode === 'number' ? e.charCode : e.keyCode;
      let re = /\d/;
      if(!re.test(String.fromCharCode(charcode)) && charcode > 9 && !e.ctrlKey){
        if(e.preventDefault){
          e.preventDefault();}else{
          e.returnValue = false;
          }
    }
    });
  }
  });

import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.prototype.$axios = axios;
Vue.use(VueAxios, axios);
import qs from 'qs';
Vue.prototype.$qs = qs;
Vue.config.productionTip = false;
//elementUI导入
import ElementUI from '../node_modules/element-ui'
import 'element-ui/lib/theme-chalk/index.css'

//import api from './api/index.js'
//Vue.prototype.$api = api;

/**
 * 默认访问后端接口地址
 */
axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.use(ElementUI);
Vue.config.productionTip = false

import Router from 'vue-router'

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  data(){
    return {
      totalVm: new Vue()
    }
  }
})


