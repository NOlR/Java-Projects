<template>
	<view>
		<uni-list-item title="头像" @click = "changeAvatar">
			<view class="flex align-center" slot="right">
				<image
				:src="avatar?avatar:'/static/default.jpg'"
				style="width: 100rpx;height: 100rpx;"
				class="rounded-circle"></image>
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="昵称">
			<view class="flex align-center" slot="right">
				<input class="uni-input text-right" v-model="nickname" />
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="性别" @click="changeGender">
			<view class="flex align-center" slot="right">
				<text>{{genderText}}</text>
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<picker mode="date" :value="birthday" @change="onDateChange">
		   <uni-list-item title="生日">
		    <view class="flex align-center" slot="right">
		     <text>{{birthday}}</text>
		     <text class="iconfont icon-bianji1 ml-2"></text>
		    </view>
		   </uni-list-item>
		  </picker>
		<uni-list-item title="地址" @click="showCityPicker">
			<view class="flex align-center" slot="right">
				<text>{{pickerText}}</text>
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		
		<view class="py-2 px-3">
			<button class="bg-main text-white" style="border-radius: 50rpx;border: 0;" type="primary"@click="submit">完成</button>
		</view>
		<mpvue-city-picker 
		:themeColor="themeColor"
		ref="mpvueCityPicker"
		:pickerValueDefault="cityPcikerValueDefault"
		@onConfirm="onConfirm"></mpvue-city-picker>
	</view>
</template>

<script>
	const genderArray = ['保密','男','女'];
	import uniListItem from '@/components/uni-ui/uni-list-item/uni-list-item.vue';
	import mpvueCityPicker from '@/components/uni-ui/mpvue-citypicker/mpvueCityPicker.vue';
	import {mapState} from 'vuex';
	export default {
		components:{
			uniListItem,
			mpvueCityPicker
		},
		data() {
			return {
					themeColor:'#007AFF',
					cityPcikerValueDefault:[0,0,1],
					avatar:'https://pic-go-noir.oss-cn-beijing.aliyuncs.com/avatar/3d38c2b7-22dd-4b8c-b4d5-b398963b195d.jpg',
					pickerText:'',
					nickname:'',
					gender:0,
					birthday:''		
			};
		},
		//监听返回
		onBackPress(){
			if(this.$refs.mpvueCityPicker.showPicker){
				this.$refs.mpvueCityPicker.pickerCancel();
				return true;
			}
		},
		onUnload(){
			if(this.$refs.mpvueCityPicker.showPicker){
				this.$refs.mpvueCityPicker.pickerCancel();
			}
		},
		onLoad(){
			let userinfo = this.user;
			if(userinfo){
				this.nickname = userinfo.nickname;
				this.avatar = userinfo.avatar;
				this.gender = userinfo.gender;
				this.pickerText = userinfo.address;
				this.birthday = userinfo.birthday;
				console.log(userinfo)
			}
		},
		computed:{
			...mapState({
				user:state => state.user
			}),
			genderText(){
				return genderArray[this.gender];
			}
		},
		methods: {
			//显示三级联动城市选择组件
			showCityPicker(){
				this.$refs.mpvueCityPicker.show();
			},
			//三级联动选择组件提交事件，监听相应的值并显示
			onConfirm(e){
				this.pickerText = e.label;
			},
			//监听日期选取,改变生日显示的值
			onDateChange(e){
				this.birthday = e.detail.value;
			},
			//修改头像
			changeAvatar(){
				uni.chooseImage({
					count:1,
					sizeType:['compressed'],
					sourceType:['album','camera'],
					success:res =>{
						console.log(res.tempFilePaths[0]);
						this.$H
							.upload('/user/upload',{
								filePath:res.tempFilePaths[0],
								name:'file'	//	一定要和后端接口的入参名字一样
							})
							.then(result =>{
								console.log(result.data);
								uni.showToast({
									title:'修改头像成功',
									icon:'none'
								});
								this.avatar = result.data;
							})
							.catch(err=>{
								console.log(err)
							});
					}
				});
			},
			changeGender(){
				uni.showActionSheet({
					itemList:genderArray,
					success:res =>{
						this.gender = res.tapIndex;
						if(this.gender == 0){
							this.genderText='保密';
						}else if(this.gender == 1){
							this.genderText = '男'
						}else if(this.gender ==2){
							this.genderText='女';
						}
					}
				});
			},
			submit(){
				let data={
					id:this.user.id,
					phone:this.user.phone,
					password:this.user.password,
					nickname:this.nickname,
					avatar:this.avatar,
					gender:this.gender,
					birthday:this.birthday,
					address:this.pickerText,
					createTime:this.user.createTime
				};
				this.$H.post('/user/update',data).then(res =>{
					console.log(res);
					this.$store.commit('editUserInfo',data);
					uni.showToast({
						title:'修改资料成功',
						icon:'none'
					});
				})
			}
		}
	};
</script>

<style>

</style>
