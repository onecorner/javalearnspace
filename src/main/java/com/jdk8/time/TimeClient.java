package com.jdk8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @author htj
 * @since 2019/6/3 10:06
 */
public class TimeClient {
    public static void main(String[] args) {
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        int month = date1.getMonthValue();
        int day = date1.getDayOfMonth();
        System.out.println("月: " + month + ", 日: " + day);
        // int month = currentTime.getMonthValue();
        // int day = currentTime.getDayOfMonth();
        // int seconds = currentTime.getSecond();
        // System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
        LocalDateTime parse = LocalDateTime.parse("2015-02-03T12:13:15.890");
        System.out.println(parse);
    }
}
