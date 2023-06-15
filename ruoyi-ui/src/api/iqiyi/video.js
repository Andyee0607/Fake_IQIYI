import request from '@/utils/request'

// 查询视频管理列表
export function listVideo(query) {
  return request({
    url: '/iqiyi/video/list',
    method: 'get',
    params: query
  })
}

// 查询视频管理列表
export function view(query) {
  return request({
    url: '/iqiyi/video/view',
    method: 'get',
    params: query
  })
}

// 查询视频管理详细
export function getVideo(id) {
  return request({
    url: '/iqiyi/video/' + id,
    method: 'get'
  })
}

// 新增视频管理
export function addVideo(data) {
  return request({
    url: '/iqiyi/video',
    method: 'post',
    data: data
  })
}

// 修改视频管理
export function updateVideo(data) {
  return request({
    url: '/iqiyi/video',
    method: 'put',
    data: data
  })
}

// 删除视频管理
export function delVideo(id) {
  return request({
    url: '/iqiyi/video/' + id,
    method: 'delete'
  })
}
