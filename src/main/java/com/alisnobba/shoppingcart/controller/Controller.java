package com.alisnobba.shoppingcart.controller;

import com.alisnobba.shoppingcart.model.Cart;
import com.alisnobba.shoppingcart.repository.Irepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cart")
public class Controller {

    @Autowired
    private Irepo repo;

    @PostMapping("")
    public ResponseEntity<Cart> create(@RequestBody Cart product) {
        Cart productCreated = repo.save(product);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Cart> getAllProducts() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete() {

        repo.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
