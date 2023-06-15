package com.ruoyi.iqiyi.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 在线问题管理对象 iqiyi_customer_service
 */

public class CustomerService extends BaseEntity implements Cloneable
{
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name = "问题")
    private String question;
    @Excel(name = "回答")
    private String answer;
    private String delFlag;
    public CustomerService() {
    }

    //建造者模式,将对象的创建和表示分离，通过Builder创建对象   new CustomerService.Builder.set***.set***.build()
    private CustomerService(Builder builder){

    }

    public static class Builder{
        private String question;
        private String answer;
        private String delFlag;
        public Builder(){
        }
        public Builder setQuestion(String question){
            this.question = question;
            return this;
        }
        public Builder setAnswer(String answer){
            this.answer = answer;
            return this;
        }
        public Builder setDelFlag(String delFlag){
            this.delFlag = delFlag;
            return this;
        }
        public CustomerService build(){
            return new CustomerService(this);
        }
    }


    public Long getId()
    {
        return id;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("question", getQuestion())
                .append("answer", getAnswer())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
