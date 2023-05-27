package db;

import pojo.Product;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DB {
    private static Map<String, Product> products = new LinkedHashMap<>();

    static {
        products.put("1",new Product("1","一本书",33,12.22));
        products.put("2",new Product("2","一支笔",23,15.22));
        products.put("3",new Product("3","一瓶水",43,3.22));
        products.put("4",new Product("4","一辆车",22,12000.22));
        products.put("5",new Product("5","一袋米",11,10.2));
    }
    public static Collection<Product> getAll(){return products.values();}
    public static Product find(String id){return products.get(id);}
}
