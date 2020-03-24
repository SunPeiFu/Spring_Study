package com.sunpeifu.demo.data_structure.reflect;

import com.sunpeifu.demo.bean.Product;
import sun.security.krb5.internal.PAData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;

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
            String methodName = declaredMethod.getName();

            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                Class<?> type = parameter.getType();
                // 上面这个type解决的是方法的形式参数如果是对象,那么可以get出来clazz同样的东西,这样就解决的了所有的问题
                // 判断类型,设置数据的值
                if (type == String.class){
                    // 如果参数类型是String,执行设置数据的方法
                    declaredMethod.invoke(t,"123");
                }
                System.out.println("参数类型是:"+parameter.getType()+"方法名称是:"+methodName+"  " + "方法参数的长度是:"+parameterCount+"方法的参数名称:"+parameter.getName());
            }
            System.out.println("大的循环中方法名称:"+declaredMethod.getName());
        }

        return t;
    }

}
