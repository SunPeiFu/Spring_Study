package com.sunpeifu.template.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2019/12/30 9:08 下午
 * @Author daike
 * @description
 */
@Component
public class StrategyContext {

    @Autowired
    private Map<String,Strategy> stringStrategyMap = new ConcurrentHashMap<>();

    // 策略容器,封装每个策略下的具体医院
    private static Map<String,Strategy> context  = new ConcurrentHashMap<>();

    // 根据类型type,返回具体策略bean
    public Strategy getStrategy(String beanName){
        Strategy strategy = stringStrategyMap.get(beanName);
        if ( null == strategy){
            System.out.println(" bean不存在");
        }
        return strategy;
    }






}
