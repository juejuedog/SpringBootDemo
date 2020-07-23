package com.juejueguai.springbootdemowebsocket.payload.server;

import com.juejueguai.springbootdemowebsocket.model.server.Sys;
import com.juejueguai.springbootdemowebsocket.payload.KV;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @description:  系统相关信息实体VO
 * @author: juejueguai
 * @date: 2020/7/22 11:28
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Data
public class SysVO {
    List<KV> data = Lists.newArrayList();

    public static SysVO create(Sys sys) {
        SysVO vo = new SysVO();
        vo.data.add(new KV("服务器名称", sys.getComputerName()));
        vo.data.add(new KV("服务器Ip", sys.getComputerIp()));
        vo.data.add(new KV("项目路径", sys.getUserDir()));
        vo.data.add(new KV("操作系统", sys.getOsName()));
        vo.data.add(new KV("系统架构", sys.getOsArch()));
        return vo;
    }
}