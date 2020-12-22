<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-card>
      <v-app-bar
      color="#fcb69f"
      clipped-left
      dark
      :src="user.banner"
      height="500"
      >
      <template v-slot:img="{props}">
        <v-img v-bind="props" gradient="to top right,rgba(40,44,52,.6),rgba(211,190,223,.4)"></v-img>
      </template>
      <v-row justify="center">
        <v-card-title>
          <h1>{{user.signature}}</h1>
        </v-card-title>
      </v-row>
      </v-app-bar>
    </v-card>
    <v-main class="grey lighten-3">
      <router-view/>
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
      loginUser:(state) => state.loginUser,
      user:(state) =>state.user
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