//import dao.ProductDAO1;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import pojo.Product;
import service.ProductService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestSS {

    @Autowired
//    private ProductDAO1 dao;
    ProductService productService;
    @Test
    public void testGet(){
//        List<Product> ps = (List<Product>) dao.find("from Product");
        List<Product> ps = productService.list();
        for (Product p : ps) {
            System.out.println(p.getName());
        }
    }

}
