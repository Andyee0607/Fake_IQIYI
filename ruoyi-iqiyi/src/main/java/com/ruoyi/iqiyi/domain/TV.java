package com.ruoyi.iqiyi.domain;

import com.ruoyi.common.utils.bean.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TV extends BaseVideo{

    //每集的url，length即为总集数
    public String[] urlList;

    @Override
    public String getType() {
        return "电视剧";
    }

    public TV() {
    }

    public TV(BaseVideo baseVideo) {
        BeanUtils.copyBeanProp(this,baseVideo);
    }
}
