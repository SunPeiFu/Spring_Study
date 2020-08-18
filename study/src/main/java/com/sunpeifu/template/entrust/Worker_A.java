package com.sunpeifu.template.entrust;

import org.springframework.stereotype.Component;

/**
 * @Date 2020/1/2 9:01 下午
 * @Author daike
 * @description
 */
@Component("Worker_A")
public class Worker_A implements Doding{
    @Override
    public void doSomething(String taskName) {
        System.out.println("work A play Ball");
    }
}
