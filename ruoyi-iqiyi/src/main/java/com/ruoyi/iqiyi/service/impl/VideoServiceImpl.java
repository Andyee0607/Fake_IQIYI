package com.ruoyi.iqiyi.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.iqiyi.domain.*;
import com.ruoyi.iqiyi.mapper.VideoMapper;
import com.ruoyi.iqiyi.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视频管理Service业务层处理
 */
@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired
    private VideoMapper videoMapper;

    /**
     * 查询视频管理
     *
     * @param id 视频管理主键
     * @return 视频管理
     */
    @Override
    public BaseVideo selectVideoById(Long id) {
        return videoMapper.selectVideoById(id);
    }

    /**
     * 查询视频管理列表
     *
     * @param baseVideo 视频管理
     * @return 视频管理
     */
    @Override
    public List<BaseVideo> selectVideoList(BaseVideo baseVideo) {
        return videoMapper.selectVideoList(baseVideo);
    }



    /**
     * 新增视频管理
     *
     * @param baseVideo 视频管理
     * @return 结果
     */
    @Override
    public int addVideo(BaseVideo baseVideo, String type) {
        VideoFactory videoFactory = VideoFactory.INSTANCE;
        switch (type) {
            case "0":{
                TV tv = videoFactory.createTV(baseVideo);
                tv.setCreateTime(DateUtils.getNowDate());
                //可以做进一步操作 Todo
                return videoMapper.insertVideo(tv);
            }
            case "1":{
                Film film = videoFactory.createFilm(baseVideo);
                film.setCreateTime(DateUtils.getNowDate());
                //可以做进一步操作 Todo
                return videoMapper.insertVideo(film);
            }
            case "2":{
                VarietyShow varietyShow = videoFactory.createVarietyShow(baseVideo);
                varietyShow.setCreateTime(DateUtils.getNowDate());
                //可以做进一步操作 Todo
                return videoMapper.insertVideo(varietyShow);
            }
        }
        return 0;
    }

    /**
     * 修改视频管理
     *
     * @param baseVideo 视频管理
     * @return 结果
     */
    @Override
    public int updateVideo(BaseVideo baseVideo) {
        baseVideo.setUpdateTime(DateUtils.getNowDate());
        return videoMapper.updateVideo(baseVideo);
    }

    /**
     * 批量删除视频管理
     *
     * @param ids 需要删除的视频管理主键
     * @return 结果
     */
    @Override
    public int deleteVideoByIds(Long[] ids) {
        return videoMapper.deleteVideoByIds(ids);
    }

    /**
     * 删除视频管理信息
     *
     * @param id 视频管理主键
     * @return 结果
     */
    @Override
    public int deleteVideoById(Long id) {
        return videoMapper.deleteVideoById(id);
    }

    @Override
    public int insertVideo(BaseVideo baseVideo) {
        return videoMapper.insertVideo(baseVideo);
    }
}
