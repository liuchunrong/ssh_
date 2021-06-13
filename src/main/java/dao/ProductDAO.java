package dao;

import pojo.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> list();
    public void add(Product p);
}
