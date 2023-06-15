package com.ruoyi.iqiyi.domain;

public enum VideoFactory {

    //确保工厂只有一个  避免出现多次创建、多次销毁对象的问题，提高网站性能和稳定性。
    INSTANCE;
    /**
     * 简单工厂模式创建对象
     * @return
     */
    public  TV createTV(BaseVideo baseVideo) {
        return new TV(baseVideo);
    }

    public  Film createFilm(BaseVideo baseVideo) {
        return new Film(baseVideo);
    }

    public  VarietyShow createVarietyShow(BaseVideo baseVideo) {
        return new VarietyShow(baseVideo);
    }
}
