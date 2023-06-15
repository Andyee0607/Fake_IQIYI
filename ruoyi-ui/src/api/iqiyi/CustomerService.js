import request from '@/utils/request'

// 查询在线问题管理列表
export function listCustomerService(query) {
  return request({
    url: '/iqiyi/CustomerService/list',
    method: 'get',
    params: query
  })
}

// 查询在线问题管理详细
export function getCustomerService(id) {
  return request({
    url: '/iqiyi/CustomerService/' + id,
    method: 'get'
  })
}

// 新增在线问题管理
export function addCustomerService(data) {
  return request({
    url: '/iqiyi/CustomerService',
    method: 'post',
    data: data
  })
}

// 修改在线问题管理
export function updateCustomerService(data) {
  return request({
    url: '/iqiyi/CustomerService',
    method: 'put',
    data: data
  })
}

// 删除在线问题管理
export function delCustomerService(id) {
  return request({
    url: '/iqiyi/CustomerService/' + id,
    method: 'delete'
  })
}
