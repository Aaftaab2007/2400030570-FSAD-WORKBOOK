package com.retail.inventory;

import com.retail.inventory.dao.*;
import com.retail.inventory.entity.Product;

public class App {
    public static void main(String[] args) {

        ProductDAO crud = new ProductDAO();
        ProductHQLDAO hql = new ProductHQLDAO();

        // Insert 8 Products
        crud.save(new Product("Laptop", "Electronics", 1200, 10));
        crud.save(new Product("Phone", "Electronics", 700, 20));
        crud.save(new Product("Mouse", "Electronics", 25, 50));
        crud.save(new Product("Chair", "Furniture", 150, 15));
        crud.save(new Product("Table", "Furniture", 250, 5));
        crud.save(new Product("Pen", "Stationery", 5, 100));
        crud.save(new Product("Notebook", "Stationery", 10, 80));
        crud.save(new Product("Monitor", "Electronics", 300, 12));

        System.out.println("Price ASC: " + hql.priceAsc().size());
        System.out.println("Price DESC: " + hql.priceDesc().size());
        System.out.println("Quantity DESC: " + hql.quantityDesc().size());

        System.out.println("First 3: " + hql.paginate(0, 3).size());
        System.out.println("Next 3: " + hql.paginate(3, 3).size());

        System.out.println("Total Products: " + hql.countAll());
        System.out.println("Available Products: " + hql.countAvailable());

        hql.countByDescription()
           .forEach(o -> System.out.println(o[0] + " -> " + o[1]));

        Object[] mm = hql.minMaxPrice();
        System.out.println("Min: " + mm[0] + " Max: " + mm[1]);

        System.out.println("LIKE 'M%': " + hql.like("M%").size());
        System.out.println("LIKE '%r': " + hql.like("%r").size());
        System.out.println("LIKE '%oo%': " + hql.like("%oo%").size());
    }
}
