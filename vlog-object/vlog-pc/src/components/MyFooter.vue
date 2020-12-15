<template>
  <div class="footer-bg">
    <v-row justify="center" align="center">
      <v-col cols="12" md="12">
        ™️2017——2020 NOIR. 版权所有 站点总数字：287.5k
      </v-col>
      <v-col cols="12" md="12">
        本站已运行 3 年 95 天 22 小时 分钟 56 秒
      </v-col>
      <v-col cols="12" md="12">
        本站总访问量 236895 人次，访客数 83056 人
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'MyFooter'
}
</script>

<style scoped>
.footer-bg {
  height: 140px;
  background-color: #ee6e73;
  background-image: linear-gradient(to right, #59c173 0%, #a17fe0 50%, #5d26c1 100%);
  opacity: 0.7;
  text-align: center;
  color: #fff;
}
</style>
