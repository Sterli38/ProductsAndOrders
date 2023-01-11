package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrdersServiceTest {

    @Test
    void getOrders() {
        OrdersService ordersService = new OrdersService(Path.testPath);
        GregorianCalendar creationDate = new GregorianCalendar(2021,9,20,01,30,00);
        GregorianCalendar paymentDay = new GregorianCalendar(2020,10,21,01,40,00);
        GregorianCalendar creationDate1 = new GregorianCalendar(2021,9,21,01,30,00);
        GregorianCalendar creationDate2 = new GregorianCalendar(2022,8,3,01,30,00);
        GregorianCalendar creationDate3 = new GregorianCalendar(2022,8,3,01,30,00);
        GregorianCalendar paymentDay3 = new GregorianCalendar(2022,9,21,07,21,00);
        GregorianCalendar creationDate5 = new GregorianCalendar(2022,3,10,20,29,00);
        GregorianCalendar paymentDay5 = new GregorianCalendar(2022,3,11,8,25,00);
        Order order = new Order(creationDate.getTime(),1,paymentDay.getTime());
        order.add(new Product("Продукты","Бананы",18,50));
        order.add(new Product("Продукты","Печенье",7,78));
        order.add(new Product("Продукты","Чипсы",50,90));
        Order order1 = new Order(creationDate1.getTime(),2,null);
        order1.add(new Product("Продукты","Масло",19,58));
        order1.add(new Product("Продукты","Чипсы",50,90));
        Order order2 = new Order(creationDate2.getTime(),3,null);
        order2.add(new Product("Продукты","Масло",19,58));
        order2.add(new Product("Продукты","Арахис",3,120));
        order2.add(new Product("Продукты","Мясо",2,200));
        order2.add(new Product("Продукты","Чипсы",50,90));
        Order order3 = new Order(creationDate3.getTime(),4,paymentDay3.getTime());
        order3.add(new Product("Продукты","Масло",19,58));
        order3.add(new Product("Продукты","Арахис",3,120));
        order3.add(new Product("Продукты","Мясо",2,200));
        order3.add(new Product("Продукты","Чипсы",50,90));
        Order order4 = new Order(creationDate5.getTime(),5,paymentDay5.getTime());
        order4.add(new Product("Продукты","Майонез",20,80));
        order4.add(new Product("Продукты","Памело",1,79));
        order4.add(new Product("Продукты","Масло",3,120));
        order4.add(new Product("Продукты","Чипсы",50,90));
        order4.add(new Product("Продукты","Сок яблочный",5,140));
        order4.add(new Product("Товары для дома","Мыло",5,90));
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        assertEquals(ordersService.getOrders(),orderList);
    }

    @Test
    void addOrder() {
        OrdersService ordersService = new OrdersService(Path.testPath);
        GregorianCalendar creationDate = new GregorianCalendar(2021,9,20,01,30,00);
        GregorianCalendar paymentDay = new GregorianCalendar(2020,10,21,01,40,00);
        GregorianCalendar creationDate1 = new GregorianCalendar(2021,9,21,01,30,00);
        GregorianCalendar creationDate2 = new GregorianCalendar(2022,8,3,01,30,00);
        GregorianCalendar creationDate3 = new GregorianCalendar(2022,8,3,01,30,00);
        GregorianCalendar paymentDay3 = new GregorianCalendar(2022,9,21,07,21,00);
        GregorianCalendar creationDate5 = new GregorianCalendar(2022,3,10,20,29,00);
        GregorianCalendar paymentDay5 = new GregorianCalendar(2022,3,11,8,25,00);
        GregorianCalendar newCreationDate = new GregorianCalendar(2022,10,15);
        GregorianCalendar newPaymentDate = new GregorianCalendar(2022,11,15);
        Order order = new Order(creationDate.getTime(),1,paymentDay.getTime());
        order.add(new Product("Продукты","Бананы",18,50));
        order.add(new Product("Продукты","Печенье",7,78));
        order.add(new Product("Продукты","Чипсы",50,90));
        Order order1 = new Order(creationDate1.getTime(),2,null);
        order1.add(new Product("Продукты","Масло",19,58));
        order1.add(new Product("Продукты","Чипсы",50,90));
        Order order2 = new Order(creationDate2.getTime(),3,null);
        order2.add(new Product("Продукты","Масло",19,58));
        order2.add(new Product("Продукты","Арахис",3,120));
        order2.add(new Product("Продукты","Мясо",2,200));
        order2.add(new Product("Продукты","Чипсы",50,90));
        Order order3 = new Order(creationDate3.getTime(),4,paymentDay3.getTime());
        order3.add(new Product("Продукты","Масло",19,58));
        order3.add(new Product("Продукты","Арахис",3,120));
        order3.add(new Product("Продукты","Мясо",2,200));
        order3.add(new Product("Продукты","Чипсы",50,90));
        Order order4 = new Order(creationDate5.getTime(),5,paymentDay5.getTime());
        order4.add(new Product("Продукты","Майонез",20,80));
        order4.add(new Product("Продукты","Памело",1,79));
        order4.add(new Product("Продукты","Масло",3,120));
        order4.add(new Product("Продукты","Чипсы",50,90));
        order4.add(new Product("Продукты","Сок яблочный",5,140));
        order4.add(new Product("Товары для дома","Мыло",5,90));
        Order newOrder = new Order(newCreationDate.getTime(),9,newPaymentDate.getTime());
        newOrder.add(new Product("Продукты","Шоколад",45,121));
        newOrder.add(new Product("Продукты","Мармелад",23,57));
        newOrder.add(new Product("Продукты","Торт Наполеон",95,1500));
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(newOrder);
        ordersService.addOrder(newOrder);
        List<Order> list = ordersService.getOrders();
        assertEquals(list,orderList);
    }

    @Test
    void getOrder() {
        OrdersService ordersService = new OrdersService(Path.testPath);
        GregorianCalendar creationDate = new GregorianCalendar(2021, 9, 20, 01, 30, 00);
        GregorianCalendar paymentDay = new GregorianCalendar(2020, 10, 21, 01, 40, 00);
        Order order = new Order(creationDate.getTime(), 1, paymentDay.getTime());
        order.add(new Product("Продукты", "Бананы", 18, 50));
        order.add(new Product("Продукты", "Печенье", 7, 78));
        order.add(new Product("Продукты", "Чипсы", 50, 90));
        Order order1 = ordersService.getOrder(1);
        assertEquals(order1,order);
    }

    @Test
    void isEmpty() {
        OrdersService ordersService = new OrdersService(Path.testEmptyPath);
        assertTrue(ordersService.isEmpty());
        Order order = new Order(new Date(2021),10,new Date(2022));
        ordersService.addOrder(order);
        assertFalse(ordersService.isEmpty());
    }

    @Test
    void testToString() {
    }

    @Test
    void getUnpaidOrders() {
        OrdersService ordersService = new OrdersService(Path.testPath);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2022, Calendar.OCTOBER,20,01,30,00);
        GregorianCalendar gregorianCalendar1 = new GregorianCalendar(2022,Calendar.SEPTEMBER,3,01,30,00);
        Order order = new Order(gregorianCalendar.getTime(),2,null);
        order.add(new Product("Продукты","Масло",19,58));
        order.add(new Product("Продукты","Чипсы",50,90));
        Order order1 = new Order(gregorianCalendar1.getTime(),3,null);
        order1.add(new Product("Продукты","Масло",19,58));
        order1.add(new Product("Продукты","Арахис",3,120));
        order1.add(new Product("Продукты","Мясо",2,200));
        order1.add(new Product("Продукты","Чипсы",50,90));
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        List<Order> list = ordersService.getUnpaidOrders();
        assertEquals(orderList,list);
    }

    @Test
    void getOrdersBetween() {
        OrdersService ordersService = new OrdersService(Path.testPath);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2021, Calendar.OCTOBER,20,01,30,00);
        GregorianCalendar gregorianCalendar1 = new GregorianCalendar(2021,Calendar.OCTOBER,21,01,30,00);
        GregorianCalendar gregorianCalendar4 = new GregorianCalendar(2020,10,21,01,40,00);

        Order order = new Order(gregorianCalendar.getTime(),1,gregorianCalendar4.getTime());
        order.add(new Product("Продукты","Бананы",18,50));
        order.add(new Product("Продукты","Печенье",7,78));
        order.add(new Product("Продукты","Чипсы",50,90));
        Order order1 = new Order(gregorianCalendar1.getTime(),2,null);
        order1.add(new Product("Продукты","Масло",19,58));
        order1.add(new Product("Продукты","Чипсы",50,90));
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(2021,9,1);
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar(2021,10,1);

        List<Order> list1 = ordersService.getOrdersBetween(gregorianCalendar2.getTime(),gregorianCalendar3.getTime());
        assertEquals(orderList,list1);


    }

    @Test
    void top() {
        OrdersService ordersService = new OrdersService(Path.testPath);
        Product product = new Product("Продукты", "Чипсы" , 50,90);
        Product product1 = new Product("Продукты","Масло",19,58);
        Product product2 = new Product("Продукты","Мясо",2,200);
        Map<Product,Integer> map = new LinkedHashMap<>();
        map.put(product,5);
        map.put(product1,3);
        map.put(product2,2);
        List<Product> products2 = new ArrayList<>(map.keySet());
        List<Integer> integers = new ArrayList<>(map.values());
        List<Map.Entry<Product,Integer>> list = new ArrayList<>(map.entrySet());
        List<Map.Entry<Product, Integer>> products = ordersService.top();
        assertEquals(products,list);
//        System.out.println(list);
//        System.out.println(products);
    }
}