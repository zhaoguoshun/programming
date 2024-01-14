package com.wanou.project.system.service.impl;

import java.util.List;
import com.wanou.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbHistoryMapper;
import com.wanou.project.system.domain.TbHistory;
import com.wanou.project.system.service.ITbHistoryService;

/**
 * 浏览记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@Service
public class TbHistoryServiceImpl implements ITbHistoryService
{
    @Autowired
    private TbHistoryMapper tbHistoryMapper;

    /**
     * 查询浏览记录
     *
     * @param id 浏览记录主键
     * @return 浏览记录
     */
    @Override
    public TbHistory selectTbHistoryById(Long id)
    {
        return tbHistoryMapper.selectTbHistoryById(id);
    }

    /**
     * 查询浏览记录列表
     *
     * @param tbHistory 浏览记录
     * @return 浏览记录
     */
    @Override
    public List<TbHistory> selectTbHistoryList(TbHistory tbHistory)
    {
        return tbHistoryMapper.selectTbHistoryList(tbHistory);
    }

    /**
     * 新增浏览记录
     *
     * @param tbHistory 浏览记录
     * @return 结果
     */
    @Override
    public int insertTbHistory(TbHistory tbHistory)
    {
        tbHistory.setCreateTime(DateUtils.getNowDate());
        return tbHistoryMapper.insertTbHistory(tbHistory);
    }

    /**
     * 修改浏览记录
     *
     * @param tbHistory 浏览记录
     * @return 结果
     */
    @Override
    public int updateTbHistory(TbHistory tbHistory)
    {
        return tbHistoryMapper.updateTbHistory(tbHistory);
    }

    /**
     * 批量删除浏览记录
     *
     * @param ids 需要删除的浏览记录主键
     * @return 结果
     */
    @Override
    public int deleteTbHistoryByIds(Long[] ids)
    {
        return tbHistoryMapper.deleteTbHistoryByIds(ids);
    }

    /**
     * 删除浏览记录信息
     *
     * @param id 浏览记录主键
     * @return 结果
     */
    @Override
    public int deleteTbHistoryById(Long id)
    {
        return tbHistoryMapper.deleteTbHistoryById(id);
    }
}
