
package com.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.domain.ProductOrder;
import com.core.repository.CartJPARepository;
import com.core.repository.OrderJPARepostory;

@Service
public class OrderService extends GenericServiceImpl
{
   @Autowired
   OrderJPARepostory repository;

   @Autowired
   CartJPARepository cartRepository;

   public ProductOrder addOrder(ProductOrder order)
   {

      order.setOrderId(new OrderIdGenerator().generateOrderId());
      order.setStatus("ORDERED");
      removeProductFromCart(order);
      return repository.saveAndFlush(order);
   }

   public void deleteOrder(String orderId)
   {
      repository.delete(repository.findOne(orderId));
   }

   public ProductOrder updateOrder(String orderId, String status)
   {

      ProductOrder order = repository.findOne(orderId);
      order.setStatus(status);
      return repository.save(order);
   }

   public List<ProductOrder> getAllOrders()
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

   public List<ProductOrder> getOrderByUserId(String userId)
   {
      return repository.findByUserId(userId);

   }

   private void removeProductFromCart(ProductOrder order)
   {
      cartRepository.delete(order.getUserId() + order.getProductCode());
   }

   class OrderIdGenerator
   {

      /** The Constant ELIG_ALPHA_SET. */
      private static final String ELIG_ALPHA_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      /** The Constant ORDER_ID_LENGTH. */
      private static final int ORDER_ID_LENGTH = 10;

      /**
       * Generate otp string.
       *
       * @return the string
       */
      public String generateOrderId()
      {

         StringBuilder randStr = new StringBuilder();

         for (int i = 0; i < ORDER_ID_LENGTH; i++)
         {

            int number = getSecureRandomNumber(ELIG_ALPHA_SET);
            char ch = ELIG_ALPHA_SET.charAt(number);
            randStr.append(ch);

         }

         return shuffle(randStr.toString());

      }

      /**
       * Gets the secure random number.
       *
       * @param charSet the char set
       * @return the secure random number
       */
      private int getSecureRandomNumber(String charSet)
      {

         Random randomGenerator = new Random();
         int randomInt = randomGenerator.nextInt(charSet.length());
         if (randomInt - 1 == -1)
         {
            return randomInt;
         }
         else
         {
            return randomInt - 1;
         }
      }

      /**
       * Shuffle.
       *
       * @param input the input
       * @return the string
       */
      @SuppressWarnings({ "rawtypes", "unchecked" })
      private String shuffle(String input)
      {

         List<Character> characters = new ArrayList();

         for (char c : input.toCharArray())
         {
            characters.add(c);
         }
         StringBuilder output = new StringBuilder(input.length());

         while (!characters.isEmpty())
         {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
         }

         return output.toString();
      }

   }

}
