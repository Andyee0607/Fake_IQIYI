package com.ruoyi.iqiyi.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 视频管理对象 iqiyi_video
 */
public class BaseVideo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;

    @Excel(name = "影视文件路径", readConverterExp = "本=地")
    private String url;
    private String img;
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    @Excel(name = "视频名称")
    private String name;
    private String delFlag;

    @Excel(name = "视频类型：0-电视剧 1-电影 2-综艺")
    public String type;

    public int times;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("url", getUrl())
                .append("type", getType())
                .append("name", getName())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
