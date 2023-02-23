package com.alisnobba.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alisnobba.shoppingcart.model.Cart;



import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ShoppingcartApplicationTests {

	
    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testConstructor() {
        Long id = 1L;
        Double price = 10.0;
        Double prdQtn = 2.0;
        Double totalPrice = 20.0;
        Cart cart = new Cart(id, price, prdQtn, totalPrice);
        assertEquals(id, cart.getId());
        assertEquals(price, cart.getPrice());
        assertEquals(prdQtn, cart.getPrdQtn());
        assertEquals(totalPrice, cart.getTotalPrice());
    }

    @Test
    public void testId() {
        Long id = 1L;
        cart.setId(id);
        assertEquals(id, cart.getId());
    }

    @Test
    public void testPrice() {
        Double price = 10.0;
        cart.setPrice(price);
        assertEquals(price, cart.getPrice());
    }

    @Test
    public void testPrdQtn() {
        Double prdQtn = 2.0;
        cart.setPrdQtn(prdQtn);
        assertEquals(prdQtn, cart.getPrdQtn());
    }

    @Test
    public void testTotalPrice() {
        Double totalPrice = 20.0;
        cart.setTotalPrice(totalPrice);
        assertEquals(totalPrice, cart.getTotalPrice());
    }

}








