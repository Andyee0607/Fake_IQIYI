<template>
  <div>
    <el-card style="margin: 10px 10px 0 10px">
      <el-row style="height: 400px;width: 80%;margin: 10px 10px 0 10px">
        <el-col :span="8">
          <el-card style="height: 400px">
            <div slot="header" class="clearfix">
              <span>猜你想问</span>
              <el-button icon="el-icon-refresh" style="float: right; padding: 3px 0" type="text">换一换</el-button>
            </div>
            <el-collapse>
              <el-collapse-item title="修改手机号" name="1">
              </el-collapse-item>
              <el-collapse-item title="客户端播放卡顿如何解决？" name="2">
              </el-collapse-item>
              <el-collapse-item title="移动端播放出现问题怎么办？" name="3">
              </el-collapse-item>
              <el-collapse-item title="账号无法登陆" name="4">
              </el-collapse-item>
            </el-collapse>
          </el-card>
        </el-col>
      </el-row>

      <el-row>
        <el-col>
          <el-input placeholder="请输入您的问题" v-model="queryParams.question" class="input-with-select"
                    style="margin: 10px 0 10px 10px">
            <el-button slot="append" icon="el-icon-search" @click="inquire"></el-button>
          </el-input>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import {
  listCustomerService,
} from "@/api/iqiyi/CustomerService";

export default {
  name: "index",
  data() {
    return {
      queryParams: {
        pageNum: 1,
        pageSize: 100,
        question: null,
        answer: null,
      },
      tableData: []
    }
  },
  mounted() {

  },
  methods: {
    inquire() {
      console.log(this.queryParams)
      listCustomerService(this.queryParams).then(response => {
        this.tableData = response.rows
      });
    }
  }
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}
</style>
