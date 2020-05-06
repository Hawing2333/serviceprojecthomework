package edu.neu.springcloud.provider.service;

import edu.neu.springcloud.provider.bean.Customers;

import java.util.List;

public interface CustomersService {
    public List<Customers> findAll();
    public Customers findById(int id);


    public void deleteCustomers(int id);
    public void addCustomers(int id,String name,String sex,String address,String mobile);
    public void updateCustomers(int id,String name,String sex,String address,String mobile);
}
