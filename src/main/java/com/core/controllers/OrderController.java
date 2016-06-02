package com.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.ProductOrder;
import com.core.service.OrderService;

@RestController
public class OrderController
{

   @Autowired
   OrderService orderService;

   @RequestMapping(value = "/order", method = RequestMethod.POST)
   public ProductOrder placeOrder(@RequestBody ProductOrder order)
   {
      System.out.println("placing order " + order);
      return orderService.addOrder(order);
   }

   @RequestMapping(value = "/order/{userId}", method = RequestMethod.GET)
   public List<ProductOrder> getOrderByUserId(@PathVariable String userId)
   {
      System.out.println("orderService.getOrderByUserId(userId)" + orderService.getOrderByUserId(userId));
      return orderService.getOrderByUserId(userId);
   }

   @RequestMapping(value = "/order", method = RequestMethod.GET)
   public List<ProductOrder> getAllOrders()
   {
      System.out.println(orderService.getAllOrders().size());
      return orderService.getAllOrders();
   }

   @RequestMapping(value = "/order/{orderId}/{status}", method = RequestMethod.PUT)
   public ProductOrder updateOrder(@PathVariable String orderId, @PathVariable String status)
   {
      return orderService.updateOrder(orderId, status);
   }

   @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
   public Boolean deleteOrder(@PathVariable String orderId)
   {

      if (!orderId.isEmpty())
      {
         System.out.println("Deleting order");
         orderService.deleteOrder(orderId);
         return true;
      }
      return false;
   }
}
