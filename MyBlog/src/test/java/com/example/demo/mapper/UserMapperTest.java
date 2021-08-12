package com.example.demo.mapper;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@Transactional //保持正常执行并不会执行到数据库中
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    void addUser() {
        User user = new User();
        user.setUsername("沙僧");
        user.setPassword("挑担");
        user.setPhoto("aaa.png");
        //返回修改的行数
        int result = userMapper.addUser(user);
        System.out.println(result);
    }

    @Test
    void getUserById() {
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    /*@Test
    void getUserByNameAndPassword() {
        User user = userMapper.getUserByNameAndPassword("八戒","回家吧");
        System.out.println(user);
    }*/

    @Test
    void getAll() {
        List<User> list = userMapper.getAll();
        list.forEach(System.out::println);
    }
    @Test
    void deleteById() {
        int result = userMapper.deleteById(1);
        System.out.println(result);
    }

    @Test
    void upUser() {
       int result = userMapper.upUser(5,"唐僧呀");
        System.out.println(result);
    }

    @Test
    void getList() {
        List<User> list = userMapper.getList("desc");
        list.forEach(System.out::println);
    }

    @Test
    void getListByName() {
        List<User> list = userMapper.getListByName("唐");
        list.forEach(System.out::println);
    }

    @Test
    void getListByName2() {
        String username = "唐";
        List<User> list = userMapper.getListByName2(username);
        list.forEach(System.out::println);
    }


    @Test
    void getFullUser() {
        User user = userMapper.getFullUser(2);
        System.out.println(user);
    }
}