
package com.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.domain.Category;
import com.core.repository.CategoryJPARepostory;

@Service
public class CategoryService extends GenericServiceImpl
{
   @Autowired
   CategoryJPARepostory repository;

   public Category addCategory(Category category)
   {
      return repository.saveAndFlush(category);
   }

   public void deleteCategory(String categoryCode)
   {
      Category category = repository.getOne(categoryCode);
      repository.delete(category);
   }

   public Category updateCategory(Category category)
   {
      return repository.save(category);
   }

   public List<Category> getAllcategories()
   {
      return repository.findAll();

   }

   public Category getCategory(String catCode)
   {
      return repository.findOne(catCode);

   }

}
