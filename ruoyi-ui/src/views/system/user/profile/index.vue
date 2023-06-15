<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="6" :xs="24">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>个人信息</span>
          </div>
          <div>
            <div class="text-center">
              <userAvatar :user="user"/>
            </div>
            <ul class="list-group list-group-striped">
              <li v-if="user.isVip==='Y'" class="list-group-item">
                <el-tag><i class="el-icon-s-opportunity"></i>尊贵的VIP</el-tag>
                <div class="pull-right">
                  <el-tag type="warning">2023-05-13到期</el-tag>
                </div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="user"/>
                用户名称
                <div class="pull-right">{{ user.userName }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="phone"/>
                手机号码
                <div class="pull-right">{{ user.phonenumber }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="email"/>
                用户邮箱
                <div class="pull-right">{{ user.email }}</div>
              </li>
              <!--              <li class="list-group-item">-->
              <!--                <svg-icon icon-class="tree" />所属部门-->
              <!--                <div class="pull-right" v-if="user.dept">{{ user.dept.deptName }} / {{ postGroup }}</div>-->
              <!--              </li>-->
              <!--              <li class="list-group-item">-->
              <!--                <svg-icon icon-class="peoples" />所属角色-->
              <!--                <div class="pull-right">{{ roleGroup }}</div>-->
              <!--              </li>-->
              <li class="list-group-item">
                <svg-icon icon-class="date"/>
                创建日期
                <div class="pull-right">{{ user.createTime }}</div>
              </li>
            </ul>
          </div>
        </el-card>
      </el-col>
      <el-col :span="18" :xs="24">
        <el-card>
          <div slot="header" class="clearfix">
            <span>基本资料</span>
          </div>
          <el-tabs v-model="activeTab">
            <el-tab-pane label="基本资料" name="userinfo">
              <userInfo :user="user"/>
            </el-tab-pane>
            <el-tab-pane label="修改密码" name="resetPwd">
              <resetPwd/>
            </el-tab-pane>
            <el-tab-pane label="观看历史" name="watchHis">
              <WatchHis/>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-card :body-style="{ padding: '5px'}" style="margin-top: 10px">
        <div slot="header" class="clearfix">
          <span>热门活动</span>
        </div>
        <div style="padding: 10px;">
          <el-col :span="4" :offset="1">
            <el-result  title="学生专享" subTitle="每年仅123员">
              <template slot="icon">
                <el-image src="https://img1.baidu.com/it/u=4227701686,2682873607&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"></el-image>
              </template>
              <template slot="extra">
                <el-button type="primary" size="medium">去看看</el-button>
              </template>
            </el-result>
          </el-col>
          <el-col :span="4" :offset="1">
            <el-result title="攒会员" subTitle="最高赚年卡">
              <template slot="icon">
                <el-image src="https://i-1.netded.com/2022/0221/087a62984154caf258f600591c07521d.png"></el-image>
              </template>
              <template slot="extra">
                <el-button type="primary" size="medium">去看看</el-button>
              </template>
            </el-result>
          </el-col>
        </div>
      </el-card>
    </el-row>
  </div>
</template>

<script>
import userAvatar from "./userAvatar";
import userInfo from "./userInfo";
import resetPwd from "./resetPwd";
import {getUserProfile} from "@/api/system/user";
import WatchHis from "./watchHis";

export default {
  name: "Profile",
  components: {WatchHis, userAvatar, userInfo, resetPwd},
  data() {
    return {
      user: {},
      roleGroup: {},
      postGroup: {},
      activeTab: "userinfo"
    };
  },
  created() {
    this.getUser();
  },
  methods: {
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        this.roleGroup = response.roleGroup;
        this.postGroup = response.postGroup;
      });
    }
  }
};
</script>
