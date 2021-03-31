package com.juejueguai.balance.hash;

import com.juejueguai.balance.random.IpServerConstant;

import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @description: hash环
 * @author: juejueguai
 * @date: 2021/3/31 14:01
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class ConsistentHash {

    private static TreeMap<Integer, String> TREE_MAP = new TreeMap<>();
    private static final Integer SIZE = 160;
    private static final String VN = "VN";

    static {
        for (String ip : IpServerConstant.LIST) {
            for (int i = 0; i < SIZE; i++) {
                final int hash = hash(ip + VN + i);
                TREE_MAP.put(hash, ip);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer("clientInfo" + VN));
        }
    }

    /**
     * 获取字符串的hash值
     *
     * @param key
     * @return
     */
    static final int hash(String key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static String getServer(String clientInfo) {
        final int hash = hash(clientInfo);
        final SortedMap<Integer, String> sortedMap = TREE_MAP.tailMap(hash);
        if (Objects.isNull(sortedMap)) {
            return TREE_MAP.get(TREE_MAP.firstKey());
        }
        return TREE_MAP.get(sortedMap.firstKey());
    }


}
