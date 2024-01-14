package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TbHistory;

/**
 * 浏览记录Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-14
 */
public interface TbHistoryMapper
{
    /**
     * 查询浏览记录
     *
     * @param id 浏览记录主键
     * @return 浏览记录
     */
    public TbHistory selectTbHistoryById(Long id);

    /**
     * 查询浏览记录列表
     *
     * @param tbHistory 浏览记录
     * @return 浏览记录集合
     */
    public List<TbHistory> selectTbHistoryList(TbHistory tbHistory);

    /**
     * 新增浏览记录
     *
     * @param tbHistory 浏览记录
     * @return 结果
     */
    public int insertTbHistory(TbHistory tbHistory);

    /**
     * 修改浏览记录
     *
     * @param tbHistory 浏览记录
     * @return 结果
     */
    public int updateTbHistory(TbHistory tbHistory);

    /**
     * 删除浏览记录
     *
     * @param id 浏览记录主键
     * @return 结果
     */
    public int deleteTbHistoryById(Long id);

    /**
     * 批量删除浏览记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbHistoryByIds(Long[] ids);
}