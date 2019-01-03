package com.hjm.mapper;

import com.hjm.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RestAPIUserMapper {

    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into user values(null , #{username} , #{password})")
    boolean addUser(User user);

    @Delete("delete from user where id = #{id}")
    boolean deleteUserById(Integer id);

    @Update("update user set username = #{username} , password = #{password} where id = #{id}")
    boolean updateUserById(User user);
}
