package com.juejueguai.balance.round;

import lombok.Data;

/**
 * @description: SpringBootDemo
 * @author: juejueguai
 * @date: 2021/3/30 16:04
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Data
public class Weight {

    private String ip;

    private Integer weight;

    private Integer currentWeight;

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

}
