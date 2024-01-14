package com.wanou.project.system.service.impl;

import java.util.List;
import com.wanou.common.utils.DateUtils;
import com.wanou.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbReportMapper;
import com.wanou.project.system.domain.TbReport;
import com.wanou.project.system.service.ITbReportService;

/**
 * 用户举报Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@Service
public class TbReportServiceImpl implements ITbReportService
{
    @Autowired
    private TbReportMapper tbReportMapper;

    /**
     * 查询用户举报
     *
     * @param id 用户举报主键
     * @return 用户举报
     */
    @Override
    public TbReport selectTbReportById(Long id)
    {
        return tbReportMapper.selectTbReportById(id);
    }

    /**
     * 查询用户举报列表
     *
     * @param tbReport 用户举报
     * @return 用户举报
     */
    @Override
    public List<TbReport> selectTbReportList(TbReport tbReport)
    {
        return tbReportMapper.selectTbReportList(tbReport);
    }

    /**
     * 新增用户举报
     *
     * @param tbReport 用户举报
     * @return 结果
     */
    @Override
    public int insertTbReport(TbReport tbReport)
    {
        tbReport.setCreateTime(DateUtils.getNowDate());
        tbReport.setUserId(SecurityUtils.getUserId());
        return tbReportMapper.insertTbReport(tbReport);
    }

    /**
     * 修改用户举报
     *
     * @param tbReport 用户举报
     * @return 结果
     */
    @Override
    public int updateTbReport(TbReport tbReport)
    {
        return tbReportMapper.updateTbReport(tbReport);
    }

    /**
     * 批量删除用户举报
     *
     * @param ids 需要删除的用户举报主键
     * @return 结果
     */
    @Override
    public int deleteTbReportByIds(Long[] ids)
    {
        return tbReportMapper.deleteTbReportByIds(ids);
    }

    /**
     * 删除用户举报信息
     *
     * @param id 用户举报主键
     * @return 结果
     */
    @Override
    public int deleteTbReportById(Long id)
    {
        return tbReportMapper.deleteTbReportById(id);
    }
}
