package com.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PRODUCT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable
{

   /** * indicates/is used for. */

   private static final long serialVersionUID = -7243759586268757312L;

   @Id
   @Column
   private String productCode;

   @Column
   private String productName;

   @Column
   private String productDesc;

   @Column
   private double productPrice;

   @Column
   private String categoryCode;

   @Lob
   @Column
   private byte[] image;

   @Transient
   private CommonsMultipartFile file;

   public Product()
   {

   }

   public Product(String productCode, String productName, String productDesc, double productPrice, String categoryCode, byte[] image, CommonsMultipartFile file)
   {

      this.productCode = productCode;
      this.productName = productName;
      this.productDesc = productDesc;
      this.productPrice = productPrice;
      this.categoryCode = categoryCode;
      this.file = file;
      this.image = image;

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

   public void setProductName(String productName)
   {
      this.productName = productName;
   }

   public String getProductDesc()
   {
      return productDesc;
   }

   public void setProductDesc(String productDesc)
   {
      this.productDesc = productDesc;
   }

   public double getProductPrice()
   {
      return productPrice;
   }

   public void setProductPrice(double productPrice)
   {
      this.productPrice = productPrice;
   }

   public String getCategoryCode()
   {
      return categoryCode;
   }

   public void setCategoryCode(String categoryCode)
   {
      this.categoryCode = categoryCode;
   }

   public byte[] getImage()
   {
      return image;
   }

   public void setImage(byte[] image)
   {
      this.image = image;
   }

   public CommonsMultipartFile getFile()
   {
      return file;
   }

   public void setFile(CommonsMultipartFile file)
   {
      this.file = file;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
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
      Product other = (Product) obj;
      if (productCode == null)
      {
         if (other.productCode != null)
            return false;
      }
      else if (!productCode.equals(other.productCode))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "Product [productCode=" + productCode + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice=" + productPrice + ", image=" + image + ", categoryCode="
            + categoryCode + "]";
   }

}
