<template>
	<view class="content" :style="'margin-top:'+vHeight+'rpx'">
		<tui-navigation-bar backgroundColor="#fff" :isFixed="true" :isOpacity="false" v-if='top_show'>
			<view class="fixed-top">
				<view class="fixed-user">
					<image :src="'http://localhost:8083'+userInfo.avatar" class="avatar" mode="aspectFill"
						@click="previewImgae(userInfo.avatar)" />
					<view class="username">{{ userInfo.username }}</view>

				</view>
			</view>
		</tui-navigation-bar>
		
		<tui-navigation-bar backgroundColor="#fff" :isFixed="false" :isOpacity="false" v-else>
					<view class="top">
						<view class="right">
							<view class="item">
								<navigator url="/pages/setting/setting">
									<tui-icon name="setup" class="icon-item-setup" color="#fff" size="30"></tui-icon>
								</navigator>
							</view>
						</view>
					</view>
				</tui-navigation-bar>
		<!-- 头 -->

		<!-- 显示图片 -->
		<view class="image">
			<image :src="userInfo.cover" v-if="userInfo" mode="aspectFill" @click="previewImgae(userInfo.cover)" />
			<image src="/static/images/toast/img_nodata.png" v-else mode="aspectFill" />
		</view>
		
		<!-- 主体 -->
		<view class="main">
			<view class="top">				
				<view class="user">
					<view class="user-left">
						<image :src="'http://localhost:8083'+userInfo.avatar" class="avatar" mode="aspectFill"
							@click="previewImgae(userInfo.avatar)" />
						<view class="user-content">
							<h3>{{ userInfo.username }}</h3>
							<view class="user-id f">id:{{ userInfo.userId }}</view>
							<view class="descrpition f">{{ userInfo.nickName }} </view>
						</view>
					</view>
					<view class="user-right">
						<tui-button type="danger" shape="circle" @click="editUserInfo" height="60rpx" width="140rpx"
							:size="28">编辑</tui-button>
					</view>
				</view>
				
				<view class="info">
					<p >关注 {{ focusUserCount }}</p>
					<p >粉丝 {{ quiltUserCount}}</p>
					<p>动态 {{ detailCount }}</p>
				</view>
				<view class="">
					<tui-tabs :tabs="tabs" :currentTab="currentTab" @change="change" sliderBgColor="red"
						selectedColor="red" itemWidth="50%"></tui-tabs>
				</view>
			</view>

			<view class="zhuti">
				<view v-if="userInfo">
					<Trend v-if="currentTab == 0" :uid='uid' @cancelUp='cancelUp' :seed='seed'> </Trend>
					<Collection v-if="currentTab == 1" :uid='uid' :seed='seed'></Collection>
					<History v-if="currentTab == 2" :uid='uid' @cancelUp='cancelUp' :seed='seed'> </History>
					
 				</view>
				<view class="nologin" v-else>
					<button @click="login">请先登录</button>
				</view>
			</view>
		</view>

		<tui-modal :show="show" @click="confirm" @cancel="hide" content="取消上传" :button="radio" width="50%"
			padding="15rpx 40rpx" :fadeIn='true'></tui-modal>

	</view>
</template>

