package service.impl;

import dao.ProductDAO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public List<Product> list() {
        List<Product> products= productDAO.list();
        if(products.isEmpty()){
            for (int i = 0; i < 5; i++) {
                if (i==2){
                    throw new RuntimeException();
                }
                Product p = new Product();
                p.setName("product " + i);
                productDAO.add(p);
                products.add(p);
            }
        }
        return products;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
