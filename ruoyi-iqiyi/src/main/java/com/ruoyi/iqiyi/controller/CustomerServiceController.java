package com.ruoyi.iqiyi.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.iqiyi.domain.CustomerService;
import com.ruoyi.iqiyi.service.ICustomerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 在线问题管理Controller
 *
 */
@RestController
@RequestMapping("/iqiyi/CustomerService")
public class CustomerServiceController extends BaseController
{
    @Autowired
    private ICustomerServiceService customerServiceService;

    /**
     * 查询在线问题管理列表
     */
//    @PreAuthorize("@ss.hasPermi('iqiyi:CustomerService:list')")
    @GetMapping("/list")
    public TableDataInfo list(CustomerService customerService)
    {
        startPage();
        List<CustomerService> list = customerServiceService.selectCustomerServiceList(customerService);
        return getDataTable(list);
    }

    /**
     * 导出在线问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:CustomerService:export')")
    @Log(title = "在线问题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CustomerService customerService)
    {
        List<CustomerService> list = customerServiceService.selectCustomerServiceList(customerService);
        ExcelUtil<CustomerService> util = new ExcelUtil<CustomerService>(CustomerService.class);
        util.exportExcel(response, list, "在线问题管理数据");
    }

    /**
     * 获取在线问题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:CustomerService:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(customerServiceService.selectCustomerServiceById(id));
    }

    /**
     * 新增在线问题管理
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:CustomerService:add')")
    @Log(title = "在线问题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CustomerService customerService)
    {
        return toAjax(customerServiceService.insertCustomerService(customerService));
    }

    /**
     * 修改在线问题管理
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:CustomerService:edit')")
    @Log(title = "在线问题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CustomerService customerService)
    {
        return toAjax(customerServiceService.updateCustomerService(customerService));
    }

    /**
     * 删除在线问题管理
     */
    @PreAuthorize("@ss.hasPermi('iqiyi:CustomerService:remove')")
    @Log(title = "在线问题管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(customerServiceService.deleteCustomerServiceByIds(ids));
    }
}
