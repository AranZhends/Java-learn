package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //添加用户方法
    public int addUser(User user);

    public User getUserById(int id);

    public User getUserByNameAndPassword(String username,String password);

    public List<User> getAll();

    public int deleteById(int id);

    public int upUser(int id,String username);

    public List<User> getList(String ord);

    public List<User> getListByName(String username);

    public List<User> getListByName2(String username);

    public User getFullUser(int id);

}
