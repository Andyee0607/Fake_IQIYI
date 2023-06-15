<template>
  <div class="container">
    <!--    轮播视频-->
    <div class="show-imgs-container" @mouseover="isIn = true" @mouseout="isIn = false">
      <el-input
        placeholder="请输入内容" v-model="seachValue" class="search" v-if="searchShow"
        style="position:absolute;top: 35px; left:50%; transform:translate(-50%, -50%); z-index:10013; opacity:0.8;">
        <el-button slot="append" icon="el-icon-sunny" @click="redirectHot">热搜榜</el-button>
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
      <el-carousel :interval="5000" height="300px" width="400px" @change="getIndex" arrow="always" :autoplay="autoplay"
                   :indicator-position="autoplay?'':'none'">
        <el-carousel-item v-for="(item,index) in videoList" :key="index">
          <!--视频播放器 -->
          <video :ref="'videoPlayer' + index" :controls="isIn">
            <source :src="item.url" type="video/mp4">
            您的浏览器不支持Video标签。
          </video>
          <i v-show="!isPlay" class="play-btn el-icon-video-play" @click="playVideo"></i>
          <i v-show="isPlay && isIn" class="play-btn el-icon-video-pause" @click="pauseVideo"></i>
        </el-carousel-item>
      </el-carousel>
    </div>
    <!--    正在热播-->
    <div style="padding: 0 20px 0 20px">
      <el-row>
        <span style="font-size: 22px;color: #dddddd;margin-bottom: 10px">正在热播</span>
      </el-row>
      <el-row>
        <el-col :span="4" v-for="(item,index) in videoList" :key="index" :offset="(index%5 !== 0 ? 1 : 0)">
          <el-card :body-style="{ padding: '5px'}" style="background-color: #1e1e1e;margin-top: 10px">
            <img :src="item.img"
                 class="image" @click="handleVideoShow(item)">
            <div style="padding: 10px;">
              <span style="color: #dddddd">{{ item.name }}</span>
              <div class="bottom clearfix">
                <time class="time">{{ item.remark }}</time>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <!--    电视剧-->
    <div style="padding: 0 20px 0 20px">
      <el-row>
        <span style="font-size: 22px;color: #dddddd;margin-bottom: 10px">电视剧</span>
      </el-row>
      <el-row>
        <el-col :span="4" v-for="(item,index) in TVList" :key="index" :offset="(index%5 !== 0 ? 1 : 0)">
          <el-card :body-style="{ padding: '5px'}" style="background-color: #1e1e1e;margin-top: 10px">
            <img :src="item.img"
                 class="image" @click="handleVideoShow(item)">
            <div style="padding: 10px;">
              <span style="color: #dddddd">{{ item.name }}</span>
              <div class="bottom clearfix">
                <time class="time">{{ item.remark }}</time>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <!--    电影-->
    <div style="padding: 0 20px 0 20px">
      <el-row>
        <span style="font-size: 22px;color: #dddddd;margin-bottom: 10px">电影</span>
      </el-row>
      <el-row>
        <el-col :span="4" v-for="(item,index) in FilmList" :key="index" :offset="(index%5 !== 0 ? 1 : 0)">
          <el-card :body-style="{ padding: '5px'}" style="background-color: #1e1e1e;margin-top: 10px">
            <img :src="item.img"
                 class="image" @click="handleVideoShow(item)">
            <div style="padding: 10px;">
              <span style="color: #dddddd">{{ item.name }}</span>
              <div class="bottom clearfix">
                <time class="time">{{ item.remark }}</time>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <!--    综艺-->
    <div style="padding: 0 20px 0 20px">
      <el-row>
        <span style="font-size: 22px;color: #dddddd;margin-bottom: 10px">综艺</span>
      </el-row>
      <el-row>
        <el-col :span="4" v-for="(item,index) in VSList" :key="index" :offset="(index%5 !== 0 ? 1 : 0)">
          <el-card :body-style="{ padding: '5px'}" style="background-color: #1e1e1e;margin-top: 10px">
            <img :src="item.img"
                 class="image" @click="handleVideoShow(item)">
            <div style="padding: 10px;">
              <span style="color: #dddddd">{{ item.name }}</span>
              <div class="bottom clearfix">
                <time class="time">{{ item.remark }}</time>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <el-dialog :title="nowVideo.name" :visible.sync="nowVideoVis" append-to-body
               @close="dialogClose">
      <vue-video-player :url="nowVideo.url" v-if="nowVideoVis"></vue-video-player>
    </el-dialog>
  </div>
