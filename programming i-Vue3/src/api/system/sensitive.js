import request from '@/utils/request'

// 查询敏感词管理列表
export function listSensitive(query) {
    return request({
        url: '/system/sensitive/list',
        method: 'get',
        params: query
    })
}

// 查询敏感词管理详细
export function getSensitive(id) {
    return request({
        url: '/system/sensitive/' + id,
        method: 'get'
    })
}

// 新增敏感词管理
export function addSensitive(data) {
    return request({
        url: '/system/sensitive',
        method: 'post',
        data: data
    })
}

// 修改敏感词管理
export function updateSensitive(data) {
    return request({
        url: '/system/sensitive',
        method: 'put',
        data: data
    })
}

// 删除敏感词管理
export function delSensitive(id) {
    return request({
        url: '/system/sensitive/' + id,
        method: 'delete'
    })
}

// 导出敏感词管理
export function exportSensitive(query) {
    return request({
        url: '/system/sensitive/export',
        method: 'get',
        params: query
    })
}
