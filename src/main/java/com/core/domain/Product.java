package com.core.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable
{

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

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "product", targetEntity = ProductImage.class)
   private ProductImage image;

   @OneToOne(mappedBy = "product", targetEntity = Category.class)
   private Category category;

   public Product()
   {

   }

   public Product(String productCode, String productName, String productDesc, double productPrice, ProductImage image)
   {

      this.productCode = productCode;
      this.productName = productName;
      this.productDesc = productDesc;
      this.productPrice = productPrice;
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

   /*
    * public ProductImage getImage() { return image; } public void setImage(ProductImage image) { this.image = image; } public Category getCategory() { return category; } public void
    * setCategory(Category category) { this.category = category; }
    */
   /*
    * @Override public String toString() { return "Product [productCode=" + productCode + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice=" + productPrice +
    * ", image=" + image + ", category=" + category + "]"; }
    */
   @Override
   public String toString()
   {
      return "Product [productCode=" + productCode + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice=" + productPrice + ", image=" + "]";
   }

}
