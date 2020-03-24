package com.sunpeifu.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 作者:  daike
 * 日期:  2020/3/14
 * 描述:
 */

public class Product {

    private BigDecimal productPrice;

    private String productName;

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productPrice=" + productPrice +
                ", productName='" + productName + '\'' +
                '}';
    }
}
