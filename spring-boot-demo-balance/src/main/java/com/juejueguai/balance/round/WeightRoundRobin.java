package com.juejueguai.balance.round;

import com.juejueguai.balance.random.IpServerConstant;

/**
 * @description: 轮循算法
 * @author: juejueguai
 * @date: 2021/3/30 11:42
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class WeightRoundRobin {
    private static String serverIp() {

        Integer totalWeight = 0;
        for (Integer weight : IpServerConstant.WEIGHT_MAP.values()) {
            totalWeight += weight;
        }
        // 进行取余 来判定区间位置
        Integer pos = RoundContant.increasePos() % totalWeight;

        for (String ip : IpServerConstant.WEIGHT_MAP.keySet()) {
            final Integer weight = IpServerConstant.WEIGHT_MAP.get(ip);
            if (pos < weight) {
                return ip;
            }
            pos = totalWeight - weight;
        }
        return "";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(serverIp());
        }
    }
}