<script>
	import Trend from "@/pages/user/trends/trends"
	import Album from "@/pages/user/albums/albums"
	import History from "@/pages/user/history/trends"
	import Collection from "@/pages/user/collections/collections"
	import {
		getUserInfo,
		getLoginUserInfo
	} from "@/api/user.js"
	import {
		deleteImgs
	} from '@/api/imgDetail.js'
	export default {
		components: {
			Trend,
			Album,
			Collection,
			History
		},
		data() {
			return {
				current: 0,
				currentTab: 0,
				value:null,
				range: [
				          { value: 0, text: "篮球" },
				          { value: 1, text: "足球" },
				          { value: 2, text: "游泳" },
				        ],
				tabs: [{
					name: "动态"
				},
				// , {
				// 	name: "专辑"
				// }, 
				{
					name: "收藏"
				},
				{
					name: "浏览记录"
				},
				],
				userInfo: {},
				detailCount: null,
				focusUserCount: null,
				quiltUserCount: null,
				seed: 0,
				uid: '',
				show: false,

				radio: [{
						text: '取消',
						type: 'white',
					},
					{
						text: '确定',
						type: 'red',
					}
				],

				mid: '',

				//页面初始化高度
				screenHeight: 0,

				top_show: false,

				vHeight: 0,
			}
		},
		onLoad(options) {
			if (typeof options.currentTab != 'undefined' || options.currentTab != null) {
				this.currentTab = options.currentTab
			}
			this.screenHeight = uni.getSystemInfoSync().screenHeight;
		},

		onReachBottom() {
			this.seed = Math.random()
		},
		created() {
			this.uid = uni.getStorageSync("userInfo").id
		},
		onShow() {
		
			this.getUser()
			this.seed = Math.random()

		},
		onPageScroll(e) {

			const that = this
			if (e.scrollTop >= 20) {
				this.top_show = true
				uni.createSelectorQuery().select('.content').boundingClientRect(function(data) {
					that.vHeight = 220
				}).exec()
			} else {
				this.top_show = false
				uni.createSelectorQuery().select('.content').boundingClientRect(function(data) {
					that.vHeight = 0
				}).exec()
			}

		},
		methods: {
			change(e) {
				this.currentTab = e.index
			},
			selectChange(){
				console.log('change')
			},
			setting() {
				uni.navigateTo({
					url: "/pages/setting/setting"
				})
			},


			cancelUp(mid) {
				this.show = true
				this.mid = mid
			},

			confirm(e) {
				let index = e.index;
				if (e.index == 0) {
					this.show = false
				} else {
					let arr = []
					arr.push(this.mid)
					deleteImgs(arr, this.userInfo.id).then(res => {
						uni.showToast({
							title: "取消成功"
						})
						this.show = false
					})
				}
			},
			hide() {
				this.show = false
			},

			editUserInfo() {
				uni.navigateTo({
					url: "/pages/user/info/info?uid= " + this.uid
				})
			},
			login() {
				uni.navigateTo({
					url: "/pages/login/login2/login2"
				})
			},
			getUser() {
				let params = {
					uid: uni.getStorageSync("userInfo").id
				}
				getLoginUserInfo().then(res => {
					if(res.code === 500){
						uni.clearStorageSync()
						uni.navigateTo({
							url: "/pages/login/login2/login2"
						})
					}
					this.userInfo = res.user
					this.detailCount = res.detailCount
					this.focusUserCount = res.focusUserCount
					this.quiltUserCount = res.quiltUserCount
				})

			},

			getAllFriend(type) {
				uni.navigateTo({
					url: "/pages/user/allUser/allUser?type=" + type + "&uid=" + this.userInfo.id
				})
			},

			//-----------------------------------预览图片----------------
			previewImgae(url) {

				let that = this
				let path = []
				path.push(url)

				uni.previewImage({
					current: 0, // 当前显示图片的索引值
					urls: path, // 需要预览的图片列表，photoList要求必须是数组
					longPressActions: {
						itemList: ['保存'],
						success: function(data) {

							//进行保存
							if (data.tapIndex == 0) {
								let p = that.downLoadImg(url)
								p.then((data) => {
									uni.showToast({
										title: data,
										icon: "none"
									});
								})
							}
						},
						fail: function(err) {
							return
						}
					}
				})
			},

			// 保存图片至本地
			downLoadImg(path) {
				//下载图片资源至本地，返回文件的本地临时路径
				return new Promise((resolve, reject) => {
					uni.downloadFile({
						url: path,
						success: (res) => {
							if (res.statusCode === 200) {
								//保存图片至相册
								uni.saveImageToPhotosAlbum({
									filePath: res.tempFilePath,
									success: function() {
										resolve("保存成功")
									},
									fail: function() {
										reject("保存失败")
									}
								});
							}
						}
					})
				})
			},
		}
	}
</script>

<style scoped>
	@import url(./user.css);
</style>
