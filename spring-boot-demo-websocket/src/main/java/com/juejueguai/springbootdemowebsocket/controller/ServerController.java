package com.juejueguai.springbootdemowebsocket.controller;

import cn.hutool.core.lang.Dict;
import com.juejueguai.springbootdemowebsocket.model.Server;
import com.juejueguai.springbootdemowebsocket.payload.ServerVO;
import com.juejueguai.springbootdemowebsocket.util.ServerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务器监控Controller
 * @author: juejueguai
 * @date: 2020/7/23 11:43
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @GetMapping
    public Dict serverInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        ServerVO serverVO = ServerUtil.wrapServerVO(server);
        return ServerUtil.wrapServerDict(serverVO);
    }
}
