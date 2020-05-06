package edu.neu.springcloud.breaker.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.neu.springcloud.breaker.bean.Customers;
import edu.neu.springcloud.breaker.service.CustomersService;
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

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/find/{id}")
    public Customers findById(@PathVariable int id) throws Exception{
        Customers customers = customersService.findById(id);
        if (customers == null){
            throw new Exception();
        }
        customers.setIdentification("providerbreaker");
        return customers;
    }

    public Customers fallback(@PathVariable("id") int id){
        Customers customers = new Customers();
        customers.setId(id);
        customers.setDescription("The customer id"+id+"is not found");
        customers.setName("No this data in the database");
        return customers;
    }

}
