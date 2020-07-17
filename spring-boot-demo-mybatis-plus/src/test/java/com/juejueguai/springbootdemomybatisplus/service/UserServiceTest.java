package com.juejueguai.springbootdemomybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juejueguai.springbootdemomybatisplus.SpringBootDemoMybatisPlusApplicationTests;
import com.juejueguai.springbootdemomybatisplus.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: SpringBootDemo
 * @author: juejueguai
 * @date: 2020/7/17 14:37
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Slf4j
public class UserServiceTest extends SpringBootDemoMybatisPlusApplicationTests {
    @Autowired
    private UserService userService;

    /**
     * 测试Mybatis-Plus 新增
     */
    @Test
    public void testSave() {
        String salt = "456";
        User testSave3 = User.builder().name("testSave").password("123456" + salt).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new Date()).build();
        boolean save = userService.save(testSave3);
        Assert.assertTrue(save);
        log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());
    }

    /**
     * 测试Mybatis-Plus 批量新增
     */
    @Test
    public void testSaveList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 14; i < 20; i++) {
            String salt = "456";
            User user = User.builder().name("testSave" + i).password("123456" + salt).salt(salt).email("testSave" + i + "@xkcoding.com").phoneNumber("1730000000" + i).status(1).lastLoginTime(new Date()).build();
            userList.add(user);
        }
        boolean batch = userService.saveBatch(userList);
        Assert.assertTrue(batch);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("【userList#ids】= {}", ids);
    }

    /**
     * 测试Mybatis-Plus 删除
     */
    @Test
    public void testDelete() {
        boolean remove = userService.removeById(1L);
        User byId = userService.getById(1L);
        Assert.assertNull(byId);
    }

    /**
     * 测试Mybatis-Plus 修改
     */
    @Test
    public void testUpdate() {
        User user = userService.getById(3L);
        user.setName("MybatisPlus修改名字");
        boolean b = userService.updateById(user);
        Assert.assertTrue(b);
        User update = userService.getById(3L);
        Assert.assertEquals("MybatisPlus修改名字", update.getName());
        log.debug("【update】= {}", update);
    }

    /**
     * 测试Mybatis-Plus 查询单个
     */
    @Test
    public void testQueryOne() {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(false, User :: getId, 3L).orderByDesc(User::getId).last("limit 1"));
        Assert.assertNotNull(user);
        log.debug("【user】= {}", user);
    }

    /**
     * 测试Mybatis-Plus 查询全部
     */
    @Test
    public void testQueryAll() {
        List<User> list = userService.list(new QueryWrapper<>());
        Assert.assertTrue(!CollectionUtils.isEmpty(list));
        log.debug("【list】= {}", list);
    }

    /**
     * 测试Mybatis-Plus 分页排序查询
     */
    @Test
    public void testQueryByPageAndSort() {
        initData();
        int count = userService.count(new QueryWrapper<>());
        Page<User> userPage = new Page<>(1, 5);
        userPage.setDesc("id");
        IPage<User> page = userService.page(userPage, new QueryWrapper<>());
        Assert.assertEquals(5, page.getSize());
        Assert.assertEquals(count, page.getTotal());
        log.debug("【page.getRecords()】= {}", page.getRecords());
    }

    /**
     * 测试Mybatis-Plus 自定义查询
     */
    @Test
    public void testQueryByCondition() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "Save1").or().eq("phone_number", "17300000001").orderByDesc("id");

        userService.getOne(wrapper);
        int count = userService.count(wrapper);
        Page<User> userPage = new Page<>(1, 3);
        IPage<User> page = userService.page(userPage, wrapper);
        Assert.assertEquals(3, page.getSize());
        Assert.assertEquals(count, page.getTotal());
        log.debug("【page.getRecords()】= {}", page.getRecords());
    }

    /**
     * 初始化数据
     */
    private void initData() {
        testSaveList();
    }

}
