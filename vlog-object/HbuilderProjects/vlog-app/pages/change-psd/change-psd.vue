<template>
	<view>
		<input type="text" v-model="oldpassword" placeholder="请输入旧密码" class=" p-2 flex-1" />
		<input type="text" v-model="newpassword" placeholder="请输入确认密码" class=" p-2 flex-1" />
		<view class="py-2 px-3">
			<button :class="disabled ? 'bg-main-disabled':'bg-main'"
			 style="border-radius: 50rpx; border: 0;"
			 type="primary">设置</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				oldpassword:'',
				newpassword:''
			}
		},
		computed:{
			disabled() {
				if(this.oldpassword ===''||this.newpassword===''){
					return true;
				}
				return false;
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
