package com.wanou.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wanou.framework.aspectj.lang.annotation.Log;
import com.wanou.framework.aspectj.lang.enums.BusinessType;
import com.wanou.project.system.domain.TbReport;
import com.wanou.project.system.service.ITbReportService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 用户举报Controller
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@RestController
@RequestMapping("/system/report")
public class TbReportController extends BaseController
{
    @Autowired
    private ITbReportService tbReportService;

    /**
     * 查询用户举报列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TbReport tbReport)
    {
        startPage();
        List<TbReport> list = tbReportService.selectTbReportList(tbReport);
        return getDataTable(list);
    }

    /**
     * 导出用户举报列表
     */
    @Log(title = "用户举报", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TbReport tbReport)
    {
        List<TbReport> list = tbReportService.selectTbReportList(tbReport);
        ExcelUtil<TbReport> util = new ExcelUtil<TbReport>(TbReport.class);
        return util.exportExcel(list, "用户举报数据");
    }

    /**
     * 获取用户举报详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tbReportService.selectTbReportById(id));
    }

    /**
     * 新增用户举报
     */
    @Log(title = "用户举报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbReport tbReport)
    {
        return toAjax(tbReportService.insertTbReport(tbReport));
    }

    /**
     * 修改用户举报
     */
    @Log(title = "用户举报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbReport tbReport)
    {
        return toAjax(tbReportService.updateTbReport(tbReport));
    }

    /**
     * 删除用户举报
     */
    @Log(title = "用户举报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbReportService.deleteTbReportByIds(ids));
    }
}
