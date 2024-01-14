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
import com.wanou.project.system.domain.TbSensitive;
import com.wanou.project.system.service.ITbSensitiveService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 敏感词管理Controller
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@RestController
@RequestMapping("/system/sensitive")
public class TbSensitiveController extends BaseController
{
    @Autowired
    private ITbSensitiveService tbSensitiveService;

    /**
     * 查询敏感词管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sensitive:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbSensitive tbSensitive)
    {
        startPage();
        List<TbSensitive> list = tbSensitiveService.selectTbSensitiveList(tbSensitive);
        return getDataTable(list);
    }

    /**
     * 导出敏感词管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sensitive:export')")
    @Log(title = "敏感词管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TbSensitive tbSensitive)
    {
        List<TbSensitive> list = tbSensitiveService.selectTbSensitiveList(tbSensitive);
        ExcelUtil<TbSensitive> util = new ExcelUtil<TbSensitive>(TbSensitive.class);
        return util.exportExcel(list, "敏感词管理数据");
    }

    /**
     * 获取敏感词管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sensitive:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tbSensitiveService.selectTbSensitiveById(id));
    }

    /**
     * 新增敏感词管理
     */
    @PreAuthorize("@ss.hasPermi('system:sensitive:add')")
    @Log(title = "敏感词管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbSensitive tbSensitive)
    {
        return toAjax(tbSensitiveService.insertTbSensitive(tbSensitive));
    }

    /**
     * 修改敏感词管理
     */
    @PreAuthorize("@ss.hasPermi('system:sensitive:edit')")
    @Log(title = "敏感词管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbSensitive tbSensitive)
    {
        return toAjax(tbSensitiveService.updateTbSensitive(tbSensitive));
    }

    /**
     * 删除敏感词管理
     */
    @PreAuthorize("@ss.hasPermi('system:sensitive:remove')")
    @Log(title = "敏感词管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbSensitiveService.deleteTbSensitiveByIds(ids));
    }
}
