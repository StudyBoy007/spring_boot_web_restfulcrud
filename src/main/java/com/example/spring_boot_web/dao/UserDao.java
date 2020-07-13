package com.example.spring_boot_web.dao;

import com.example.spring_boot_web.entities.Department;
import com.example.spring_boot_web.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Create by czq
 * time on 2020/7/6  19:10
 */
public interface UserDao {

    @Select("select * from user where id=#{id}")
    public User findUser(Integer id);




    String selectPwdByUsername(@Param("username") String username);
}
