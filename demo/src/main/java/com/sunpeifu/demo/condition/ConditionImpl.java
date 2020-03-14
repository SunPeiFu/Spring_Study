package com.sunpeifu.demo.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 根据条件厨师话duiyingbean,需要实现condition接口
 */
public class ConditionImpl implements Condition {

    /**
     * 方法返回true,则会初始化对应含有@Conditon注解的bean,反之不会
    */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        if (environment.containsProperty("dev")){
            return true;
        }
        return false;
    }
}
