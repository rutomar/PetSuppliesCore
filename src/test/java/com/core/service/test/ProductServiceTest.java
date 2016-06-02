package com.core.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.core.domain.Product;
import com.core.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest extends GenericServiceConfigTest
{

   @Autowired
   private ProductService productService;

   private Product product;

   @Before
   public void setUp()
   {
      product = new Product("DoggyFood", "Doggy Food", "Doggy Food", 145, "PetFood", null, null);

   }

   @Test
   public void testAddProduct()
   {
      Product testProduct = productService.addProduct(product);
      Assert.assertTrue(testProduct.equals(product));
   }

   @Test
   public void testUpdateProduct()
   {
      product.setCategoryCode("Dog");
      Product testProduct = productService.updateProduct(product);
      Assert.assertTrue(testProduct.equals(product));
      Assert.assertTrue(testProduct.getCategoryCode().equals(product.getCategoryCode()));
   }

   @Test
   public void testFindAllProducts()
   {

      Assert.assertNotEquals(0, productService.getAllProducts());

   }

   @Test
   public void testGetProduct()
   {

      Assert.assertNotNull(productService.getProduct(product.getProductCode()));

   }

   @Test
   public void testGetProductByProductName()
   {

      Assert.assertNotNull(productService.getProductsByProductName(product.getProductName()));

   }

   @Test
   public void testGetProductByProductCategory()
   {

      Assert.assertNotNull(productService.getProductsByCategory(product.getCategoryCode()));

   }

   @Test
   public void testRemoveProduct()
   {
      productService.deleteProduct(product.getProductCode());
      Assert.assertNull(productService.getProduct(product.getProductCode()));
   }

}
