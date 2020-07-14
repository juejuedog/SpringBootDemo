package com.xkcoding.cache.redis.service;

import com.xkcoding.cache.redis.entity.User;

/**
 * @description: 用户实体类业务层
 * @author: juejueguai
 * @date: 2020/7/14 10:12
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public interface UserService {
    /**
     * 保存或修改用户
     *
     * @param user 用户对象
     * @return 操作结果
     */
    User saveOrUpdate(User user);

    /**
     * 获取用户
     *
     * @param id key值
     * @return 返回结果
     */
    User get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);
}
