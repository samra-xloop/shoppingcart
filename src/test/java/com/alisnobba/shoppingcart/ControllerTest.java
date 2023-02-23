package com.alisnobba.shoppingcart;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alisnobba.shoppingcart.controller.Controller;
import com.alisnobba.shoppingcart.model.Cart;
import com.alisnobba.shoppingcart.repository.Irepo;


public class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private Irepo repo;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate() throws Exception {
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setPrice(10.0);
        cart.setPrdQtn(2.0);
        cart.setTotalPrice(20.0);

        when(repo.save(any(Cart.class))).thenReturn(cart);

        mockMvc.perform(post("/api/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"price\": 10.0, \"prdQtn\": 2.0, \"totalPrice\": 20.0}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllProducts() throws Exception {
        Cart cart1 = new Cart();
        cart1.setId(1L);
        cart1.setPrice(10.0);
        cart1.setPrdQtn(2.0);
        cart1.setTotalPrice(20.0);

        Cart cart2 = new Cart();
        cart2.setId(2L);
        cart2.setPrice(15.0);
        cart2.setPrdQtn(3.0);
        cart2.setTotalPrice(45.0);

        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart2);

        when(repo.findAll()).thenReturn(cartList);

        mockMvc.perform(get("/api/cart"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteById() throws Exception {
        doNothing().when(repo).deleteById(1L);

        mockMvc.perform(delete("/api/cart/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteAll() throws Exception {
        doNothing().when(repo).deleteAll();

        mockMvc.perform(delete("/api/cart"))
                .andExpect(status().isNoContent());
    }
}
