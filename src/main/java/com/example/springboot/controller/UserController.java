package com.example.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyt
 * @since 2022-10-17
 */
@RestController
@RequestMapping("/user")
        public class UserController {
    

        @Resource
        private IUserService userService;

        // 新增或者更新
        @PostMapping
        public boolean save(@RequestBody User user){
                return userService.saveOrUpdate(user);
                }
        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id){
                return userService.removeById(id);
                }
        //批量删除
        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids){
                return userService.removeByIds(ids);
                }
        //查询所有
        @GetMapping
        public List<User> findAll(){
                return userService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
        public User findOne(@PathVariable Integer id){
                return userService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
        public Page<User> findPage(
                @RequestParam Integer pageNum,
                @RequestParam Integer pageSize,
                @RequestParam(defaultValue = "") String username,
                @RequestParam(defaultValue = "") String email,
                @RequestParam(defaultValue = "") String address){
                QueryWrapper<User> queryWrapper=new QueryWrapper<>();
                queryWrapper.orderByDesc("id");
                if (!"".equals(username)) {
                        queryWrapper.like("username", username);
                }
                if (!"".equals(email)) {
                        queryWrapper.like("email", email);
                }
                if (!"".equals(address)) {
                        queryWrapper.like("address", address);
                }
                return userService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }

                }

