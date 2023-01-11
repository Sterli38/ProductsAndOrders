package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        OrdersService o = new OrdersService(Path.originalPath);
        System.out.println(o.top());
//        System.out.println(o.getOrders());
//        Date date = new Date(2019,4,15);
//        Date date1 = new Date(2022,3,15);
//        GregorianCalendar calendar = new GregorianCalendar(2020,10,20);
//        GregorianCalendar calendar1 = new GregorianCalendar(2020,10,22);
//        System.out.println(o.getOrdersBetween(calendar.getTime(),calendar1.getTime()));
//Manager manager = new Manager();
//        System.out.println(o.top());
//       System.out.println(o.getOrders());
//        System.out.println(o.getOrdersBetween(new Date(2024,11,20),new Date(2022,11,20))); *
    }
}
