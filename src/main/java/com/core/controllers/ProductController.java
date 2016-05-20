
package com.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.Product;
import com.core.service.ProductService;

@RestController
public class ProductController
{
   @Autowired
   ProductService productService;

   @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
   public List<Product> getProducts()
   {
      return productService.getAllProducts();
   }

   @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
   public boolean addProduct(@RequestBody Product product, BindingResult errors)
   {
      if (errors.hasErrors())
         return false;

      return (productService.addProduct(product) != null) ? true : false;
   }

   @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
   public boolean updateProduct(@RequestBody Product product, BindingResult errors)
   {
      if (errors.hasErrors())
         return false;

      return (productService.updateProduct(product) != null ? true : false);
   }

   @RequestMapping(value = "/deleteProduct/{productCode}", method = RequestMethod.DELETE)
   public boolean deleteProduct(@PathVariable String productCode)
   {
      if (!productCode.isEmpty())
      {
         productService.deleteProduct(productCode);
         return true;
      }
      return false;
   }

   @RequestMapping(value = "/getProduct/{productCode}", method = RequestMethod.GET)
   public Product getProduct(@PathVariable String productCode)
   {
      if (!productCode.isEmpty())
      {
         return productService.getProduct(productCode);
      }
      return new Product();
   }

}
