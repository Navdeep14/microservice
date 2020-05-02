package com.cg.ecommerce.productmgt.dao;

import com.cg.ecommerce.productmgt.entities.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IProductDao {

    Product add(Product product);

    List<Product>fetchAll();

    Product findById(String id);

}
