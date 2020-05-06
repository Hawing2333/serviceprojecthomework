package edu.neu.springcloud.testgenerator.repository;

import edu.neu.springcloud.testgenerator.bean.Customers;
import edu.neu.springcloud.testgenerator.bean.CustomersExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

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