package com.yangxh.jdk8;

import com.yangxh.busi.interfaces.Smokeable;
import com.yangxh.busi.interfaces.Swimmable;
import com.yangxh.domain.Person;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Description JDK8新特性--Lambda表达式
 * @Author yangxh8
 * @Date 2024/5/27 21:26
 */
public class Lambda {
    public static void main(String[] args) {
        // 1、普通匿名内部类实现方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程任务执行!");
            }
        }).start();

        // 2、Lambda表达式
        new Thread(() ->{
            System.out.println("Lambda新线程任务执行");
        }).start();

        // 3、无参数无返回值的Lambda
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("普通匿名内部类实行方式：游泳");
            }
        });
        goSwimming(()->{
            System.out.println("Lambda表达式：游泳");
        });

        // 4、有参数无返回值
        goSmoking((name)->{
            System.out.println("抽了"+name+"香烟");
        });
        // 4.1、普通方法
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 58, 176));
        persons.add(new Person("刘德华", 54, 171));
        persons.add(new Person("黎明", 53, 178));
//        Collections.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
//        for (Person person : persons) {
//            System.out.println(person);
//        }
        // 4.2、Lambda方式
        Collections.sort(persons, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("-----------------");
        List<Integer> list = Arrays.asList(11, 22, 33, 44);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("-----------------");
        list.forEach((s) -> {
            System.out.println(s);
        });
    }

    public static void goSwimming(Swimmable s) {
        s.swimming();
    }

    public static void goSmoking(Smokeable s) {
        s.smoking("中华");
    }
}
