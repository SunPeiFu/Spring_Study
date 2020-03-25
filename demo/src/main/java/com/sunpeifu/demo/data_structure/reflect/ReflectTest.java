package com.sunpeifu.demo.data_structure.reflect;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sunpeifu.demo.bean.Product;
import org.springframework.util.CollectionUtils;
import sun.security.krb5.internal.PAData;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 作者:  daike
 * 日期:  2020/3/24
 * 描述:
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Product p = new Product();
        Product data = createData(Product.class);
        System.out.println(data);
    }


    public static <T> T createData(Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        // 获取所有私有方法,只能获取当前类,如果想要获取父类,就用非declar的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // 设置可以访问
            declaredMethod.setAccessible(true);
            // 获取当前方法参数的数量
            int parameterCount = declaredMethod.getParameterCount();
            // 方法名称
            String methodName = declaredMethod.getName();
            // set开头的方法制造数据
            // 存储多个参数的随机值
            List<Object> list = new ArrayList<>();

            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                list.add(createDataByClassType(parameter.getType()));
                System.out.println("参数类型是:" + parameter.getType() + "方法名称是:" + methodName + "  " + "方法参数的长度是:" + parameterCount + " 参数名称:" + parameter.getName());
            }
            declaredMethod.invoke(t, checkDatat(list));

            // TODO method invoke方法,第一个参数为instance实列,第二个为可变参数 , 遇到的问题是方法有多个参数,但是传入一个Object数组,它识别成了一个参数wrong number of arguments

            declaredMethod.invoke(t, (Object[]) list.toArray());

            declaredMethod.invoke(t, list.get(0), list.get(1));


            System.out.println("大的循环中方法名称:" + declaredMethod.getName());
        }
        return t;
    }

    public static Object checkDatat(List<Object> list) {
        if (!CollectionUtils.isEmpty(list)) {
            if (list.size() == 0) {
                return list.get(0);
            } else {
                Object[] objects = list.toArray();
                return objects;
            }
        }
        return null;
    }

    public static Object createDataByClassType(Class clazz) {

        if (clazz == String.class) {
            return UUID.randomUUID().toString();
            // 如果参数类型是String,执行设置数据的方法
        } else if (clazz == Integer.class) {
            return new Random().nextInt(10);
        } else if (clazz == BigDecimal.class) {
            return new BigDecimal((int) (Math.random() * 100 + 1));
        } else if (clazz == Boolean.class) {
            return clazz.getName().hashCode() % 2 == 0 ? false : true;
        } else if (clazz == List.class) {

        }
        // 后续可以补充 参数为class对象的情况
        return null;
    }


}
