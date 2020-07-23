package com.juejueguai.springbootdemowebsocket.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import com.juejueguai.springbootdemowebsocket.common.WebSocketConstant;
import com.juejueguai.springbootdemowebsocket.model.Server;
import com.juejueguai.springbootdemowebsocket.payload.ServerVO;
import com.juejueguai.springbootdemowebsocket.util.ServerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:  服务器定时推送任务
 * @author: juejueguai
 * @date: 2020/7/23 11:49
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Slf4j
@Component
public class ServerTask {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 按照标准时间来算，每隔 2s 执行一次
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void websocket() throws Exception {
        log.info("【推送消息】开始执行：{}", DateUtil.formatDateTime(new Date()));
        // 查询服务器状态
        Server server = new Server();
        server.copyTo();
        ServerVO serverVO = ServerUtil.wrapServerVO(server);
        Dict dict = ServerUtil.wrapServerDict(serverVO);
        simpMessagingTemplate.convertAndSend(WebSocketConstant.PUSH_SERVER, JSONUtil.toJsonStr(dict));
        log.info("【推送消息】执行结束：{}", DateUtil.formatDateTime(new Date()));
    }
}
