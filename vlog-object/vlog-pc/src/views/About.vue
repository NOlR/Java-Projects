<template>
  <v-card
    class="elevation-16 mx-auto"
    width="300"
  >
    <v-card-title class="headline">
      My vlog
    </v-card-title>
    <v-card-text>
        给我的博客网站评个分吧！
      <div class="text-center mt-12">
        <v-rating
          v-model="rating"
          color="yellow darken-3"
          background-color="grey darken-1"
          empty-icon="$ratingFull"
          half-increments
          hover
          large
        ></v-rating>
      </div>
    </v-card-text>
    <v-divider></v-divider>
    <v-card-actions class="justify-space-between">
      <v-btn text>
        这次一定
      </v-btn>
      <v-btn
        color="primary"
        text
      >
        下次一定
      </v-btn>
    </v-card-actions>
  </v-card>
</template>
<script>
  export default {
    data: () => ({
      rating: 4.5,
    }),
  }
</script>

<style>

</style>