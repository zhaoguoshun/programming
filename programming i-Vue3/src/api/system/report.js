import request from '@/utils/request'

// 查询用户举报列表
export function listReport(query) {
    return request({
        url: '/system/report/list',
        method: 'get',
        params: query
    })
}

// 查询用户举报详细
export function getReport(id) {
    return request({
        url: '/system/report/' + id,
        method: 'get'
    })
}

// 新增用户举报
export function addReport(data) {
    return request({
        url: '/system/report',
        method: 'post',
        data: data
    })
}

// 修改用户举报
export function updateReport(data) {
    return request({
        url: '/system/report',
        method: 'put',
        data: data
    })
}

// 删除用户举报
export function delReport(id) {
    return request({
        url: '/system/report/' + id,
        method: 'delete'
    })
}

// 导出用户举报
export function exportReport(query) {
    return request({
        url: '/system/report/export',
        method: 'get',
        params: query
    })
}
