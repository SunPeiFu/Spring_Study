package com.sunpeifu.demo.data_structure.reflect;

import com.google.common.collect.Maps;
import com.sunpeifu.demo.bean.Item;
import com.sunpeifu.demo.bean.Product;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/25
 * 描述:  BeanCopy的原理
 */
public class BeanCopyTest {

    public static void main(String[] args) throws Exception {
        Product product = new Product();
        product.setProductName("商品A");
        product.setIsDeleted(true);
        product.setProductPrice(new BigDecimal(10));
        Item item = beanCopy(product, Item.class);
        System.out.println(item);

    }


    /***
     *  BeanUtils copy的原理
     */
    public static <T> T beanCopy(Object source, Class<T> target) throws Exception {

        T t = target.newInstance();
        // 存储source信息 k 为字段名  v为字段对应的属性值
        Map<String ,Object> sourceValues = Maps.newHashMap();
        Field[] declaredFields = source.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            // 字段属性名
            String name = declaredField.getName();
            // 字段属性对应的值
            Object sourceValue = declaredField.get(source);
            sourceValues.put(name,sourceValue);
        }
        // 获取target的所有字段
        Field[] declaredFields1 = target.getDeclaredFields();
        for (Field field : declaredFields1) {
            // 设置访问权限
            field.setAccessible(true);
            field.set(t,sourceValues.get(field.getName()));
        }

        return t;
    }

}
