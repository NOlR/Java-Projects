<template>
  <form>
    <img :src="user.avatar" style="width:100px">
    <v-text-field label="昵称" :value="user.nickname"></v-text-field>
    <v-text-field label="性别" :value="gendertext"></v-text-field>
    <v-text-field :counter="11" label="手机号" :value="user.phone"></v-text-field>
    <v-text-field label="地址" :value="user.address"></v-text-field>
    <v-btn class="mr-4">
      submit
    </v-btn>
  </form>
</template>

<script>
import { mapState } from 'vuex'
const genderArray = ['保密','男','女']
export default {
  data: () => {
    return {
      
    }
  },
  computed: {
    ...mapState({
      loginStatus: (state) => state.loginStatus,
      user: (state) => state.user
    }),
    gendertext(){
      return genderArray[this.user.gender]
    }
  }
}
</script>

<style></style>
