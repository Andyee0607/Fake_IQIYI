package com.ruoyi.iqiyi.domain;

import com.ruoyi.common.utils.bean.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class VarietyShow extends BaseVideo {
    //时长
    public String lengthTime;

    public VarietyShow() {
    }
    public VarietyShow(BaseVideo baseVideo) {
        BeanUtils.copyBeanProp(this, baseVideo);
    }

    @Override
    public String getType() {
        return "综艺";
    }
}
