<template>
  <div>
    <el-row>
      <el-col :span="4">
        <el-card :body-style="{ padding: '5px'}" style="background-color: #1e1e1e;margin:10px 10px 0 10px">
          <img src="https://t7.baidu.com/it/u=4162611394,4275913936&fm=193&f=GIF"
               class="image">
        </el-card>
      </el-col>
      <el-col :span="18" style="margin-top: 10px">
        <el-row>
          <el-col :span="4">
            <span style="font-size: 20px;font-weight: bold;color: #f4516c">狂飙</span>
            <span style="font-size: 12px;margin-left: 5px">2023</span>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <span>导演：</span>
            <span style="opacity: 0.8">徐纪周</span>
            <br>
            <span>主演：</span>
            <span style="opacity: 0.8">张译  张颂文  李一桐  张志坚</span>
          </el-col>
          <el-col :span="12">
            <span>更新时间：</span>
            <br>
            <span style="opacity: 0.8">VIP会员看全集</span>
            <span>类型：</span>
            <span style="opacity: 0.8">自制  警匪  罪案  悬疑</span>
          </el-col>
        </el-row>
        <el-row>
          <span>简介：</span>
          <span style="opacity: 0.8">由金牌导演徐纪周执导，张译、张颂文、李一桐、张志坚、吴刚领衔主演，倪大红、韩童生、李建义特邀主演的中央政法委重点项目。一部扫黑除恶坚决斗争的回忆录，横跨20年的群像叙事全景式展现时代变迁下的黑白较量与复杂人性。</span>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-button v-for="o in 12" :key="o" type="info">{{ o }}</el-button>
          <el-badge value="vip" class="item" v-for="o in 3" :key="o" style="margin: 0 10px">
            <el-button type="info">{{ 12 + o }}</el-button>
          </el-badge>
          <el-button type="info">...</el-button>
        </el-row>
        <el-row style="margin-top: 20px">
          <el-button type="success">立即播放</el-button>
          <i class="el-icon-download" style="color: #FFFFFF;opacity:0.8;margin: 0 10px">下载</i>
          <i class="el-icon-star-off" style="color: #FFFFFF;opacity:0.8">收藏</i>
        </el-row>

      </el-col>
    </el-row>
    <el-row style="margin-top: 20px">
      <el-col :span="4">
        <el-card :body-style="{ padding: '5px'}" style="background-color: #1e1e1e;margin:10px 10px 0 10px">
          <img src="https://t7.baidu.com/it/u=2980892296,1892151125&fm=193&f=GIF"
               class="image">
        </el-card>
      </el-col>
      <el-col :span="18" style="margin-top: 10px">
        <el-row>
          <el-col :span="10">
            <span style="font-size: 20px;font-weight: bold;color: #f4516c">《狂飙》原型黑老大：揭秘幕后大boss</span>
          </el-col>
        </el-row>
        <el-row>
          <span>简介：</span>
          <span style="opacity: 0.8">简介:爆款王炸剧《狂飙》，由徐纪周导演，张译、张颂文、李一桐、张志坚、吴刚领衔主演。是以扫黑除恶常态化为时代背景的影视作品，由众多真实事件改编。一播出就让人记住的高启强，开始让人多心疼，后面就让人有多恨。他在京海市只手遮天，无人能管。为了自己的利...</span>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-button v-for="o in 3" :key="o" type="info">{{ o }}</el-button>
          <el-badge value="付费" class="item" v-for="o in 3" :key="o" style="margin: 0 20px" type="warning">
            <el-button type="info">{{ 3 + o }}</el-button>
          </el-badge>
          <el-button type="info">...</el-button>
        </el-row>
        <el-row style="margin-top: 20px">
          <el-button type="success">立即播放</el-button>
          <i class="el-icon-download" style="color: #FFFFFF;opacity:0.8;margin: 0 10px">下载</i>
          <i class="el-icon-star-off" style="color: #FFFFFF;opacity:0.8">更新提醒</i>
        </el-row>

      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "hotDetail",
  data() {
    return {
      videoName: ''
    }
  },
  mounted() {
    this.videoName = this.$route.query.data
    console.log(this.videoName)
  },
  methods: {}
}
</script>

<style scoped>
.image {
  width: 100%;
  height: 200px;
  display: block;
}
</style>
