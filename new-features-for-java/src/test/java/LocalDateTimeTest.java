import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;

/**
 * @Description
 * @Author yangxh8
 * @Date 2024/6/16 21:50
 */
public class LocalDateTimeTest {

    @Test
    public void localDateTest() {
        // 创建指定日期
        LocalDate fj = LocalDate.of(1985, 9, 23);
        System.out.println("fj = " + fj); // 1985-09-23
        // 得到当前日期
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate); // 2019-10-16
        // 获取日期信息
        System.out.println("年: " + nowDate.getYear());
        System.out.println("月: " + nowDate.getMonthValue());
        System.out.println("日: " + nowDate.getDayOfMonth());
        System.out.println("星期: " + nowDate.getDayOfWeek());
    }

    @Test
    public void localTimeTest() {
        // 得到指定的时间
        LocalTime time = LocalTime.of(12,15, 28, 129_900_000);
        System.out.println("time = " + time);
        // 得到当前时间
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);
        // 获取时间信息
        System.out.println("小时: " + nowTime.getHour());
        System.out.println("分钟: " + nowTime.getMinute());
        System.out.println("秒: " + nowTime.getSecond());
        System.out.println("纳秒: " + nowTime.getNano());
    }

    @Test
    public void localDateTimeTest() {
        LocalDateTime fj = LocalDateTime.of(1985, 9, 23, 9, 10, 20);
        System.out.println("fj = " + fj); // 1985-09-23T09:10:20
        // 得到当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now); // 2019-10-16T16:42:24.497896800
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
    }

    @Test
    public void test05() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        // 修改日期时间
        LocalDateTime setYear = now.withYear(2078);
        System.out.println("修改年份: " + setYear);
        System.out.println("now == setYear: " + (now == setYear));
        System.out.println("修改月份: " + now.withMonth(6));
        System.out.println("修改小时: " + now.withHour(9));
        System.out.println("修改分钟: " + now.withMinute(11));
        // 再当前对象的基础上加上或减去指定的时间
        LocalDateTime localDateTime = now.plusDays(5);
        System.out.println("5天后: " + localDateTime);
        System.out.println("now == localDateTime: " + (now == localDateTime));
        System.out.println("10年后: " + now.plusYears(10));
        System.out.println("20月后: " + now.plusMonths(20));
        System.out.println("20年前: " + now.minusYears(20));
        System.out.println("5月前: " + now.minusMonths(5));
        System.out.println("100天前: " + now.minusDays(100));
    }

    // 日期格式化
    @Test
    public void test04() {
        // 得到当前日期时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将日期时间格式化为字符串
        String format = now.format(formatter);
        System.out.println("format = " + format);
        // 将字符串解析为日期时间
        LocalDateTime parse = LocalDateTime.parse("1985-09-23 10:12:22", formatter);
        System.out.println("parse = " + parse);
    }

    // 时间戳
    @Test
    public void test07() {
        Instant now = Instant.now();
        System.out.println("当前时间戳 = " + now);
        // 获取从1970年1月1日 00:00:00的秒
        System.out.println(now.getNano());
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        Instant instant = Instant.ofEpochSecond(5);
        System.out.println(instant);
    }

    // Duration/Period类: 计算日期时间差
    @Test
    public void test08() {
        // Duration计算时间的距离
        LocalTime now = LocalTime.now();
        LocalTime time = LocalTime.of(14, 15, 20);
        Duration duration = Duration.between(time, now);
        System.out.println("相差的天数:" + duration.toDays());
        System.out.println("相差的小时数:" + duration.toHours());
        System.out.println("相差的分钟数:" + duration.toMinutes());
        System.out.println("相差的秒数:" + duration.getSeconds());
        // Period计算日期的距离
        LocalDate nowDate = LocalDate.now();
        LocalDate date = LocalDate.of(1998, 8, 8);
        // 让后面的时间减去前面的时间
        Period period = Period.between(date, nowDate);
        System.out.println("相差的年:" + period.getYears());
        System.out.println("相差的月:" + period.getMonths());
        System.out.println("相差的天:" + period.getDays());
    }

    // TemporalAdjuster类:自定义调整时间
    @Test
    public void test09() {
        LocalDateTime now = LocalDateTime.now();
        // 得到下一个月的第一天
        TemporalAdjuster firsWeekDayOfNextMonth = temporal -> {
            LocalDateTime dateTime = (LocalDateTime) temporal;
            LocalDateTime nextMonth = dateTime.plusMonths(1).withDayOfMonth(1);
            System.out.println("nextMonth = " + nextMonth);
            return nextMonth;
        };
        LocalDateTime nextMonth = now.with(firsWeekDayOfNextMonth);
        System.out.println("nextMonth = " + nextMonth);
    }


}
