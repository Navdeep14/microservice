package com.cg.ecommerce.itemmgt.service;

import com.cg.ecommerce.itemmgt.entities.CartItem;

import java.util.List;

public interface ICartService {
    List<CartItem> fetchCartItems(int userId);

    CartItem save(CartItem item);
}
