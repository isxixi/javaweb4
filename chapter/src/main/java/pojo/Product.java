package pojo;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private int count;
    private double price;

    public Product(String s, String 一本书, int i, double v) {
    }
}