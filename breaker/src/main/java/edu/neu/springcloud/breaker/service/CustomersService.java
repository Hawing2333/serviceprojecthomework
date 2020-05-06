package edu.neu.springcloud.breaker.service;



import edu.neu.springcloud.breaker.bean.Customers;

import java.util.List;

public interface CustomersService {
    public List<Customers> findAll();
    public Customers findById(int id);
}
