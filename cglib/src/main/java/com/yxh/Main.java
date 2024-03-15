package com.yxh;

import com.yxh.cglib.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/10/22 21:47
 */
public class Main {
    public static void main(String[] args) {
        final UserService target = new UserService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object invoke = null;
                if (method.getName().equals("test")) {
                    System.out.println("方法增强--前面");
                    invoke = methodProxy.invokeSuper(o, objects);
                    System.out.println("方法增强--后面");
                }
                return invoke;
            }
        });

        UserService proxyObj = (UserService)enhancer.create();
        proxyObj.test();

    }
}
