<template>
  <div class="main">
    <div class="playArea">
      <video-player
        ref="videoPlayer"
        :playsinline="true"
        :options="playerOptions"
        @pause="onPlayerPause($event)"
        @play="onPlayerPlay($event)"
        @ended="onPlayerEnded($event)"
        @timeupdate="onPlayerTimeupdate($event)"
        @ready="playerReadied"
      >
        Your browser does not support the video tag.
      </video-player>
      <div class="tilt" @click="onPlayerClick">
        <div class="but" v-show="!isPlay"></div>
      </div>
    </div>
    <!--    <div class="title">当前播放时长：{{ currentTime }}</div>-->
  </div>
</template>
<script>
import {videoPlayer} from "vue-video-player";
import "video.js/dist/video-js.css";
import {isEmpty} from "@/utils/validate";

export default {
  name: "VueVideoPlayer",
  components: {
    videoPlayer,
  },
  data() {
    return {
      isPlay: false,
      currentTime: 0,
      playerOptions: {
        playbackRates: [0.5, 1.0, 1.5, 2.0], // 可选的播放速度
        autoplay: false, // 如果为true,浏览器准备好时开始回放。
        muted: false, // 默认情况下将会消除任何音频。
        loop: false, // 是否视频一结束就重新开始。
        preload: "auto", // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        language: "zh-CN",
        aspectRatio: "16:9", // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
        sources: [
          {
            type: "video/mp4", // 类型
            // src: "http://vjs.zencdn.net/v/oceans.mp4", // url地址
            src: "", // url地址
          },
        ],
        poster: "", // 封面地址
        notSupportedMessage: "此视频暂无法播放，请稍后再试", // 允许覆盖Video.js无法播放媒体源时显示的默认信息。
        controlBar: {
          timeDivider: true, // 当前时间和持续时间的分隔符
          durationDisplay: true, // 显示持续时间
          remainingTimeDisplay: false, // 是否显示剩余时间功能
          fullscreenToggle: true, // 是否显示全屏按钮
        },
      },
    };
  },
  props: {
    url: {
      type: String,
      required: true,
    }
  },
  computed: {
    player() {
      return this.$refs.videoPlayer.player;
    },
  },
  mounted() {
    if (!isEmpty(this.url)) {
      this.playerOptions.sources[0].src = this.url
    }
  },
  methods: {
    onPlayerPause($event) {
      this.isPlay = false;
    },
    onPlayerPlay($event) {
      this.isPlay = true;
    },
    onPlayerEnded($event) {
    },
    onPlayerClick() {
      if (this.isPlay) {
        this.player.pause();
      } else {
        this.player.play();
      }
    },
    /* 获取视频播放进度 */
    onPlayerTimeupdate(player) {
      this.currentTime = player.cache_.currentTime;
    },
    /* 设置视频进度 */
    playerReadied(player) {
      player.currentTime(this.currentTime);
    },
  },
};
</script>
