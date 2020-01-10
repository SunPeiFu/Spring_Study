package com.sunpeifu.demo.strategy;


/**
 * @Date 2019/12/30 9:06 下午
 * @Author daike
 * @description
 */
public class BeijingStrategy extends AbstractMethod implements Strategy {
    @Override
    public void execute() {
        System.out.println("Beijing execute .......");
    }

    @Override
    void userConfirm() {

    }

    @Override
    void apply() {

    }

    @Override
    void pay() {

    }
}
