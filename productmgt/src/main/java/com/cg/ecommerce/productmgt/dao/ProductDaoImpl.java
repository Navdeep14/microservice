package com.cg.ecommerce.productmgt.dao;

import com.cg.ecommerce.productmgt.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductDaoImpl implements IProductDao{
    private Map<String,Product>store=new HashMap<>();

    public ProductDaoImpl(){
        Product p1=new Product();
        p1.setProductId("p1");
        p1.setProductName("mi1");

        Product p2=new Product();
        p2.setProductId("p2");
        p2.setProductName("samsung");
        store.put("p1",p1);
        store.put("p2",p2);

    }

    @Override
    public Product add(Product product) {
        store.put(product.getProductId(),product);
        return product;
    }

    @Override
    public List<Product> fetchAll() {
       Collection<Product>values= store.values();
       List<Product>list=new ArrayList<>(values);
       return list;
    }

    @Override
    public Product findById(String id) {
       Product product= store.get(id);
       return product;
    }
}
