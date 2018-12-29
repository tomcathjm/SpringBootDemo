package com.hjm.mapper;

import com.hjm.bean.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUsers();

    boolean register(User user);

    boolean delete(int id);

    User queryUserById(int id);

    boolean updateUser(User user);
}
