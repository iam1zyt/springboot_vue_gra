package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public Boolean saveUser(User user) {
//        if(user.getId() == null){
//            return save(user);  //mybatis-plus提供的方法
//        }else {
//            return  updateById(user);
//        }
        return saveOrUpdate(user);
    }

//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user) {
//        if (user.getId() == null) {
//            return userMapper.insert(user);
//        } else {
//            return userMapper.update(user);
//        }
//    }
}
