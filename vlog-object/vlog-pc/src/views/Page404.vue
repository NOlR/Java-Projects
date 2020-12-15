<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-main>
      <div class="bg">
        <img class="err" src="https://pic-go-noir.oss-cn-beijing.aliyuncs.com/bgi/very_sorry.png">
      </div>
    </v-main>
    <my-footer></my-footer>
  </v-app>
</template>

<script>
import MyFooter from '../components/MyFooter.vue'
import NavBar from '../components/NavBar.vue'
export default {
  name: 'Page404',
  components: {
    NavBar,
    MyFooter
  },
  data() {
    return {}
  },
  created() {},
  methods: {}
}
</script>
<style lang="scss" scoped>
.bg{
  width: 1600px;
  height: 900px;
  margin-top: 50px;
  background-image: url(https://pic-go-noir.oss-cn-beijing.aliyuncs.com/bgi/sky.png);
  margin: 0 auto;
  background-size: cover;
  .err{
    width: 70%;
    margin-left: 200px;
    margin-top: 150px;
  }
}
</style>
