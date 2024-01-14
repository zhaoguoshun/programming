package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TbSlideshow;

/**
 * 轮播图Service接口
 *
 * @author ruoyi
 * @date 2024-01-14
 */
public interface ITbSlideshowService
{
    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    public TbSlideshow selectTbSlideshowById(Long id);

    /**
     * 查询轮播图列表
     *
     * @param tbSlideshow 轮播图
     * @return 轮播图集合
     */
    public List<TbSlideshow> selectTbSlideshowList(TbSlideshow tbSlideshow);

    /**
     * 新增轮播图
     *
     * @param tbSlideshow 轮播图
     * @return 结果
     */
    public int insertTbSlideshow(TbSlideshow tbSlideshow);

    /**
     * 修改轮播图
     *
     * @param tbSlideshow 轮播图
     * @return 结果
     */
    public int updateTbSlideshow(TbSlideshow tbSlideshow);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的轮播图主键集合
     * @return 结果
     */
    public int deleteTbSlideshowByIds(Long[] ids);

    /**
     * 删除轮播图信息
     *
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteTbSlideshowById(Long id);
}
