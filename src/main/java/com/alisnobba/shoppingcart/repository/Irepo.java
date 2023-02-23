package com.alisnobba.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alisnobba.shoppingcart.model.Cart;

public interface Irepo extends JpaRepository<Cart, Long> {
    
}
