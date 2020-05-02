package com.cg.ecommerce.itemmgt.controller;

import com.cg.ecommerce.itemmgt.dto.AddCartItemDto;
import com.cg.ecommerce.itemmgt.dto.CartItemDetailsDto;
import com.cg.ecommerce.itemmgt.dto.ProductDto;
import com.cg.ecommerce.itemmgt.entities.CartItem;
import com.cg.ecommerce.itemmgt.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/cartItems")
public class CartController {

    @Autowired
    private ICartService service;

    @Value("${productservice.baseurl}")
    private String productServiceBaseUrl;

    @Autowired
    RestTemplate restTemplate;

    public String getProductServiceBaseUrl() {
        return productServiceBaseUrl;
    }

    public void setProductServiceBaseUrl(String productServiceBaseUrl) {
        this.productServiceBaseUrl = productServiceBaseUrl;
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addCartItem(@RequestBody AddCartItemDto dto){
        CartItem cartItem = new CartItem();
        cartItem.setProductId(dto.getProductId());
        cartItem.setUserId(dto.getUserId());
        cartItem = service.save(cartItem);
        ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
        return  response;
    }

    @GetMapping("/cartDetails/{userId}")
    public ResponseEntity<List<CartItemDetailsDto>>cartDetails(@PathVariable("userId")int userId){
        List<CartItem> cartItems = service.fetchCartItems(userId);
        List<CartItemDetailsDto> desiredDtos = new ArrayList<>();

        for(CartItem item: cartItems){
            ProductDto productDto = fetchProductById(item.getProductId());
            CartItemDetailsDto dto = cartItemDetailsDto(item,productDto);
            desiredDtos.add(dto);
        }
        ResponseEntity<List<CartItemDetailsDto>>response = new ResponseEntity<>(desiredDtos,HttpStatus.OK);
        return response;
    }

    public ProductDto fetchProductById(String id){
        String url = productServiceBaseUrl+"/get/"+id;
        ProductDto dto =restTemplate.getForObject(url, ProductDto.class);
        return dto;
    }

    public CartItemDetailsDto cartItemDetailsDto(CartItem item, ProductDto productDto){
        CartItemDetailsDto cartItemDetailsDto = new CartItemDetailsDto();
        cartItemDetailsDto.setProductPrice(productDto.getProductPrice());
        cartItemDetailsDto.setProductId(item.getProductId());
        cartItemDetailsDto.setProductName(productDto.getProductName());
        return cartItemDetailsDto;
    }

}
