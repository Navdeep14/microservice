package com.cg.ecommerce.itemmgt.service;

import com.cg.ecommerce.itemmgt.dao.ICartDao;
import com.cg.ecommerce.itemmgt.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService{

    private ICartDao dao;

    public ICartDao getDao() {
        return dao;
    }

    @Autowired
    public void setDao(ICartDao dao) {
        this.dao = dao;
    }

    @Override
    public List<CartItem> fetchCartItems(int userId) {
        List<CartItem> items = dao.fetchCartItems(userId);
        return items;
    }

    @Override
    public CartItem save(CartItem item) {
        return dao.save(item);
    }
}
