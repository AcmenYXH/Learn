package com.yangxh;

/**
 * @Description ${description}
 * @Author yangxh
 * @Date 2024/8/12 22:16
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello GC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}