package edu.neu.springcloud.feign.service;


import edu.neu.springcloud.feign.bean.Customers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
@FeignClient("provider")
public interface CustomersService {

    @RequestMapping("/customers/findAll")
    List<Customers> findAll();

    @RequestMapping("customers/find/{id}")
    Customers findById(@PathVariable int id);
}
