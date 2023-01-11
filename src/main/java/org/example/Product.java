package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String productType;
    private String name;
    private static int idGenerator = 0;
    private int id;
    private double price;

    public Product(String productType, String name, int id, double price) {
        this.name = name;
        this.productType = productType;
        this.id = id;
        this.price = price;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "Продукты: " +
                "ID: " + id +
                " ,Тип продукта: " + productType +
                ", Название: " + name +
                ", Цена: " + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(productType, product.productType) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, name, id, price);
    }
}