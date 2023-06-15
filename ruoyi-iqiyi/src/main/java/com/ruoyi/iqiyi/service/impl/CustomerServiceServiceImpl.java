package com.ruoyi.iqiyi.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.iqiyi.domain.CustomerService;
import com.ruoyi.iqiyi.mapper.CustomerServiceMapper;
import com.ruoyi.iqiyi.service.ICustomerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 在线问题管理Service业务层处理
 */
@Service
public class CustomerServiceServiceImpl implements ICustomerServiceService
{
    @Autowired
    private CustomerServiceMapper customerServiceMapper;

    /**
     * 查询在线问题管理
     *
     * @param id 在线问题管理主键
     * @return 在线问题管理
     */
    @Override
    public CustomerService selectCustomerServiceById(Long id)
    {
        return customerServiceMapper.selectCustomerServiceById(id);
    }

    /**
     * 查询在线问题管理列表
     *
     * @param customerService 在线问题管理
     * @return 在线问题管理
     */
    @Override
    public List<CustomerService> selectCustomerServiceList(CustomerService customerService)
    {
        return customerServiceMapper.selectCustomerServiceList(customerService);
    }

    /**
     * 新增在线问题管理
     *
     * @param customerService 在线问题管理
     * @return 结果
     */
    @Override
    public int insertCustomerService(CustomerService customerService)
    {
        customerService.setCreateTime(DateUtils.getNowDate());
        return customerServiceMapper.insertCustomerService(customerService);
    }

    /**
     * 修改在线问题管理
     *
     * @param customerService 在线问题管理
     * @return 结果
     */
    @Override
    public int updateCustomerService(CustomerService customerService)
    {
        customerService.setUpdateTime(DateUtils.getNowDate());
        return customerServiceMapper.updateCustomerService(customerService);
    }

    /**
     * 批量删除在线问题管理
     *
     * @param ids 需要删除的在线问题管理主键
     * @return 结果
     */
    @Override
    public int deleteCustomerServiceByIds(Long[] ids)
    {
        return customerServiceMapper.deleteCustomerServiceByIds(ids);
    }

    /**
     * 删除在线问题管理信息
     *
     * @param id 在线问题管理主键
     * @return 结果
     */
    @Override
    public int deleteCustomerServiceById(Long id)
    {
        return customerServiceMapper.deleteCustomerServiceById(id);
    }

    /**
     * 回复问题,如果问题库中没有，则作新增
     * @param question
     * @return
     */
    @Override
    public List<String> reply(String question) {
        CustomerService customerService = new CustomerService.Builder().setQuestion(question).build();
        List<String> answerList = customerServiceMapper.selectCustomerServiceList(customerService)
                .stream()
                .map(CustomerService::getAnswer)
                .collect(Collectors.toList());
        if (answerList.isEmpty()){
            //做新增
            customerServiceMapper.insertCustomerService(customerService);
        }
        return answerList;
    }
}
