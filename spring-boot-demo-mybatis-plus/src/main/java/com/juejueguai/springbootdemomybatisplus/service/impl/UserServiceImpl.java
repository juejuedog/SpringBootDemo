package com.juejueguai.springbootdemomybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juejueguai.springbootdemomybatisplus.entity.User;
import com.juejueguai.springbootdemomybatisplus.mapper.UserMapper;
import com.juejueguai.springbootdemomybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User Service
 * </p>
 *
 * @description: UserServiceImpl
 * @author: juejueguai
 * @date: Created in 2018/11/8 18:10
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
