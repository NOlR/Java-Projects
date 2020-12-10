<template>
  <v-app id="app">
  <v-content>
    <router-view/>
  </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'App',
}
</script>
<style lang="scss">
  .move{
    animation-duration: 0.6s;
    animation-delay: 0.2s;
  }
</style>
