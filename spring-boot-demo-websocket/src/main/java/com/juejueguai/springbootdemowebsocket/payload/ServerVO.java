package com.juejueguai.springbootdemowebsocket.payload;

import com.google.common.collect.Lists;
import com.juejueguai.springbootdemowebsocket.model.Server;
import com.juejueguai.springbootdemowebsocket.payload.server.*;
import lombok.Data;

import java.util.List;

/**
 * @description:  服务器信息VO
 * @author: juejueguai
 * @date: 2020/7/23 11:49
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Data
public class ServerVO {
    List<CpuVO> cpu = Lists.newArrayList();
    List<JvmVO> jvm = Lists.newArrayList();
    List<MemVO> mem = Lists.newArrayList();
    List<SysFileVO> sysFile = Lists.newArrayList();
    List<SysVO> sys = Lists.newArrayList();

    public ServerVO create(Server server) {
        cpu.add(CpuVO.create(server.getCpu()));
        jvm.add(JvmVO.create(server.getJvm()));
        mem.add(MemVO.create(server.getMem()));
        sysFile.add(SysFileVO.create(server.getSysFiles()));
        sys.add(SysVO.create(server.getSys()));
        return null;
    }
}