</template>

<script>
import {listVideo, getVideo, delVideo, addVideo, updateVideo} from "@/api/iqiyi/video";
import {videoPlayer} from "vue-video-player";
import "video.js/dist/video-js.css";
import "videojs-flash"
import VueVideoPlayer from "./components/VideoPlayer/vueVideoPlayer";

export default {
  name: "vshow",
  components: {VueVideoPlayer, videoPlayer},
  data() {
    return {
      videoParams: {
        pageNum: 1,
        pageSize: 20,
        url: null,
        type: null,
        name: null,
      },
      videoList: [],
      TVList: [],
      FilmList: [],
      VSList: [],
      isPlay: false,
      isIn: false,//鼠标是否位于播放器内
      autoplay: true,
      nowIndex: 0,
      seachValue: '',
      searchShow: true,
      nowVideoVis: false,
      nowVideo: {}
    };
  },
  created() {
    this.VSList = []
    this.FilmList = []
    this.TVList = []
    listVideo(this.videoParams).then(res => {
      this.videoList = res.rows;
      res.rows.forEach(e => {
        if (e.type === '0')
          this.TVList.push(e)
        else if (e.type === '1')
          this.FilmList.push(e)
        else if (e.type === '2')
          this.VSList.push(e)

      })
    })
  },
  mounted() {
    //初始监听第一个视频
    this.listenVideo();
  },
  methods: {
    //获取走马灯的索引
    getIndex(nowIndex, oldIndex) {
      //用户可能在上个视频未播放完毕就切换
      //此时需要暂停上个视频并把时间归零，否则影响对当前视频的监听逻辑
      let myVideo = this.$refs['videoPlayer' + oldIndex];
      myVideo[0].pause();
      myVideo[0].currentTime = 0;
      this.nowIndex = nowIndex;
      this.listenVideo();
    },
    //监听视频的播放、暂停、播放完毕等事件
    listenVideo() {
      //注意：这样获取的dom是一个数组，必须加上[0]索引才能正确的添加事件
      let myVideo = this.$refs['videoPlayer' + this.nowIndex];
      //监听播放
      myVideo[0].addEventListener("play", () => {
        this.autoplay = false;
        this.isPlay = true;
      });
      //监听暂停
      myVideo[0].addEventListener("pause", () => {
        this.autoplay = true;
        this.isPlay = false;
      });
      //监听播放完毕
      myVideo[0].addEventListener("ended", () => {
        //时间归零
        myVideo[0].currentTime = 0;
        this.autoplay = true;
        this.isPlay = false;
      });
    },
    //播放视频
    playVideo() {
      //注意：这样获取的dom是一个数组，必须加上[0]索引才能正确的添加事件
      let myVideo = this.$refs['videoPlayer' + this.nowIndex];
      myVideo[0].play();
    },
    //暂停视频
    pauseVideo() {
      //注意：这样获取的dom是一个数组，必须加上[0]索引才能正确的添加事件
      let myVideo = this.$refs['videoPlayer' + this.nowIndex];
      myVideo[0].pause();
    },
    handleVideoShow(video) {
      this.nowVideo = video;
      this.nowVideoVis = true;
      this.searchShow = false;
    },
    dialogClose() {
      this.searchShow = true
    },
    redirectHot() {
      this.$router.push({path: "/iqiyi/hot"})
    }
  },

};
</script>

<style lang="less">
.container {
  //background-color: #5a5e66;
}

.show-imgs-container {
  height: 100%;
  //width: 60%;
  padding: 10px 10px 10px 10px;

  .el-carousel {
    width: 100%;
    height: 100%;
  }

  .el-carousel__container {
    width: 100%;
    height: 100%;
  }

  .el-carousel__item {
    width: 100%;
    height: 100%;
    border-radius: 10px;

    video {
      width: 100%;
      height: 100%;
      position: fixed;
      display: inline-block;
      vertical-align: baseline;
      horiz-align: center;
      object-fit: fill; //消除留白
    }

    .play-btn {
      font-size: 60px;
      color: #fff;
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);

      &:hover {
        cursor: pointer;
      }
    }
  }
}

.search {
  width: 20%;
  text-align: center;
  padding: 0 0 2px 0;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  height: 150px;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

</style>

