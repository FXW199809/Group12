import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import HelloWorld from '@/components/HelloWorld'
import Managemessage from '@/components/Managemessage'
import HomePage from '@/components/HomePage'
import Senddoc from '@/components/Senddoc'
import Yuanximain from '@/components/Yuanximain'
import Normalmain from '@/components/Normalmain'
import Select from '@/components/Select'
import SalaryGather from '@/components/SalaryGather'
import ChangeInfo from '@/components/ChangeInfo'
import details from '@/components/details'
import Examine from '@/components/Examine'
import Examine2 from '@/components/Examine2'
import Examine3 from '@/components/Examine3'
import Examine4 from '@/components/Examine4'
import Examine5 from '@/components/Examine5'
import InsertStaff from '@/components/InsertStaff'
import CheckSalary from '@/components/CheckSalary'

import AppIndex from '../components/AppIndex.vue'
import Change from '../components/Change.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: Login,
      component: Login
    },
    {
      path:'/change',
      component:Change
    },
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld,
      children:[
        {
          path:'/HelloWorld',
          name: 'HomePage',
          component: HomePage
        },
        {
          path:'/Managemessage',
          component: Managemessage
        },
        /*
        {
          path: '/UpdateMessage',
          component: UpdateMessage
        },*/
        {
          path: '/InsertStaff',
          component: InsertStaff
        },
        {
          path:'/Select',
          component:Select
        },
        {
          path: '/SalaryGather',
          component:SalaryGather
        },{
          path: '/ChangeInfo',
          component:ChangeInfo
        },{
          path: '/Examine',
          component:Examine
        },{
          path: '/Examine2',
          component:Examine2
        },{
          path: '/Examine3',
          component: Examine3
        },{
          path: '/Examine4',
          component: Examine4
        },{
          path: '/Examine5',
          component:Examine5
        }
        
      ]
    },
    {
      path: "/Yuanximain",
      component: Yuanximain,
      children:[
        {
          path:'/Yuanximain',
          name: 'HomePage',
          component: HomePage
        },
        {
          path:'/Senddoc',
          component: Senddoc
        },{
          path: '/Yuanxi/ChangeInfo',
          component:ChangeInfo
        },
        {
          path: '/details',
          component:details
        }
      ]
    },
    
    {
      path: "/Normalmain",
      component: Normalmain,
      children:[
        {
          path:'/Normalmain',
          name: 'HomePage',
          component: HomePage
        },
        {
          path: '/CheckSalary',
          component: CheckSalary
        },
        {
          path: '/Normalmain/ChangeInfo',
          component:ChangeInfo
        }
      ]
    }
   
  ]
})
