/**
 * @Description
 * @Author yangxh8
 * @Date 2024/6/8 21:49
 */

import com.yangxh.domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    @Test
    public void forEachTest() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
    /*one.stream().forEach((String s) -> {
        System.out.println(s);
    });*/
        // 简写
        // one.stream().forEach(s -> System.out.println(s));
//        one.stream().forEach(System.out::println);
//        System.out.println(one.stream().count());
//        one.stream().filter(s -> s.length() == 2).forEach(System.out::println);
//        one.stream().skip(1).forEach(System.out::println);
//        Stream<String> original = Stream.of("11", "22", "33");
//        Stream<Integer> result = original.map(Integer::parseInt);
//        result.forEach(s -> System.out.println(s + 10));
//        Stream.of(22, 33, 22, 11, 33).distinct().forEach(System.out::println);
//        Optional<Integer> first = Stream.of(5, 3, 6, 1).findFirst();
//        System.out.println("first = " + first.get());
//        Optional<Integer> any = Stream.of(5, 3, 6, 1).findAny();
//        System.out.println("any = " + any.get());
//        Integer count = Stream.of(2, 4, 5, 6, 1, 3).reduce(0, (a, b) -> {
//            return a + b;
//        });
//        Integer count2 = Stream.of(2, 4, 5, 6, 1, 3).reduce(0, (a, b) -> {
//            return Integer.sum(a, b);
//        });
//        Integer count3 = Stream.of(2, 4, 5, 6, 1, 3).reduce(0, Integer::sum);
//        System.out.println(count);
//        System.out.println(count2);
//        System.out.println(count3);

//        int totalAge = Stream.of(
//                        new Person("刘德华", 58,171),
//                        new Person("张学友", 56,171),
//                        new Person("郭富城", 54,171),
//                        new Person("黎明", 52,171))
//                .map(Person::getAge)
//                .reduce(0, (x, y) -> x + y);
//        System.out.println("totalAge = " + totalAge);

//        // Integer占用的内存比int多,在Stream流操作中会自动装箱和拆箱
//        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
//        // 把大于3的和打印出来
//        // Integer result = stream
//        // .filter(i -> i.intValue() > 3)
//        // .reduce(0, Integer::sum);
//        // System.out.println(result);
//        // 先将流中的Integer数据转成int,后续都是操作int类型
//        IntStream intStream = stream.mapToInt(Integer::intValue);
//        int reduce = intStream
//                .filter(i -> i > 3)
//                .reduce(0, Integer::sum);
//        System.out.println(reduce);
//        // 将IntStream转化为Stream<Integer>
//        IntStream intStream1 = IntStream.rangeClosed(1, 10);
//        Stream<Integer> boxed = intStream1.boxed();
//        boxed.forEach(s -> System.out.println(s.getClass() + ", " + s));

//        Stream<String> streamA = Stream.of("张三");
//        Stream<Integer> streamB = Stream.of(1);
//        Stream<? extends Serializable> result = Stream.concat(streamA, streamB);
//        result.forEach(System.out::println);

//        Stream<Student> studentStream = Stream.of(
//                new Student("赵丽颖", 52, 95),
//                new Student("杨颖", 56, 88),
//                new Student("迪丽热巴", 56, 55),
//                new Student("柳岩", 52, 33));
//        // Map<Integer, List<Student>> map =
////        Map<Integer, List<Student>> map = studentStream.collect(Collectors.groupingBy(Student::getAge));
//        // 将分数大于60的分为一组,小于60分成另一组
//        Map<String, List<Student>> map = studentStream.collect(
//                Collectors.groupingBy((s) -> {
//                    if (s.getSocre() > 60) {
//                        return "及格";
//                    } else {
//                        return "不及格";
//                    }
//                }));
//        map.forEach((k, v) -> {
//            System.out.println(k + "::" + v);
//        });

//        Stream<Student> studentStream = Stream.of(
//                new Student("赵丽颖", 52, 95),
//                new Student("杨颖", 56, 88),
//                new Student("迪丽热巴", 56, 99),
//                new Student("柳岩", 52, 77));
//        Map<Integer, Map<String, List<Student>>> map =
//                studentStream.collect(Collectors.groupingBy(s -> s.getAge(), Collectors.groupingBy(s -> {
//                    if (s.getSocre() >= 90) {
//                        return "优秀";
//                    } else if (s.getSocre() >= 80 && s.getSocre() < 90) {
//                        return "良好";
//                    } else if (s.getSocre() >= 80 && s.getSocre() < 80) {
//                        return "及格";
//                    } else {
//                        return "不及格";
//                    }
//                })));
//        map.forEach((k, v) -> {
//            System.out.println(k + " == " + v);
//        });

//        Stream<Student> studentStream = Stream.of(
//                new Student("赵丽颖", 52, 95),
//                new Student("杨颖", 56, 88),
//                new Student("迪丽热巴", 56, 99),
//                new Student("柳岩", 52, 77));
//        // partitioningBy会根据值是否为true，把集合分割为两个列表，一个true列表，一个false列表。
//        Map<Boolean, List<Student>> map = studentStream.collect(Collectors.partitioningBy(s -> s.getSocre() > 90));
//        map.forEach((k, v) -> {
//            System.out.println(k + " == " + v);
//        });


        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77));
        String collect = studentStream
                .map(Student::getName)
                .collect(Collectors.joining("！"));
        System.out.println(collect);
    }
}
