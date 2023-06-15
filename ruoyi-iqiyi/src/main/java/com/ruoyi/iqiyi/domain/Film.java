package com.ruoyi.iqiyi.domain;

import com.ruoyi.common.utils.bean.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Film extends BaseVideo{

    /**
     * 存放一部电影的专有属性
     * @return
     */

    public String lengthTime;
//无参的构造方法
    public Film() {
    }
    //有参的构造方法
    public Film(BaseVideo baseVideo) {
        BeanUtils.copyBeanProp(this,baseVideo);
    }
//重写父类方法
    @Override
    public String getType() {
        return "电影";
    }
}
