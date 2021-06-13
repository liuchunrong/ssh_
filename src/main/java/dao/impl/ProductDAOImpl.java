package dao.impl;

import dao.ProductDAO;
import org.springframework.orm.hibernate5.HibernateTemplate;
import pojo.Product;

import java.util.List;

public class ProductDAOImpl extends HibernateTemplate implements ProductDAO {
    @Override
    public List<Product> list() {
        return (List<Product>)find("from Product");
    }

    @Override
    public void add(Product p) {
        save(p);
    }
}
