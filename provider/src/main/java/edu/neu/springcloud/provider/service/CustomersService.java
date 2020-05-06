package edu.neu.springcloud.provider.service;

import edu.neu.springcloud.provider.bean.Customers;

import java.util.List;

public interface CustomersService {
    public List<Customers> findAll();
    public Customers findById(int id);
}
