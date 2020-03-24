package com.sunpeifu.demo.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/23
 * 描述:  快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> beforeList = new ArrayList<>();
        beforeList.add(5);
        beforeList.add(10);
        beforeList.add(1);
        beforeList.add(2);
        beforeList.add(7);
        quickSort(beforeList);
    }

    /***
     * 快速排序:
     *  1 选定基线条件,即对应的数据其中一个下标
     *  2 把数据切割,基线元素左边的都小于基线元素,右边的都大于基线条件,分成3组数据
     */

    public static List quickSort(List<Integer> list) {

        if (list.size()<2){
            System.out.println(list);
        } else {

            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();


            // 以数据趋近中间元素为极限条件
            int basicIndex = list.size() / 2;
            //
            Integer basic = list.get(basicIndex);
            // 整理数据
            list.forEach(i -> {
                if (i < basic) {
                    left.add(i);
                } else if (i > basic) {
                    right.add(i);
                }
            });

            sortList(left);
            sortList(right);

            List<Integer> result = new ArrayList<>();
            result.addAll(left);
            result.add(basic);
            result.addAll(right);
            System.out.println(result);




        }
        return null;
    }

    private static void sortList(List<Integer> list) {
        Integer[] array = (Integer[]) list.toArray();
        for (int i = 0; i < array.length-1; i++) {

            for (int j = 1; j < array.length -1 ; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }
            }

        }

    }
}
