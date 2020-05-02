package com.cg.ecommerce.productmgt.service;

import com.cg.ecommerce.productmgt.dao.IProductDao;
import com.cg.ecommerce.productmgt.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private IProductDao productDao;

    public IProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(IProductDao dao) {
        this.productDao = dao;
    }

    @Override
    public Product add(Product product) {
        return productDao.add(product);
    }

    @Override
    public List<Product> fetchAll() {
        List<Product> products = productDao.fetchAll();
        return products;
    }

    @Override
    public Product findById(String id) {
        Product product=productDao.findById(id);
        return product;
    }
}
