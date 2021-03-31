package com.juejueguai.balance.random;

/**
 * @description: 权重
 * @author: juejueguai
 * @date: 2021/3/30 8:52
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class WeightRandom {

    private static String serverIp() {
        java.util.Random random = new java.util.Random();
        Integer totalWeight = 0;
        for (Integer weight : IpServerConstant.WEIGHT_MAP.values()) {
            totalWeight += weight;
        }
        Integer pos = random.nextInt(totalWeight);
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
