package com.cg.ecommerce.itemmgt.dao;

import com.cg.ecommerce.itemmgt.entities.CartItem;
import java.util.List;
public interface ICartDao {
    List<CartItem> fetchCartItems(int userId);

    CartItem save(CartItem item);
}
