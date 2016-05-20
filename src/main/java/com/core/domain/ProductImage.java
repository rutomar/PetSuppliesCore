package com.core.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTIMAGE")
public class ProductImage implements Serializable
{

   private static final long serialVersionUID = -2715399875854482461L;

   @Id
   @Column
   private String productCode;

   @Lob
   private byte[] image;

   @OneToOne
   @JoinColumn(name = "productCode", referencedColumnName = "productCode")
   private Product product;

   public ProductImage()
   {

   }

   public ProductImage(String productCode, byte[] image)
   {

      this.productCode = productCode;
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

   public byte[] getImage()
   {
      return image;
   }

   public void setImage(byte[] image)
   {
      this.image = image;
   }

   @Override
   public String toString()
   {
      return "ProductImage [productCode=" + productCode + ", image=" + Arrays.toString(image) + ", product=" + product + "]";
   }

}
