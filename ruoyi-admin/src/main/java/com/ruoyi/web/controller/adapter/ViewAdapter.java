package com.ruoyi.web.controller.adapter;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.iqiyi.domain.BaseVideo;
import com.ruoyi.iqiyi.service.IVideoService;
import com.ruoyi.iqiyi.service.impl.VideoServiceImpl;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
/**
 * 适配器模式
 */
public class ViewAdapter implements view {
    /**
     * 需要作进一步的处理
     * @param userId
     * @param data
     * @param type
     */
    @Override
    public void request(Long userId, String data, String type) {
        if (type.equals("id")) {
            ISysUserService userService = new SysUserServiceImpl();
            SysUser user = userService.selectUserById(userId);
            IVideoService videoService = new VideoServiceImpl();
            BaseVideo baseVideo = videoService.selectVideoById(Long.parseLong(data));
            int times = baseVideo.getTimes();
            times++;
            baseVideo.setTimes(times);
            videoService.updateVideo(baseVideo);
            user.setWatchHistory(user.getWatchHistory().concat("," + baseVideo.getUrl()));
            userService.updateUser(user);
        }
    }
}
