<template>
	<view class="container">

		<view class="update-info">
			<view class="update">
				<textarea class="textarea" placeholder="请输入内容~" v-model="value">
				</textarea>
			</view>
		</view>

		<view class="fotter">
			<view class="add">
				<tui-button type="danger" shape="circle" @click="publish" limit='1'>点击修改</tui-button>
			</view>
		</view>

		<tui-toast ref="toast"></tui-toast>
	</view>
</template>

<script>
	import {
		appConfig
	} from '@/config/config'
	import {
		getUserInfo,
		updateUser
	} from "@/api/user.js"

	import {
		getLoginUserInfo
	} from "@/api/user.js"
	export default {
		data() {
			return {
				type: 0,
				value: '',
				uid: '',
			}
		},
		onLoad(options) {
			this.type = options.type
			this.uid = uni.getStorageSync("userInfo").id
			this.getUserInfo(this.uid, this.type)
		},

		methods: {
			back() {
				uni.navigateBack({
					delta: 1
				})
			},
			getUserInfo(uid, type) {
				getLoginUserInfo().then(res => {
					if (res.code === 500) {
						uni.clearStorageSync()
						uni.navigateTo({
							url: "/pages/login/login2/login2"
						})
					}
					this.userInfo = res.user

					if (type == 1) {
						this.value = res.user.nickName
					} else {
						this.value = res.user.remark
					}
				})
			},

			publish() {

				if (this.type == 1) {
					//更换昵称
					this.userInfo.nickName = this.value
				} else {
					//更换简介
					this.userInfo.remark = this.value
				}

				delete this.userInfo.noreplyCount


				updateUser(this.userInfo).then(res => {

					let params = {
						title: "修改成功",
						imgUrl: "/static/images/toast/check-circle.png",
						icon: true
					}
					this.$refs.toast.show(params);
					// uni.setStorageSync("userInfo", res.data)
					setTimeout(() => {

						uni.switchTab({
							url: "/pages/user/user"
						})
					}, 1000)
				})
			},
		}
	}
</script>

<style scoped>
	@import url(./updateInfo);
</style>