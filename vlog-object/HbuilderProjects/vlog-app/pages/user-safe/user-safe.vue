<template>
	<view>
			<uni-list-item title="修改密码" @click="open('change-psd')"></uni-list-item>
			<uni-list-item title="绑定手机" @click=""></uni-list-item>
			<uni-list-item title="绑定微信" @click=""></uni-list-item>
			<uni-list-item title="绑定QQ" @click=""></uni-list-item>
	</view>
</template>

<script>
	import uniListItem from '@/components/uni-ui/uni-list-item/uni-list-item.vue';
	export default {
		components:{
		uniListItem	
		},
		data() {
			return {
				
			}
		},
		methods: {
			open(path){
				uni.navigateTo({
					url:`../${path}/${path}`
				})
			}
		}
	}
</script>

<style>

</style>
