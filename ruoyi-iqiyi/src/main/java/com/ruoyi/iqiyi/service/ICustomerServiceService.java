package com.ruoyi.iqiyi.service;

import com.ruoyi.iqiyi.domain.CustomerService;

import java.util.List;

/**
 * 在线问题管理Service接口
 *
 * @author zhou
 * @date 2023-04-04
 */
public interface ICustomerServiceService {
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
     * 批量删除在线问题管理
     *
     * @param ids 需要删除的在线问题管理主键集合
     * @return 结果
     */
    public int deleteCustomerServiceByIds(Long[] ids);

    /**
     * 删除在线问题管理信息
     *
     * @param id 在线问题管理主键
     * @return 结果
     */
    public int deleteCustomerServiceById(Long id);

    public List<String> reply(String question);
}
