
package com.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.domain.Cart;
import com.core.repository.CartJPARepository;

@Service
public class CartService
{

   @Autowired
   CartJPARepository cartJPARepository;

   public Cart addToCart(Cart cart)
   {
      Cart cartItem = cartJPARepository.findOne(cart.getUserProdCode());
      //  Cart cartItem = cartJPARepository.findOne(cart.getCartPK());
      System.out.println("addnig item" + cartItem);
      if (cartItem != null)
      {
         System.out.println("updating quantity");
         cartItem.setQuantity((cartItem.getQuantity() + 1));
         return cartJPARepository.save(cartItem);
      }

      System.out.println("addnig item" + cart);
      return cartJPARepository.saveAndFlush(cart);
   }

   public List<Cart> getAllCartItemsByUserId(String userId)
   {
      System.out.println("Getting all the cartItems " + cartJPARepository.findByUserId(userId));
      return cartJPARepository.findByUserId(userId);
   }

   public void removeFromCart(String userProdCode)
   {
      cartJPARepository.delete(userProdCode);
   }

   public Cart updateCart(Cart cart)
   {
      return cartJPARepository.save(cart);
   }

}
