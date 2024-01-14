import request from '@/utils/request'

// 查询订单管理详细
export function getCounts(id) {
  return request({
    url: '/drawing/count',
    method: 'get'
  })
}
