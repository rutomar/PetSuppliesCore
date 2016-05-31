package com.core.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.core.domain.Cart;
import com.core.service.CartService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartServiceTest extends GenericServiceConfigTest
{

   @Autowired
   private CartService cartService;

   private Cart cart;

   @Before
   public void setup()
   {
      cart = new Cart("rutomarsrwqwr", "rutomar", "srwqwr", "BABABBA", 6267, 1);

   }

   @Test
   public void testSave()
   {

      Assert.assertNotNull(cartService.addToCart(cart));
   }

   @Test
   public void testFindByUserId()
   {
      List<Cart> cart = cartService.getAllCartItemsByUserId("rutomar");
      Assert.assertNotNull(cart);
      Assert.assertEquals(1, cart.size());
   }

   @Test
   public void testRemoveFromCart()
   {
      cartService.removeFromCart(cart.getUserId() + cart.getProductCode());

   }

}
