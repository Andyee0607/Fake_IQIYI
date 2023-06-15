package com.ruoyi.iqiyi.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.iqiyi.domain.BaseVideo;
import com.ruoyi.iqiyi.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 视频管理Controller
 *
 */
@RestController
@RequestMapping("/iqiyi/video")
public class VideoController extends BaseController
{
    @Autowired
    private IVideoService videoService;

    /**
     * 查询视频管理列表
     */
//    @PreAuthorize("@ss.hasPermi('iqiyi:video:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseVideo baseVideo)
    {
        startPage();
        List<BaseVideo> list = videoService.selectVideoList(baseVideo);
        return getDataTable(list);
    }

    /**
     * 导出视频管理列表
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:video:export')")
    @Log(title = "视频管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseVideo baseVideo)
    {
        List<BaseVideo> list = videoService.selectVideoList(baseVideo);
        ExcelUtil<BaseVideo> util = new ExcelUtil<BaseVideo>(BaseVideo.class);
        util.exportExcel(response, list, "视频管理数据");
    }

    /**
     * 获取视频管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:video:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(videoService.selectVideoById(id));
    }

    /**
     * 新增视频管理
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:video:add')")
    @Log(title = "视频管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseVideo baseVideo)
    {
        return toAjax(videoService.insertVideo(baseVideo));
    }

    /**
     * 修改视频管理
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:video:edit')")
    @Log(title = "视频管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseVideo baseVideo)
    {
        return toAjax(videoService.updateVideo(baseVideo));
    }

    /**
     * 删除视频管理
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:video:remove')")
    @Log(title = "视频管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(videoService.deleteVideoByIds(ids));
    }
}
