<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-card>
      <v-app-bar
      color="#fcb69f"
      clipped-left
      dark
      src="https://pic-go-noir.oss-cn-beijing.aliyuncs.com/bgi/purple-nebula-galaxy-planets-stars-space-39615.jpeg"
      height="500"
      >
      <template v-slot:img="{props}">
        <v-img v-bind="props" gradient="to top right,rgba(40,44,52,.6),rgba(211,190,223,.4)"></v-img>
      </template>
      </v-app-bar>
    </v-card>
    <v-main>
      <v-container class="main-content">
        <router-view />
      </v-container>
    </v-main>
    <my-footer></my-footer>
  </v-app>
</template>

<script>
import {mapState} from 'vuex'
import MyFooter from '../components/MyFooter.vue'
import NavBar from '../components/NavBar.vue'
export default {
  name:'Layout',
  components:{
    NavBar,
    MyFooter
  },
  computed:{
        ...mapState({
      loginStatus: (state) => state.loginStatus,
      user: (state) => state.user
    })
  }
}
</script>

<style lang="scss" scoped>
.header{
  width: 80%;
  display: flex;
  justify-content: center;
  align-items: start;
  .nav{
    position: fixed;
    top:10;
    z-index: 1000;
  }
}
</style>