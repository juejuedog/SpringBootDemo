package com.juejueguai.springbootdemomybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juejueguai.springbootdemomybatisplus.entity.User;
import org.springframework.stereotype.Component;

/**
 * <p>
 * UserMapper
 * </p>
 * @description: UserMapper
 * @author: juejueguai
 * @date: Created in 2018/11/8 16:57
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
