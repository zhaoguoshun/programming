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
import com.wanou.project.system.domain.TbHistory;
import com.wanou.project.system.service.ITbHistoryService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 浏览记录Controller
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@RestController
@RequestMapping("/system/history")
public class TbHistoryController extends BaseController
{
    @Autowired
    private ITbHistoryService tbHistoryService;

    /**
     * 查询浏览记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbHistory tbHistory)
    {
        startPage();
        List<TbHistory> list = tbHistoryService.selectTbHistoryList(tbHistory);
        return getDataTable(list);
    }

    /**
     * 导出浏览记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:history:export')")
    @Log(title = "浏览记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TbHistory tbHistory)
    {
        List<TbHistory> list = tbHistoryService.selectTbHistoryList(tbHistory);
        ExcelUtil<TbHistory> util = new ExcelUtil<TbHistory>(TbHistory.class);
        return util.exportExcel(list, "浏览记录数据");
    }

    /**
     * 获取浏览记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tbHistoryService.selectTbHistoryById(id));
    }

    /**
     * 新增浏览记录
     */
    @PreAuthorize("@ss.hasPermi('system:history:add')")
    @Log(title = "浏览记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbHistory tbHistory)
    {
        return toAjax(tbHistoryService.insertTbHistory(tbHistory));
    }

    /**
     * 修改浏览记录
     */
    @PreAuthorize("@ss.hasPermi('system:history:edit')")
    @Log(title = "浏览记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbHistory tbHistory)
    {
        return toAjax(tbHistoryService.updateTbHistory(tbHistory));
    }

    /**
     * 删除浏览记录
     */
    @PreAuthorize("@ss.hasPermi('system:history:remove')")
    @Log(title = "浏览记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbHistoryService.deleteTbHistoryByIds(ids));
    }
}
