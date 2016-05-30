
package com.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartPK implements Serializable
{

   /** * indicates/is used for. */

   private static final long serialVersionUID = -7557142766517982312L;

   @Column(name = "USERID", nullable = false)
   private String userId;

   @Column(name = "PRODUCTCODE", nullable = false)
   private String productCode;

   @Override
   public String toString()
   {
      return "CartPK [userId=" + userId + ", productCode=" + productCode + "]";
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
      result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
      CartPK other = (CartPK) obj;
      if (productCode == null)
      {
         if (other.productCode != null)
            return false;
      }
      else if (!productCode.equals(other.productCode))
         return false;
      if (userId == null)
      {
         if (other.userId != null)
            return false;
      }
      else if (!userId.equals(other.userId))
         return false;
      return true;
   }

   public String getUserId()
   {
      return userId;
   }

   public String getProductCode()
   {
      return productCode;
   }

   public void setUserId(String userId)
   {
      this.userId = userId;
   }

   public void setProductCode(String productCode)
   {
      this.productCode = productCode;
   }

   public CartPK()
   {

   }

   public CartPK(String userId, String productCode)
   {

      this.userId = userId;
      this.productCode = productCode;
   }
}
