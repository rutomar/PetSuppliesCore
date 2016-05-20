package com.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.ProductOrder;
import com.core.domain.User;
import com.core.service.OrderService;
import com.core.service.UserAccountService;

@RestController
public class AdminActivityController
{
   @Autowired
   UserAccountService userService;

   @Autowired
   OrderService orderService;

   @RequestMapping(value = "/users", method = RequestMethod.GET)
   public List<User> getUsers()
   {
      return userService.findAllUsers();
   }

   @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
   public User getUser(@PathVariable String userId)
   {
      return userService.findUserById(userId);
   }

   @RequestMapping(value = "/editUser", method = RequestMethod.POST)
   public User editUser(@RequestBody User user, BindingResult errors)
   {
      if (errors.hasErrors())
      {
         return user;
      }
      return userService.updateUser(user);
   }

   @RequestMapping(value = "/getOrders/{orderId}/{userId}", method = RequestMethod.GET)
   public List<ProductOrder> getOrders(@PathVariable String orderId, @PathVariable String userId)
   {
      return orderService.getOrderByOrderIdOrUserId(orderId, userId);
   }

   @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
   public ProductOrder editOrders(@RequestBody ProductOrder order, BindingResult result)
   {
      if (result.hasErrors())
      {
         return order;
      }
      return orderService.updateOrder(order);
   }

}
