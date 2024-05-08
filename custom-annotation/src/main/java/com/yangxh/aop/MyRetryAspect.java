package com.yangxh.aop;

import com.yangxh.config.MyRetry;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description 创建一个切面类来解析@MyRetry注解并实现重试逻辑
 * @Author yangxh8
 * @Date 2024/5/8 10:50
 */
@Aspect
@Component
public class MyRetryAspect {

    /**
     * 用于获取目标bean实例，以便调用回退方法
     */
    @Autowired
    BeanFactory beanFactory;

    @Around("@annotation(myRetry)")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp, MyRetry myRetry) throws Throwable {
        int maxRetryCount = myRetry.max_retry_count();
        Class<? extends Exception>[] exections = myRetry.forExection();
        String fallbackMethodName = myRetry.forRollback();

        for (int i = 0; i < maxRetryCount; i++) {
            try {
                pjp.proceed();
            } catch (Throwable e) {
                if (shouldRetry(e, exections) && i < maxRetryCount -1) {
                    // 继续下一次重试
                    continue;
                } else {
                    // 调用回退方法
                    if (StringUtils.isNotBlank(fallbackMethodName)) {
                        // 调用回退方法
                        return invokeFallbackMethod2(pjp, fallbackMethodName);
                    } else {
                        throw e; // 未指定回退方法或重试次数未耗尽但不是需要捕获的异常，直接抛出
                    }
                }
            }
        }
        // 理论上不会走到这里，除非maxCount设置为0或负数
        throw new IllegalStateException("maxCount设置为0或负数, Unexpected end of retry loop");
    }

    /**
     * 判断方法抛出的异常是否需要进行重试
     * @param e
     * @param forExceptions
     * @return
     */
    private boolean shouldRetry(Throwable e, Class<? extends Throwable>[] forExceptions) {
        return forExceptions.length == 0 || Arrays.stream(forExceptions).anyMatch(exClass -> exClass.isInstance(e));
    }

    /**
     * 使用bean实例，调用指定的回退方法
     * @param pjp
     * @param methodName
     * @return
     */
    private Object invokeFallbackMethod(ProceedingJoinPoint pjp, String methodName) throws Exception {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Object targetBean = beanFactory.getBean(signature.getDeclaringType());
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Object[] args = pjp.getArgs();

        // 获取回退方法并调用
        java.lang.reflect.Method fallbackMethod = signature.getDeclaringType().getMethod(methodName, parameterTypes);
        if (fallbackMethod != null) {
            if (fallbackMethod.getReturnType() == Void.TYPE) {
                fallbackMethod.invoke(targetBean, args);
                return null; // 如果回退方法返回void，则此处返回null
            } else {
                return fallbackMethod.invoke(targetBean, args);
            }
        } else {
            throw new NoSuchMethodException("要执行的回退方法 '" + methodName + "' 在 " + targetBean.getClass() + "不存在！");
        }
    }

    /**
     * 使用类实例反射，调用指定的回退方法
     * @param pjp
     * @param methodName
     * @return
     */
    private Object invokeFallbackMethod2(ProceedingJoinPoint pjp, String methodName) throws Exception {
        Object target = pjp.getTarget();
        Class<?> clazz = pjp.getTarget().getClass();
        Method method = clazz.getMethod(methodName);
        return method.invoke(target);
    }
}
