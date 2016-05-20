
package com.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.domain.ProductOrder;
import com.core.repository.OrderJPARepostory;

@Service
public class OrderService extends GenericServiceImpl
{
   @Autowired
   OrderJPARepostory repository;

   public void addOrder(ProductOrder order)
   {
      repository.saveAndFlush(order);
   }

   public void deleteOrder(ProductOrder order)
   {
      repository.delete(order);
   }

   public ProductOrder updateOrder(ProductOrder order)
   {
      return repository.save(order);
   }

   public List<ProductOrder> getAllOrders(String userId)
   {
      return repository.findAll();

   }

   public ProductOrder getOrder(String orderId)
   {
      return repository.findOne(orderId);

   }

   public List<ProductOrder> getOrderByOrderIdOrUserId(String orderId, String userId)
   {
      return repository.findByOrderIdOrUserId(orderId, userId);

   }

}
