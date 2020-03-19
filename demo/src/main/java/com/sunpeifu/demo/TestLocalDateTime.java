package com.sunpeifu.demo;

import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 作者:  daike
 * 日期:  2020/3/16
 * 描述:
 */
public class TestLocalDateTime {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList();
        IntStream.range(1, 3).forEach(e->{
        });
//
//        System.out.println("================");
//        IntStream.range(0, 3).mapToObj(i -> "x").forEach(System.out::println);
//        System.out.println("================");
//
//        IntStream.rangeClosed(1, 3).forEach(System.out::println);
//        System.out.println("================");
//
//        DoubleStream.of(1.1, 2.2, 3.3).forEach(System.out::println);

        System.out.println(IntStream.of(1, 2).boxed().toArray().getClass()); //class [Ljava.lang.Object;

        Stream.of(1,4,6,7).filter(Objects::nonNull);


    }
}
