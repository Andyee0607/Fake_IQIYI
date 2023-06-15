package com.ruoyi.iqiyi.mapper;

import com.ruoyi.iqiyi.domain.BaseVideo;

import java.util.List;

/**
 * 视频管理Mapper接口
 *
 */
public interface VideoMapper 
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

    /**
     * 修改视频管理
     * 
     * @param baseVideo 视频管理
     * @return 结果
     */
    public int updateVideo(BaseVideo baseVideo);

    /**
     * 删除视频管理
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    public int deleteVideoById(Long id);

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVideoByIds(Long[] ids);
}
