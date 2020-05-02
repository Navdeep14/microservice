package com.cg.ecommerce.productmgt.service;

import com.cg.ecommerce.productmgt.entities.Product;

import java.util.List;

public interface IProductService {
    Product add(Product product);

    List<Product> fetchAll();

    Product findById(String id);
}
