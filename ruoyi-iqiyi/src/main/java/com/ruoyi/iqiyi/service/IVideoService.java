package com.ruoyi.iqiyi.service;

import com.ruoyi.iqiyi.domain.BaseVideo;

import java.util.List;

/**
 * 视频管理Service接口
 * 
 * @author zhou
 * @date 2023-04-04
 */
public interface IVideoService 
{
    /**
     * 查询视频管理
     * 
     * @param id 视频管理主键
     * @return 视频管理
     */
    public BaseVideo selectVideoById(Long id);

    /**
     * 查询视频管理列表
     * 
     * @param baseVideo 视频管理
     * @return 视频管理集合
     */
    public List<BaseVideo> selectVideoList(BaseVideo baseVideo);

    /**
     * 新增视频管理
     * 
     * @param baseVideo 视频管理
     * @return 结果
     */
    public int insertVideo(BaseVideo baseVideo);

    int addVideo(BaseVideo baseVideo, String type);

    /**
     * 修改视频管理
     * 
     * @param baseVideo 视频管理
     * @return 结果
     */
    public int updateVideo(BaseVideo baseVideo);

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的视频管理主键集合
     * @return 结果
     */
    public int deleteVideoByIds(Long[] ids);

    /**
     * 删除视频管理信息
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    public int deleteVideoById(Long id);
}
