package com.sunpeifu.demo.lambda;

import com.sunpeifu.demo.bean.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 作者:  daike
 * 日期:  2020/3/14
 * 描述:
 */
public class LambdaMain {
    public static void main(String[] args) {
        // 对一个集合进行排序,按照加个降序,当价格一样的时候,按照名字排序
        List<Product> list = new ArrayList<>();
        List<Product> collect = list.stream().sorted(Comparator
                .comparing(Product::getProductPrice)
                // Comparing是默认升序的,所以reversed倒转过来即为降序了
                .reversed()
                // 之后如果价格相同,则比较名称,按照名称升序排序
                .thenComparing(Product::getProductName)).collect(Collectors.toList());


    }
}
