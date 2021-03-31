package com.juejueguai.balance.round;

import com.juejueguai.balance.random.IpServerConstant;

/**
 * @description: 轮循
 * @author: juejueguai
 * @date: 2021/3/30 10:11
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class RoundRobin {

    private static Integer pos = 0;
    private static String serverIp() {
        String ip = IpServerConstant.LIST.get(pos);
        pos ++;
        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(serverIp());
        }
    }
}
