package com.bingye;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bingye.domain.po.User;
import com.bingye.persistence.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTest {

    @Resource
    public UserMapper userMapper;

    @Test
    void selectList() {
       List<User> users =  userMapper.selectList(null);
       users.forEach(item -> {
           System.out.println(item);
       });
    }

    @Test
    void selectPage(){
        Page<User> userPage = new Page<>(1,5);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //设置只返回某个值
        userQueryWrapper.select("user_name","id");
        userPage = this.userMapper.selectPage(userPage, userQueryWrapper);
        System.out.println(JSONObject.toJSON(userPage));
    }

    @Test
    void insert(){
        User user = new User();
        user.setUserName("叶兵");
        //user.setId(3);
        int num = userMapper.insert(user);
        System.out.println(num);
        System.out.println(user);
    }

    @Test
    void update(){
        User user = new User();
        user.setUserName("张三");
        user.setId(1l);
        int num = userMapper.updateById(user);
        System.out.println(num);
    }

    @Test
    void updateByQueryWrapper(){
        User user = new User();
        user.setUserName("叶兵");
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("user_name","张三");
        int num = userMapper.update(user,queryWrapper);
        System.out.println(num);
    }

    @Test
    void updateByUpdateWrapper(){
        User user = new User();
        user.setUserName("叶兵");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.set("user_name","刘二").set("password","123456").eq("id","1");
        int num = userMapper.update(user,updateWrapper);
        System.out.println(num);
    }

    @Test
    void delete(){
        //方法一
        //HashMap<String, Object> map = new HashMap<>();
        //map.put("user_name","叶兵");
        //int num = userMapper.deleteByMap(map);

        //方法二
        //QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        //objectQueryWrapper.eq("user_name","叶兵");

        //方法三
        User user = new User();
        user.setUserName("叶兵");
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>(user);
        int num = userMapper.delete(objectQueryWrapper);
        System.out.println(num);
    }

    @Test
    void findById(){
        User user = userMapper.findById(1l);
        System.out.println(user);
    }

}