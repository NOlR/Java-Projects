<template>
	<view>
		<uni-collapse>
			<uni-collapse-item title="标题" showAnimation>
				<view class="content"><input type="text" placeholder="标题" class="border-bottom p-2"/></view>
			</uni-collapse-item>
			<uni-collapse-item title="内容" showAnimation>
				<view class="content"><input type="text" placeholder="内容" class="border-bottom p-2"/></view>
			</uni-collapse-item>
		</uni-collapse>
		<view class="py-2 px-3">
			<button class="bg-main text-white" style="border-radius: 50rpx;border: 0;" type="primary">意见反馈</button>
		</view>
	</view>
</template>

<script>
	import uniCollapseItem from '@/components/uni-ui/uni-collapse-item/uni-collapse-item.vue';
	import uniCollapse from '@/components/uni-ui/uni-collapse/uni-collapse.vue';
	export default {
		components:{
			uniCollapseItem,
			uniCollapse
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
