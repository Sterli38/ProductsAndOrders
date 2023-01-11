package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Products implements Serializable {
    private final List<Product> products = new ArrayList<>();

//        Product product =new Product("Продукты", "Гречка", 101);
//        products.add(product);
//        Product product1 = new Product("Продукты", "Шоколад", 120);
//        products.add(product1);
//        Product product2 = new Product("Продукты", "Молоко", 90);
//        products.add(product2);
//        Product product3 = new Product("Товары для дома", "Мыло", 50);
//        products.add(product3);
//        Product product4 =  new Product("Продукты", "Мука", 56);
//        products.add(product4);
//        Product product5 = new Product("Продукты", "Сок", 67);
//        products.add(product5);
//        Product product6 = new Product("Продукты", "Жвачка", 29);
//        products.add(product6);
//        Product product7 = new Product("Товары для дома", "Освежитель воздуха", 130);
//        products.add(product7);
//        Product product8 = new Product("Товары для дома", "Шампунь", 150);
//        products.add(product8);
//        Product product9 = new Product("Выпечка", "Хлеб", 20);
//        products.add(product9);
//        Product product10 = new Product("Выпечка", "Курасcан", 43);
//        products.add(product10);
//        Product product11 = new Product("Продукты", "Мармелад", 67);
//        products.add(product11);
//        Product product12 = new Product("Товары для дома", "Хлорка", 120);
//        products.add(product12);
//        Product product13 = new Product("Продукты", "Вода", 55);
//        products.add(product13);
//        Product product14 = new Product("Продукты ", "Чипсы", 99);
//        products.add(product14);
//        Product product15 = new Product("Продукты", "Сыр", 67);
//        products.add(product15);
//        Product product16 = new Product("Продукты", "Яйца", 102);
//        products.add(product16);
//        Product product17 = new Product("Продукты", "Бананы", 97);
//        products.add(product17);
//        Product product18 = new Product("Продукты", "Мёд", 170);
//        products.add(product18);
//        Product product19 = new Product("Товары для дома", "Швабра", 1300);
//        products.add(product19);
//        Product product20 = new Product("Продукты", "Кетчуп", 144);
//        products.add(product20);

    public void add(Product product) {
        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }

//    public Product getProduct(Product product) {
//        return products.get(products.indexOf(product));
//    }

    public Product getProduct(int id) {
        return products.stream()
                .filter(i ->i.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int size() {
        return products.size();
    }

    @Override
    public String toString() {
        return "" + products;
    }

    public void addAll(List<Product> products) {
        this.products.addAll(products);
    }
}