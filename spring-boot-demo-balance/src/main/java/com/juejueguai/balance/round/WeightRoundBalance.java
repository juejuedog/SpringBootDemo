package com.juejueguai.balance.round;

import com.juejueguai.balance.random.IpServerConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 平滑加权轮循算法
 * @author: juejueguai
 * @date: 2021/3/30 16:11
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class WeightRoundBalance {

    public static Map<String, Weight> WEIGHT_MAP = new HashMap<>(16);

    private static String serverIp() {
        // 计算总的权重数量
        Integer totalWeight = 0;
        for (Integer weight : IpServerConstant.WEIGHT_MAP.values()) {
            totalWeight += weight;
        }
        // 初始化map
        if (WEIGHT_MAP.isEmpty()) {
            IpServerConstant.WEIGHT_MAP.forEach((ip, weight) -> WEIGHT_MAP.put(ip, new Weight(ip, weight, 0)));
        }
        // 赋值currentWeight 当前权重 + 分配权重
        for (Weight weight : WEIGHT_MAP.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }
        // 赋值最大的权重
        Weight maxWeight = null;
        for (Weight weight : WEIGHT_MAP.values()) {
            if (maxWeight == null || maxWeight.getCurrentWeight() < weight.getCurrentWeight()) {
                maxWeight = weight;
            }
        }
        // 对权重进行重置 当前权重 - 全部权重
        maxWeight.setCurrentWeight(maxWeight.getCurrentWeight() - totalWeight);

        return maxWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(serverIp());
        }
    }
}
