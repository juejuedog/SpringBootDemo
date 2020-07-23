package com.juejueguai.springbootdemowebsocket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 键值匹配
 * @author: juejueguai
 * @date: 2020/7/22 11:28
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KV {
    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private Object value;
}
