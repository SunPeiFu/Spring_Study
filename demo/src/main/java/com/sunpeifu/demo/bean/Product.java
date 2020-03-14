package com.sunpeifu.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 作者:  daike
 * 日期:  2020/3/14
 * 描述:
 */
@Data
public class Product {

    private BigDecimal productPrice;

    private String productName;
}
