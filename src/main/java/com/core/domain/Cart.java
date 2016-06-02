package com.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CART")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart implements Serializable
{

   /** * indicates/is used for. */

   private static final long serialVersionUID = 7038455126014472972L;

   @Column
   @Id
   private String userProdCode;

   @Column
   private String userId;

   @Column
   private String productCode;

   @Column
   private String productName;

   @Column
   private double productPrice;

   @Column
   private int quantity;

   public Cart()
   {

   }

   public Cart(String userProdCode, String userId, String productCode, String productName, double productPrice, int quantity)
   {
      this.userId = userId;
      this.userProdCode = userProdCode;
      this.productCode = productCode;
      this.productName = productName;
      this.productPrice = productPrice;
      this.quantity = quantity;
   }

   public String getUserId()
   {
      return userId;
   }

   public void setUserId(String userId)
   {
      this.userId = userId;
   }

   public String getUserProdCode()
   {
      return userProdCode;
   }

   public void setUserProdCode(String userProdCode)
   {
      this.userProdCode = userProdCode;
   }

   public String getProductCode()
   {
      return productCode;
   }

   public void setProductCode(String productCode)
   {
      this.productCode = productCode;
   }

   public String getProductName()
   {
      return productName;
   }

   public double getProductPrice()
   {
      return productPrice;
   }

   public int getQuantity()
   {
      return quantity;
   }

   public void setProductName(String productName)
   {
      this.productName = productName;
   }

   public void setProductPrice(double productPrice)
   {
      this.productPrice = productPrice;
   }

   public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((userProdCode == null) ? 0 : userProdCode.hashCode());
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
      Cart other = (Cart) obj;
      if (userProdCode == null)
      {
         if (other.userProdCode != null)
            return false;
      }
      else if (!userProdCode.equals(other.userProdCode))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "Cart [userProdCode=" + userProdCode + ", userId=" + userId + ", productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice + ", quantity=" + quantity
            + "]";
   }

}
