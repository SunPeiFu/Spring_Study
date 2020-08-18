package com.sunpeifu.template.java8;

/**
 * 作者:  daike
 * 日期:  2020/7/22
 * 描述:
 */

public class Apple {

    public Apple(Integer weight) {
        this.weight = weight;
    }

    private Integer weight;


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
