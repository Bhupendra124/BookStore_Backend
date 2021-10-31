package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartServiceDTO;
import com.bridgelabz.bookstore.entity.Cart;

import java.util.List;

public interface ICartService {

    Cart addCart(CartServiceDTO carServiceDTO);

    void removeFromCart(Long cart_id);
    void removeAllCarts(String token);

    void updateQuantity(String token, Long cart_id, Long quantity);

    List<Cart> findAllCarts(String token);
}
