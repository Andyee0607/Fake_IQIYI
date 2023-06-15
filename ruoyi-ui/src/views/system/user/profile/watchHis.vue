<template>
  <div>
    <el-empty v-if="videoList.length===0" description="无历史记录"></el-empty>
    <div style="padding: 0 20px 0 20px">
      <el-row>
        <el-col :span="3" v-for="(item,index) in videoList" :key="index" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '5px'}">
            <img :src="item.img"
                 class="image" @click="handleVideoShow(item)">
            <div style="padding: 10px;">
              <span>{{ item.name }}</span>
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
      <VueVideoPlayer :url="nowVideo.url" v-if="nowVideoVis"></VueVideoPlayer>
    </el-dialog>
  </div>
</template>

<script>
import {listVideo, getVideo, delVideo, addVideo, updateVideo} from "@/api/iqiyi/video";
import "video.js/dist/video-js.css";
import "videojs-flash"
import VueVideoPlayer from "../../../components/VideoPlayer/vueVideoPlayer";
import {getUserProfile} from "../../../../api/system/user";

export default {
  name: "watchHis",
  components: {VueVideoPlayer},
  data() {
    return {
      videoParams: {
        pageNum: 1,
        pageSize: 6,
        url: null,
        type: null,
        name: null,
      },
      videoList: [],
      nowVideoVis: false,
      nowVideo: {}
    }
  },
  mounted() {
    getUserProfile().then(response => {
      const user = response.data;
      if (user.watchHistory !== null)
        user.watchHistory.split(",").forEach(e => {
          getVideo(e).then(res => {
            this.videoList.push(res.data)
          })
        })
    });
  },
  methods: {
    handleVideoShow(video) {
      this.nowVideo = video;
      this.nowVideoVis = true;
      this.searchShow = false;
    },
    dialogClose() {
      this.searchShow = true
    }
  }
}
</script>

<style scoped>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.image {
  width: 100%;
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
