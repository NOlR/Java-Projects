<template>
  <v-form ref="form" v-model="valid" lazy-validation>
    <v-text-field v-model="name" :counter="10" :rules="nameRules" label="Name" required></v-text-field>

    <v-text-field v-model="email" :rules="emailRules" label="content" required></v-text-field>

    <v-select v-model="select" :items="items" :rules="[(v) => !!v || 'Item is required']" label="E-mail" required></v-select>

    <v-checkbox v-model="checkbox" :rules="[(v) => !!v || 'You must agree to continue!']" label="是否匿名?" required></v-checkbox>

    <v-btn :disabled="!valid" color="success" class="mr-4" @click="validate">
      提交
    </v-btn>

    <v-btn color="error" class="mr-4" @click="reset">
      重置
    </v-btn>

    <v-btn color="warning" @click="resetValidation">
      取消
    </v-btn>
  </v-form>
</template>

<script>
export default {
  data: () => ({
    valid: true,
    name: '',
    nameRules: [(v) => !!v || 'Name is required', (v) => (v && v.length <= 10) || 'Name must be less than 10 characters'],
    email: '',
    emailRules: [(v) => !!v || 'E-mail is required', (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid'],
    select: null,
    items: ['Item 1', 'Item 2', 'Item 3', 'Item 4'],
    checkbox: false
  }),

  methods: {
    validate() {
      this.$refs.form.validate()
    },
    reset() {
      this.$refs.form.reset()
    },
    resetValidation() {
      this.$refs.form.resetValidation()
    }
  }
}
</script>

<style></style>
