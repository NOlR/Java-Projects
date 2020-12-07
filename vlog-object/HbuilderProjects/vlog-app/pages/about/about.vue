<template>
	<view>
		<view class="flex justify-center">
			<image src="/static/common/nothing.png" style="width: 400rpx;height: 400rpx; " class="rounded-circle"></image>
		</view>
		<view class="flex align-center justify-center text-muted">
			version1.0.0
		</view>
		<uni-list-item title="新版本检测" @click="open('user-safe')"></uni-list-item>
		<uni-list-item title="社区用户协议" @click="open('user-info')"></uni-list-item>
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
			
		}
	}
</script>

<style>

</style>
