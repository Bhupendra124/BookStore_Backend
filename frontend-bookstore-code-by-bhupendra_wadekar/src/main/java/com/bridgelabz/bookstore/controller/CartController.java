package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartServiceDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    ICartService cartService;

    @PostMapping("/add")
    ResponseEntity<ResponseDTO> addToCart(@RequestBody CartServiceDTO cartDTO){

        return new ResponseEntity<>(new ResponseDTO("Post call success",
                cartService.addCart(cartDTO)), HttpStatus.OK);
    }

    @GetMapping("/get/{token}")
    ResponseEntity<ResponseDTO> findAllCartsByUser(@PathVariable("token") String token){
        return new ResponseEntity<>(new ResponseDTO("Get call success",
                cartService.findAllCarts(token)), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{cartId}")
    ResponseEntity<ResponseDTO> removeFromCart(@PathVariable("cartId") Long cartId){
        cartService.removeFromCart(cartId);
        return new ResponseEntity<>(new ResponseDTO("Delete call success", ""), HttpStatus.OK);
    }

    @PutMapping("/update/{token}")
    ResponseEntity<ResponseDTO> updateCart(@PathVariable("token") String token, @RequestParam("cartId")Long cartId,
                                           @RequestParam("quantity") Long quantity){
        cartService.updateQuantity(token, cartId, quantity);
        return new ResponseEntity<>(new ResponseDTO("Post call success",
                ""), HttpStatus.OK);
    }
}
