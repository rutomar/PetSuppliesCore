package com.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CATEGORY")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Serializable
{

   /** * indicates/is used for. */

   private static final long serialVersionUID = -6334158547364912427L;

   @Id
   @Column
   private String categoryCode;

   @Column
   private String categoryName;

   @OneToOne
   @JoinColumn(name = "categoryCode", referencedColumnName = "categoryCode")
   private Product product;

   public Category()
   {

   }

   public Category(String categoryCode, String categoryName)
   {

      this.categoryCode = categoryCode;
      this.categoryName = categoryName;
   }

   public String getCategoryCode()
   {
      return categoryCode;
   }

   public void setCategoryCode(String categoryCode)
   {
      this.categoryCode = categoryCode;
   }

   public String getCategoryName()
   {
      return categoryName;
   }

   public void setCategoryName(String categoryName)
   {
      this.categoryName = categoryName;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((categoryCode == null) ? 0 : categoryCode.hashCode());
      result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
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
      Category other = (Category) obj;
      if (categoryCode == null)
      {
         if (other.categoryCode != null)
            return false;
      }
      else if (!categoryCode.equals(other.categoryCode))
         return false;
      if (categoryName == null)
      {
         if (other.categoryName != null)
            return false;
      }
      else if (!categoryName.equals(other.categoryName))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "Category [categoryCode=" + categoryCode + ", categoryName=" + categoryName + "]";
   }

}
