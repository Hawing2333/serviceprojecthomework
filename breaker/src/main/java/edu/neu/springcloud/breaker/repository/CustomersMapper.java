package edu.neu.springcloud.breaker.repository;

import edu.neu.springcloud.breaker.bean.Customers;
import edu.neu.springcloud.breaker.bean.CustomersExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomersMapper {
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