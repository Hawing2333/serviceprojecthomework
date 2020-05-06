package edu.neu.springcloud.provider.controller;

import edu.neu.springcloud.provider.bean.Customers;
import edu.neu.springcloud.provider.service.CustomersService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomersController {
    @Resource
    CustomersService customersService;

    @RequestMapping("/findAll")
    public List<Customers> findAll(){
        return customersService.findAll();
    }

    @RequestMapping("/find/{id}")
    public Customers findById(@PathVariable int id){
        Customers customers = customersService.findById(id);
        customers.setIdentification("providerIV");
        return customers;
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete/{id}")
    public String deleteCustomers(@PathVariable int id){
        customersService.deleteCustomers(id);
        return "该用户已删除";
    }

    /**
     * 添加用户
     */
    @RequestMapping("/add/{id}/{name}/{sex}/{address}/{mobile}")
    public String addCustomers(@PathVariable int id,@PathVariable String name,@PathVariable String sex,
                               @PathVariable String address,@PathVariable String mobile){
        customersService.addCustomers(id, name, sex, address, mobile);
        return "顾客已添加";
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update/{id}/{name}/{sex}/{address}/{mobile}")
    public String updateCustomers(@PathVariable int id,@PathVariable String name,@PathVariable String sex,
                                  @PathVariable String address,@PathVariable String mobile){
        customersService.updateCustomers(id, name, sex, address, mobile);
        return "顾客已修改";
    }






}
