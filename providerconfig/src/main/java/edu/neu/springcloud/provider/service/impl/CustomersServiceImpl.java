package edu.neu.springcloud.provider.service.impl;

import edu.neu.springcloud.provider.bean.Customers;
import edu.neu.springcloud.provider.bean.CustomersExample;
import edu.neu.springcloud.provider.repository.CustomersMapper;
import edu.neu.springcloud.provider.service.CustomersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Resource
    CustomersMapper customersMapper;
    public List<Customers> findAll() {
        CustomersExample customersExample = new CustomersExample();
        return customersMapper.selectByExample(customersExample);
    }

    @Override
    public Customers findById(int id) {
        CustomersExample customersExample = new CustomersExample();
        CustomersExample.Criteria criteria = customersExample.createCriteria();
        criteria.andIdEqualTo(id);
        return customersMapper.selectByExample(customersExample).get(0);
    }

    @Override
    public void deleteCustomers(int id){
        customersMapper.deleteCustomers(id);
    }

    @Override
    public void addCustomers(int id,String name,String sex,String address,String mobile){
        customersMapper.addCustomers(id,name,sex,address,mobile);
    }

    @Override
    public void updateCustomers(int id,String name,String sex,String address,String mobile){
        customersMapper.updateCustomers(id, name, sex, address, mobile);
    }




}
