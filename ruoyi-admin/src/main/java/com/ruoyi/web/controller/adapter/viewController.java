package com.ruoyi.web.controller.adapter;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iqiyi/video")
public class viewController {
    @GetMapping("/view")
    public AjaxResult view(Long userId, @Nullable Long videoId, @Nullable String url) {
        viewImpl view = new viewImpl();
        if (url != null) {
            view.request(userId, url, "url");
            return AjaxResult.success();
        } else if (videoId != null) {
            view.request(userId, videoId.toString(), "id");
            return AjaxResult.success();
        } else {
            return AjaxResult.error();
        }
    }
}
