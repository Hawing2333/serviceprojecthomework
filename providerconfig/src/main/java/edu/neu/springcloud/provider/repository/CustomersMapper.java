package edu.neu.springcloud.provider.repository;


import edu.neu.springcloud.provider.bean.Customers;
import edu.neu.springcloud.provider.bean.CustomersExample;
import org.apache.ibatis.annotations.*;

import java.security.SecureRandom;
import java.util.List;

@Mapper
public interface CustomersMapper {
    //extra

    //delete
    public void deleteCustomers(int id);

    //add
    public void addCustomers(int id, String name,String sex,String address,String mobile);

    //update
    public void updateCustomers(int id, String name,String sex,String address,String mobile);





    int countByExample(CustomersExample example);

    int deleteByExample(CustomersExample example);

    @Delete({
        "delete from customers",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customers (ID, Name, ",
        "Sex, Address, Mobile)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Customers record);

    int insertSelective(Customers record);

    List<Customers> selectByExample(CustomersExample example);

    @Select({
        "select",
        "ID, Name, Sex, Address, Mobile",
        "from customers",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Customers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customers record, @Param("example") CustomersExample example);

    int updateByExample(@Param("record") Customers record, @Param("example") CustomersExample example);

    int updateByPrimaryKeySelective(Customers record);

    @Update({
        "update customers",
        "set Name = #{name,jdbcType=VARCHAR},",
          "Sex = #{sex,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "Mobile = #{mobile,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customers record);
}