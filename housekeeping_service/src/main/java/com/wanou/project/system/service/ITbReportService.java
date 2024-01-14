package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TbReport;

/**
 * 用户举报Service接口
 *
 * @author ruoyi
 * @date 2024-01-14
 */
public interface ITbReportService
{
    /**
     * 查询用户举报
     *
     * @param id 用户举报主键
     * @return 用户举报
     */
    public TbReport selectTbReportById(Long id);

    /**
     * 查询用户举报列表
     *
     * @param tbReport 用户举报
     * @return 用户举报集合
     */
    public List<TbReport> selectTbReportList(TbReport tbReport);

    /**
     * 新增用户举报
     *
     * @param tbReport 用户举报
     * @return 结果
     */
    public int insertTbReport(TbReport tbReport);

    /**
     * 修改用户举报
     *
     * @param tbReport 用户举报
     * @return 结果
     */
    public int updateTbReport(TbReport tbReport);

    /**
     * 批量删除用户举报
     *
     * @param ids 需要删除的用户举报主键集合
     * @return 结果
     */
    public int deleteTbReportByIds(Long[] ids);

    /**
     * 删除用户举报信息
     *
     * @param id 用户举报主键
     * @return 结果
     */
    public int deleteTbReportById(Long id);
}
