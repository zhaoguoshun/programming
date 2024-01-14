import request from '@/utils/request'

// 查询轮播图列表
export function listSlideshow(query) {
    return request({
        url: '/system/slideshow/list',
        method: 'get',
        params: query
    })
}

// 查询轮播图详细
export function getSlideshow(id) {
    return request({
        url: '/system/slideshow/' + id,
        method: 'get'
    })
}

// 新增轮播图
export function addSlideshow(data) {
    return request({
        url: '/system/slideshow',
        method: 'post',
        data: data
    })
}

// 修改轮播图
export function updateSlideshow(data) {
    return request({
        url: '/system/slideshow',
        method: 'put',
        data: data
    })
}

// 删除轮播图
export function delSlideshow(id) {
    return request({
        url: '/system/slideshow/' + id,
        method: 'delete'
    })
}

// 导出轮播图
export function exportSlideshow(query) {
    return request({
        url: '/system/slideshow/export',
        method: 'get',
        params: query
    })
}
