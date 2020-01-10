package com.sunpeifu.demo.entrust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2020/1/3 10:06 上午
 * @Author daike
 * @description
 */
@Component("leader")
public class Leader implements  Doding {

    // 领导持有所有下属工人引用,使用Spring,则可以直接注入
    @Autowired
    private Map<String,Doding> workers = new ConcurrentHashMap<String,Doding>();

    // 如不使用Spring,需要手动put
//    public Leader(){
//        workers.put("playBall",new Worker_A());
//        workers.put("payMoney",new Worker_B());
//    }
    @Override
    public void doSomething(String taskName) {
         workers.get(taskName).doSomething(taskName);
    }
}
