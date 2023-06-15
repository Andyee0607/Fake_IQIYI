package com.ruoyi.iqiyi.mapper;

import com.ruoyi.iqiyi.domain.CustomerService;

import java.util.List;

/**
 * 在线问题管理Mapper接口
 *
 */
public interface CustomerServiceMapper 
{
    /**
     * 查询在线问题管理
     * 
     * @param id 在线问题管理主键
     * @return 在线问题管理
     */
    public CustomerService selectCustomerServiceById(Long id);

    /**
     * 查询在线问题管理列表
     * 
     * @param customerService 在线问题管理
     * @return 在线问题管理集合
     */
    public List<CustomerService> selectCustomerServiceList(CustomerService customerService);

    /**
     * 新增在线问题管理
     * 
     * @param customerService 在线问题管理
     * @return 结果
     */
    public int insertCustomerService(CustomerService customerService);

    /**
     * 修改在线问题管理
     * 
     * @param customerService 在线问题管理
     * @return 结果
     */
    public int updateCustomerService(CustomerService customerService);

    /**
     * 删除在线问题管理
     * 
     * @param id 在线问题管理主键
     * @return 结果
     */
    public int deleteCustomerServiceById(Long id);

    /**
     * 批量删除在线问题管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCustomerServiceByIds(Long[] ids);
}
