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
      List<Cart> cartfetched = cartService.getAllCartItemsByUserId("rutomar");
      Assert.assertTrue(cartfetched.get(0).equals(cart));
      Assert.assertEquals(1, cartService.getAllCartItemsByUserId("rutomar").size());

      cartfetched.get(0).setQuantity(10);
      cartService.addToCart(cartfetched.get(0));
      Assert.assertEquals(cart.getQuantity() + 1, cartService.getAllCartItemsByUserId("rutomar").get(0).getQuantity());
   }

   @Test
   public void testUpdateCart()
   {
      List<Cart> cartfetched = cartService.getAllCartItemsByUserId("rutomar");
      cartfetched.get(0).setUserId("stomar");
      Assert.assertNotNull(cartService.updateCart(cartfetched.get(0)));
      Assert.assertEquals(1, cartService.getAllCartItemsByUserId("stomar").size());
      cartfetched.get(0).setUserId("rtomar");
      Assert.assertNotNull(cartService.updateCart(cartfetched.get(0)));
   }

   @Test
   public void testRemoveFromCart()
   {
      cartService.removeFromCart(cart.getUserId() + cart.getProductCode());

   }

}
