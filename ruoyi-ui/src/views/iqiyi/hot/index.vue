<template>
  <div class="container">
    <el-tabs v-model="activeName" type="border-card" style="margin: 10px 10px 0 10px;background-color: dimgrey">
      <el-tab-pane label="热播榜" name="first">
        热播榜
      </el-tab-pane>
      <el-tab-pane label="热搜榜" name="second" style="background-color: darkgrey">
        <el-row>
          <el-col :span="6" :offset="2">
            <el-card class="box-card" style="background-color: darkgrey">
              <div slot="header" class="clearfix">
                <span style="color:#FFFFFF;font-weight: bold">热搜</span>
                <el-button icon="el-icon-refresh" style="float: right; padding: 3px 0" type="text">换一换</el-button>
              </div>
              <div v-for="o in 9" :key="o" class="text item" style="margin-top: 20px;color:#FFFFFF;"
                   @click="$router.push({path: '/iqiyi/hotDetail',query:{data:('热搜 ' + o)} })">
                {{ o }} {{ '热搜 ' + o }}
              </div>
            </el-card>
          </el-col>
          <el-col :span="6" :offset="1">
            <el-card class="box-card" style="background-color: darkgrey">
              <div slot="header" class="clearfix">
                <span style="color:#FFFFFF;">电影</span>
                <el-button icon="el-icon-refresh" style="float: right; padding: 3px 0" type="text">换一换</el-button>
              </div>
              <div v-for="o in 9" :key="o" class="text item" style="margin-top: 20px;color:#FFFFFF;"
                   @click="$router.push({path: '/iqiyi/hotDetail',query:{data:('电影 ' + o)} })">
                {{ o }} {{ '电影 ' + o }}
              </div>
            </el-card>
          </el-col>
          <el-col :span="6" :offset="1">
            <el-card class="box-card" style="background-color: darkgrey">
              <div slot="header" class="clearfix">
                <span style="color:#FFFFFF;">电视剧</span>
                <el-button icon="el-icon-refresh" style="float: right; padding: 3px 0" type="text">换一换</el-button>
              </div>
              <div v-for="o in 9" :key="o" class="text item" style="margin-top: 20px;color:#FFFFFF;"
                   @click="$router.push({path: '/iqiyi/hotDetail',query:{data:('电视剧 ' + o)} })">
                {{ o }} {{ '电视剧 ' + o }}
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="飙升榜" name="third">
        飙升榜
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      activeName: 'second'

    }
  },
  methods: {}
}
</script>

<style scoped>
.container {
  /*height: 100%;*/
}

</style>
