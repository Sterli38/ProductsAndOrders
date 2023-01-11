package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Order implements Serializable {
   private final Date creationDate;
   private int id = idGenerator++;
   private static int idGenerator = 1;
   private Date orderPaymentDay;
   private double price;
   private List<Product> products = new ArrayList<>();

   public Order(Date creationDate, int id, Date orderPaymentDay) {
      this.creationDate = creationDate;
      this.id = id;
      this.orderPaymentDay = orderPaymentDay;

   }

   public void setOrderPaymentDay(Date orderPaymentDay) {
      this.orderPaymentDay = orderPaymentDay;
   }

   public int getId() {
      return id;
   }

   public Date getCreationDate() {
      return creationDate;
   }

   public Date getOrderPaymentDay() {
      return orderPaymentDay;
   }

   @Override
   public String toString() {
      return   "Заказ: " +
              "Дата: " + creationDate +
              ", id = " + id +
              ", День оплаты: " + orderPaymentDay +
              ", Список продуктов: " + products +
              '}';
   }

   public void add(Product product) {
      products.add(product);
   }

   public Product getProduct(int id) {
    return products.stream()
            .filter(i -> i.getId() == id)
            .findFirst().get();
   }



   public void remove(int id) {
//       products = products.stream()
//           .filter(i -> i.getId() != id)
//           .collect(Collectors.toList());
//
      products.removeIf(i -> i.getId() == id);
   }

   public boolean isEmpty() {
      return products.isEmpty();
   }

   public double getOrderPrice() {
      return products.stream()
              .mapToInt(i -> (int) i.getPrice())
              .sum();
   }

   public List<Product> getProducts() {
      return products;
   }

      public void sale() {
         products.forEach(i -> i.setPrice(i.getPrice() * 0.95));
   }

   public void setPrice(double price) {
     this.price = price;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Order order = (Order) o;
      return id == order.id && Double.compare(order.price, price) == 0 && Objects.equals(creationDate, order.creationDate) && Objects.equals(orderPaymentDay, order.orderPaymentDay) && Objects.equals(products, order.products);
   }

   @Override
   public int hashCode() {
      return Objects.hash(creationDate, id, orderPaymentDay, price, products);
   }

   //      public void top() {
//      products.stream()
//              .filter(i -> Collections.frequency(products, i) > 1)
//              .collect(Collectors.toSet())
//              .forEach(System.out::println);
//   }
}
