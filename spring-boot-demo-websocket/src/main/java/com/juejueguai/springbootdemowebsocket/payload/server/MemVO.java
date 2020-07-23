package com.juejueguai.springbootdemowebsocket.payload.server;

import com.juejueguai.springbootdemowebsocket.model.server.Mem;
import com.juejueguai.springbootdemowebsocket.payload.KV;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @description:  內存相关信息实体VO
 * @author: juejueguai
 * @date: 2020/7/22 11:28
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Data
public class MemVO {
    List<KV> data = Lists.newArrayList();

    public static MemVO create(Mem mem) {
        MemVO vo = new MemVO();
        vo.data.add(new KV("内存总量", mem.getTotal() + "G"));
        vo.data.add(new KV("已用内存", mem.getUsed() + "G"));
        vo.data.add(new KV("剩余内存", mem.getFree() + "G"));
        vo.data.add(new KV("使用率", mem.getUsage() + "%"));
        return vo;
    }
}