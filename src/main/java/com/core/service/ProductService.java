
package com.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.domain.Product;
import com.core.repository.ProductJPARepository;

@Service
public class ProductService extends GenericServiceImpl
{
   @Autowired
   ProductJPARepository repository;

   public Product addProduct(Product product)
   {

      System.out.println(product);
      return repository.saveAndFlush(product);
   }

   public void deleteProduct(String productCode)
   {
      //Product product = ;
      repository.delete(repository.findOne(productCode));
   }

   public Product updateProduct(Product product)
   {
      return repository.save(product);
   }

   public List<Product> getAllProducts()
   {
      return repository.findAll();

   }

   public Product getProduct(String prodCode)
   {
      return repository.findOne(prodCode);

   }

   public List<Product> getProductsByProductName(String prodName)
   {
      return repository.findByProductNameContaining(prodName);

   }

   public List<Product> getProductsByCategory(String categoryCode)
   {
      return repository.findByCategoryCodeLike(categoryCode);
   }

}
