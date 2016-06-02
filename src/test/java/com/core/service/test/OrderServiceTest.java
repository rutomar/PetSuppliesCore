package com.core.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.core.domain.Cart;
import com.core.domain.ProductOrder;
import com.core.service.CartService;
import com.core.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest extends GenericServiceConfigTest
{

   @Autowired
   private OrderService orderService;

   @Autowired
   private CartService cartService;

   private ProductOrder order;
   private Cart cart;

   @Before
   public void setup()
   {
      order = new ProductOrder("", "rutomar", 5983, 2, "DogFood", "ORDERED");
      cart = new Cart("rutomarDogFood", "rutomar", "DogFood", "Dog Food", 6267, 1);
      cartService.addToCart(cart);
   }

   @Test
   public void testProductOrderService()
   {
      ProductOrder testOrder = orderService.addOrder(order);
      Assert.assertTrue(testOrder.equals(order));
      order.setOrderId(testOrder.getOrderId());

      Assert.assertNotNull(testOrder.getOrderId());
      Assert.assertNotNull(orderService.getOrder(testOrder.getOrderId()));

      testOrder = orderService.updateOrder(testOrder.getOrderId(), "SHIPPED");

      Assert.assertEquals(testOrder.getStatus(), "SHIPPED");

      Assert.assertNotEquals(orderService.getAllOrders().size(), 0);

      Assert.assertNotNull(orderService.getOrderByOrderIdOrUserId("", "rutomar"));

      Assert.assertNotNull(orderService.getOrderByUserId("rutomar"));

      orderService.deleteOrder(testOrder.getOrderId());
      Assert.assertNull(orderService.getOrder(testOrder.getOrderId()));
   }

}
