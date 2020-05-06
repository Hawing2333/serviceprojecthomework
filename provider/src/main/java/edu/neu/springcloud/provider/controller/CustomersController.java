package edu.neu.springcloud.provider.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.neu.springcloud.provider.bean.Customers;
import edu.neu.springcloud.provider.service.CustomersService;
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
        customers.setIdentification("providerI");
        return customers;
    }

}
