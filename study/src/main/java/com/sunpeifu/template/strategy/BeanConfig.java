package com.sunpeifu.template.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Date 2020/1/2 11:06 上午
 * @Author sunpeifu
 * @description
 */
@Component
public class BeanConfig {
    @Bean("BeiJing")
    public BeijingStrategy beijingStrategy(){

        return new BeijingStrategy();
    }

    @Bean("ShangHai")
    public ShangHaiStrategy shangHaiStrategy(){

        return new ShangHaiStrategy();
    }
}
