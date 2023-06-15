package com.ruoyi.web.controller.adapter;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;

public class viewImpl implements view {
    ViewAdapter viewAdapter;
    /**
     * 基于用户账号的观看历史记录
     * @param userId
     * @param data
     * @param type
     */
    @Override
    public void request(Long userId, String data, String type) {
        if (type.equals("url")) {
            ISysUserService userService = new SysUserServiceImpl();
            SysUser user = userService.selectUserById(userId);
            user.setWatchHistory(user.getWatchHistory().concat("," + data));
            userService.updateUser(user);
        } else {
            viewAdapter.request(userId, data, type);
        }

    }
}
