package com.qks.makerSpace.dao;

import com.qks.makerSpace.entity.database.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDao {

    @Insert("insert into user (user_id, name, password, email, user_describe) " +
            "values (#{userId}, #{name}, #{password}, #{email}, #{userDescribe})")
    Integer addNewUser(User user);

    @Select("select * from user where name = #{name}")
    User getUserByName(String name);

    @Insert("insert into user_company(user_id) values (#{id})")
    Integer updateUserCompany(String id);
}
