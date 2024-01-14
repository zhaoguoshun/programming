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
import com.wanou.project.system.domain.TbSlideshow;
import com.wanou.project.system.service.ITbSlideshowService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 轮播图Controller
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@RestController
@RequestMapping("/system/slideshow")
public class TbSlideshowController extends BaseController
{
    @Autowired
    private ITbSlideshowService tbSlideshowService;

    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('system:slideshow:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbSlideshow tbSlideshow)
    {
        startPage();
        List<TbSlideshow> list = tbSlideshowService.selectTbSlideshowList(tbSlideshow);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('system:slideshow:export')")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TbSlideshow tbSlideshow)
    {
        List<TbSlideshow> list = tbSlideshowService.selectTbSlideshowList(tbSlideshow);
        ExcelUtil<TbSlideshow> util = new ExcelUtil<TbSlideshow>(TbSlideshow.class);
        return util.exportExcel(list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:slideshow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tbSlideshowService.selectTbSlideshowById(id));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('system:slideshow:add')")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbSlideshow tbSlideshow)
    {
        return toAjax(tbSlideshowService.insertTbSlideshow(tbSlideshow));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('system:slideshow:edit')")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbSlideshow tbSlideshow)
    {
        return toAjax(tbSlideshowService.updateTbSlideshow(tbSlideshow));
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('system:slideshow:remove')")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbSlideshowService.deleteTbSlideshowByIds(ids));
    }
}
