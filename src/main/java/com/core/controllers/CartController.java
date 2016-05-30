package com.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.Cart;
import com.core.service.CartService;

@RestController
public class CartController
{

   @Autowired
   CartService cartService;

   @RequestMapping(value = "/cart", method = RequestMethod.POST)
   public Cart addToCart(@RequestBody Cart cart)
   {
      System.out.println("Inside Add to cart " + cart);
      return cartService.addToCart(cart);
   }

   @RequestMapping(value = "/cart/{userId}", method = RequestMethod.GET)
   public List<Cart> getCartItems(@PathVariable String userId)
   {
      System.out.println("fetching records for user " + userId);
      return cartService.getAllCartItemsByUserId(userId);
   }

   @RequestMapping(value = "/cart", method = RequestMethod.DELETE)
   public boolean removeFromCart(@RequestParam String userId, @RequestParam String productCode)
   {

      System.out.println("removing item " + productCode);
      cartService.removeFromCart(userId, productCode);
      return true;
   }
}
