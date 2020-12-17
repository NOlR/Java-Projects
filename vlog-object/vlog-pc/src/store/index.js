import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    lginStatus:false,
    user:{
      id:1,
      phone:'18796428166',
      password:'607e4e084799b65df76cb7125f616443',
      nickName:'XiaruoShul',
      avatar:'https://pic-go-noir.oss-cn-beijing.aliyuncs.com/avatar/179a3ea9-bf09-4a79-b514-2ba73968941b.jpg',
      gender:1,
      birthday:'2020-12-10',
      address:'江苏省南京市雨花台区',
      banner:'https://pic-go-noir.oss-cn-beijing.aliyuncs.com/avatar/179a3ea9-bf09-4a79-b514-2ba73968941b.jpg',
      signature:'上善若水',
      createTime:'2020-12-08 11:11:11'

    }
  },
  mutations: {
    login(state,user){
      state.loginStatue = true
      state.user = user
      localStorage.setItem('user',JSON.stringify(user))
    },
    logout(state){
      state.loginStatue = false;
      state.user={}
      localStorage.removeItem('user')
    }
  },
  actions: {},
  modules: {}
})
