package com.sunpeifu.template.java8;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sunpeifu.template.entrust.EntrustMain;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.util.comparator.ComparableComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 作者:  daike
 * 日期:  2020/7/21
 * 描述:
 */
public class TestLambda {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple(123), new Apple(null));
        list = list.stream().filter((Apple a) -> null != a.getWeight())
                .map
                .collect(Collectors.toList());
        System.out.println(list);

    }

    public static <T> List<T> fillter(List<T> list, Predicate<T> predicate) {
        return null;
    }

    public static void filter(List list, PredicateInterface p) {

    }

}
