package com.wanou.project.system.service.impl;

import java.util.List;
import com.wanou.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbSlideshowMapper;
import com.wanou.project.system.domain.TbSlideshow;
import com.wanou.project.system.service.ITbSlideshowService;

/**
 * 轮播图Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@Service
public class TbSlideshowServiceImpl implements ITbSlideshowService
{
    @Autowired
    private TbSlideshowMapper tbSlideshowMapper;

    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public TbSlideshow selectTbSlideshowById(Long id)
    {
        return tbSlideshowMapper.selectTbSlideshowById(id);
    }

    /**
     * 查询轮播图列表
     *
     * @param tbSlideshow 轮播图
     * @return 轮播图
     */
    @Override
    public List<TbSlideshow> selectTbSlideshowList(TbSlideshow tbSlideshow)
    {
        return tbSlideshowMapper.selectTbSlideshowList(tbSlideshow);
    }

    /**
     * 新增轮播图
     *
     * @param tbSlideshow 轮播图
     * @return 结果
     */
    @Override
    public int insertTbSlideshow(TbSlideshow tbSlideshow)
    {
        tbSlideshow.setCreateTime(DateUtils.getNowDate());
        return tbSlideshowMapper.insertTbSlideshow(tbSlideshow);
    }

    /**
     * 修改轮播图
     *
     * @param tbSlideshow 轮播图
     * @return 结果
     */
    @Override
    public int updateTbSlideshow(TbSlideshow tbSlideshow)
    {
        return tbSlideshowMapper.updateTbSlideshow(tbSlideshow);
    }

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteTbSlideshowByIds(Long[] ids)
    {
        return tbSlideshowMapper.deleteTbSlideshowByIds(ids);
    }

    /**
     * 删除轮播图信息
     *
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteTbSlideshowById(Long id)
    {
        return tbSlideshowMapper.deleteTbSlideshowById(id);
    }
}
