package com.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PRODUCTORDER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOrder implements Serializable
{

   private static final long serialVersionUID = -5379682022519217001L;

   @Id
   @Column
   private String orderId;

   @Column
   private String userId;

   @Column
   private double totalPrice;

   @Column
   private int quantity;

   @Column
   private String productCode;

   @Column
   private String status;

   public ProductOrder()
   {

   }

   public ProductOrder(String orderId, String userId, double totalPrice, int quantity, String productCode, String status)
   {

      this.orderId = orderId;
      this.userId = userId;
      this.totalPrice = totalPrice;
      this.quantity = quantity;
      this.productCode = productCode;
      this.status = status;
   }

   public int getQuantity()
   {
      return quantity;
   }

   public String getProductCode()
   {
      return productCode;
   }

   public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }

   public void setProductCode(String productCode)
   {
      this.productCode = productCode;
   }

   public String getUserId()
   {
      return userId;
   }

   public void setUserId(String userId)
   {
      this.userId = userId;
   }

   public String getOrderId()
   {
      return orderId;
   }

   public void setOrderId(String orderId)
   {
      this.orderId = orderId;
   }

   public double getTotalPrice()
   {
      return totalPrice;
   }

   public void setTotalPrice(double totalPrice)
   {
      this.totalPrice = totalPrice;
   }

   public String getStatus()
   {
      return status;
   }

   public void setStatus(String status)
   {
      this.status = status;
   }

   @Override
   public String toString()
   {
      return "Order [orderId=" + orderId + ", userId=" + userId + ", totalPrice=" + totalPrice + ", quantity=" + quantity + ", productCode=" + productCode + ", status=" + status + "]";
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ProductOrder other = (ProductOrder) obj;
      if (orderId == null)
      {
         if (other.orderId != null)
            return false;
      }
      else if (!orderId.equals(other.orderId))
         return false;
      return true;
   }

}
