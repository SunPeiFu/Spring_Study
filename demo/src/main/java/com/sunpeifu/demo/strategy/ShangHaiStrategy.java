package com.sunpeifu.demo.strategy;

/**
 * @Date 2020/1/2 11:17 上午
 * @Author daike
 * @description
 */
public class ShangHaiStrategy extends AbstractMethod implements Strategy {
    @Override
    void userConfirm() {

    }

    @Override
    void apply() {

    }

    @Override
    void pay() {

    }

    @Override
    public void execute() {
        System.out.println(" this is Shang Hai execute.........");
    }
}
