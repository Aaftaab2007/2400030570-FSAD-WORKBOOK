package com.retail.inventory.dao;

import com.retail.inventory.entity.Product;
import com.retail.inventory.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductHQLDAO {

    public List<Product> priceAsc() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("FROM Product p ORDER BY p.price ASC", Product.class)
                .list();
    }

    public List<Product> priceDesc() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("FROM Product p ORDER BY p.price DESC", Product.class)
                .list();
    }

    public List<Product> quantityDesc() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class)
                .list();
    }

    public List<Product> paginate(int start, int size) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Product", Product.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .list();
    }

    public Long countAll() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                .uniqueResult();
    }

    public Long countAvailable() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("SELECT COUNT(p) FROM Product p WHERE p.quantity > 0", Long.class)
                .uniqueResult();
    }

    public List<Object[]> countByDescription() {
        return HibernateUtil.getSessionFactory().openSession().createQuery("SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description").list();
    }

    public Object[] minMaxPrice() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("SELECT MIN(p.price), MAX(p.price) FROM Product p", Object[].class)
                .uniqueResult();
    }

    public List<Product> priceRange(double min, double max) {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .list();
    }

    public List<Product> like(String pattern) {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("FROM Product p WHERE p.name LIKE :p", Product.class)
                .setParameter("p", pattern)
                .list();
    }
}
