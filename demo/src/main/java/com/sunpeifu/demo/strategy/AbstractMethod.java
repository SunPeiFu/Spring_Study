package com.sunpeifu.demo.strategy;

/**
 * @Date 2019/12/31 5:16 下午
 * @Author sunpeifu
 * @description
 */
public abstract class AbstractMethod {
    // 定义抽象功能,不同保险公司/医院  实现自己的功能

    // 身份确认
    abstract void userConfirm();
    // 申请
    abstract void apply();
    // 支付
    abstract void pay();

}
