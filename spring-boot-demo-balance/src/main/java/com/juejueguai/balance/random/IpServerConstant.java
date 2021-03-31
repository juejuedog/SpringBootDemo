package com.juejueguai.balance.random;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 随机ip
 * @author: juejueguai
 * @date: 2021/3/29 17:07
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
public class IpServerConstant {
    public static final List<String> LIST = Arrays.asList(
            "192.168.1.22",
            "192.168.1.23",
            "192.168.1.24",
            "192.168.1.25",
            "192.168.1.26",
            "192.168.1.27",
            "192.168.1.28"
    );

    public static final Map<String, Integer> WEIGHT_MAP = new LinkedHashMap<>();

    static {
        WEIGHT_MAP.put("192.168.1.22", 5);

        WEIGHT_MAP.put("192.168.1.23", 1);

        WEIGHT_MAP.put("192.168.1.24", 1);
    }
}
