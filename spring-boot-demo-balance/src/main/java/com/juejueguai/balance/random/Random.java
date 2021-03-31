package com.juejueguai.balance.random;

/**
 * @description: SpringBootDemo
 * @author: juejueguai
 * @date: 2021/3/29 17:07
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class Random {

    private static String serverIp() {
        java.util.Random random = new java.util.Random();
        final int newInt = random.nextInt(IpServerConstant.LIST.size());
        return IpServerConstant.LIST.get(newInt);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(serverIp());
        }
    }
}
