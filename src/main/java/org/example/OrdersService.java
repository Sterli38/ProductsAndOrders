package org.example;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class OrdersService implements Serializable {
    private List<Order> orders = new ArrayList<>();

    public OrdersService(String path) {

        try (BufferedReader ois = new BufferedReader(new FileReader(path))) {
            String string = ois.readLine();
            DateFormat dateFormat = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss");
            while(string != null) {
                String[] array = string.split(";");
                Date date = null;
                if(!array[2].equals("")) {
                    date = dateFormat.parse(array[2]);
                }
                Order order = new Order(dateFormat.parse(array[0]), Integer.parseInt(array[1]), date);
                for(int j = 3; j < array.length; j += 4) {
                    try {
                        Product product = new Product(array[j], array[j + 1], Integer.parseInt(array[j + 2]), Double.parseDouble(array[j + 3]));
                        order.add(product);
                    } catch (Exception ex1) {
                        System.out.println("Неверный формат добавления продукта или заказа");
                    }
                }
                orders.add(order);
                string = ois.readLine();
            }
        } catch (IOException ex) {
//            ex.printStackTrace();
            System.out.println("Файл не найден");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(int id) {
        Order order = orders.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
        if(order == null) {
            System.out.println("Такого заказа нет в списке заказов!");
        } else {
            System.out.println(order);
        }
        return order;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public String toString() {
        return "Заказы:" +  orders;
    }

    public List<Order> getUnpaidOrders() {
        return orders.stream()
                .filter(i -> i.getOrderPaymentDay() == null )
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersBetween(Date dateFrom, Date dateTill) {
        return orders.stream()
                .filter(i -> i.getCreationDate().after(dateFrom) &&  i.getCreationDate().before(dateTill))
                .collect(Collectors.toList());
    }

    private void sale() {
         orders.stream()
                .filter(i -> i.getOrderPrice() > 1000)
                .forEach(i -> i.setPrice(i.getOrderPrice() * 0.95));
    }

    public List<Map.Entry<Product, Integer>> top() {
        Map<Product,Integer> map = new HashMap<>();
        for(int i = 0; i < orders.size(); i++) { //Создаём внешний цикл чтобы получить список продуктов каждого заказа
            List<Product> products = orders.get(i).getProducts();
            for(int j = 0 ; j < products.size(); j++) {
                Product product = products.get(j); // Получаем каждый продукт
                Integer count = map.get(product);
                if(count == null) {
                    map.put(product,1);
                } else {
                    map.put(product,count + 1);// если продукт ранее не встречался , Пишем одно повторение , если продукт встречался ранее прибавляем 1
                }
            }
        }
        List<Map.Entry<Product,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list.stream()
                .limit(3)
                .collect(Collectors.toList());
    }
}