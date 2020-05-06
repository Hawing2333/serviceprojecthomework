package edu.neu.springcloud.feign.controller;


import edu.neu.springcloud.feign.bean.Customers;
import edu.neu.springcloud.feign.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @RequestMapping("/consumerfeign/findAll")
    public List<Customers> findAll(){
        return customersService.findAll();
    }

    @RequestMapping("/consumerfeign/find/{id}")
    public Customers findById(@PathVariable int id){
        return customersService.findById(id);
    }

}
