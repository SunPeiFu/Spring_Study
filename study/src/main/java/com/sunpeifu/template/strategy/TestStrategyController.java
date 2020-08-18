//package com.sunpeifu.template.strategy;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @Date 2020/1/2 11:27 上午
// * @Author daike
// * @description
// */
//@RestController
//public class TestStrategyController {
//
//
//    @Resource
//    private StrategyContext strategyContext;
//
//    @GetMapping("testStrategy")
//    public Object testStrategy() {
//        Strategy beijingStrategy = strategyContext.getStrategy("BeiJing");
//        beijingStrategy.execute();
//        return null;
//    }
//}
