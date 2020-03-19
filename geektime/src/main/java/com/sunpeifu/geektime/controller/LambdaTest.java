package com.sunpeifu.geektime.controller;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListTransducedAccessorImpl;
import com.sunpeifu.geektime.entity.Order;
import com.sunpeifu.geektime.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 作者:  daike
 * 日期:  2020/3/19
 * 描述:
 */
public class LambdaTest {

    public static void main(String[] args) {

        // 初始化两个商品
        OrderItem item = new OrderItem();
        item.setProductId(1L);
        item.setProductName("A");
        item.setProductPrice(1.1);
        item.setProductQuantity(10);

        OrderItem item2 = new OrderItem();
        item2.setProductId(2L);
        item2.setProductName("B");
        item2.setProductPrice(2.2);
        item2.setProductQuantity(20);

        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(item);
        orderItems.add(item2);

        Order order1 = new Order();
        order1.setCustomerId(66L);
        order1.setCustomerName("客户");
        order1.setPlacedAt(LocalDateTime.now());
        order1.setOrderItemList(orderItems);
        ArrayList<Order> orderList = new ArrayList<Order>();


        //最近半年的金额大于40的订单

        // 有筛选条件,使用过滤函数filter
        List<Order> collect = orderList.stream()
                // 首先过滤空值
                .filter(Objects::nonNull)
                // 最近半年
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6)))
                // 过滤金额> 40
                .filter(order -> order.getTotalPrice() > 40)
                .collect(toList());

        // 计算所有商品的数量
        LongAdder longAdder = new LongAdder();
        orderList.stream().forEach(order -> order.getOrderItemList().forEach(orderItem -> longAdder.add(orderItem.getProductQuantity())));

        // 统计订单总金额



    }
}
