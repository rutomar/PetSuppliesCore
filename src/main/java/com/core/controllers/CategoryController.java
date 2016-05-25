
package com.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.Category;
import com.core.service.CategoryService;

@RestController
public class CategoryController
{
   @Autowired
   CategoryService categoryService;

   @RequestMapping(value = "/category", method = RequestMethod.POST)
   public boolean addCategory(@RequestBody Category category, BindingResult errors)
   {
      if (errors.hasErrors())
         return false;
      System.out.println("Adding Category" + category);
      return (categoryService.addCategory(category) != null) ? true : false;
   }

   @RequestMapping(value = "/category", method = RequestMethod.PUT)
   public boolean updateCategory(@RequestBody Category category, BindingResult errors)
   {
      if (errors.hasErrors())
         return false;
      System.out.println("Updating Category" + category);

      return (categoryService.updateCategory(category) != null) ? true : false;
   }

   @RequestMapping(value = "/category/{categoryCode}", method = RequestMethod.DELETE)
   public boolean deleteCategory(@PathVariable String categoryCode)
   {
      if (!categoryCode.isEmpty())
      {
         categoryService.deleteCategory(categoryCode);
         return true;
      }
      return false;
   }

   @RequestMapping(value = "/category/{categoryCode}", method = RequestMethod.GET)
   public Category getCategory(@PathVariable String categoryCode)
   {

      System.out.println("Getting Category with CatCode" + categoryCode);
      return categoryService.getCategory(categoryCode);

   }

   @RequestMapping(value = "/category", method = RequestMethod.GET)
   public List<Category> getCategories()
   {
      System.out.println("Getting Categories");
      return categoryService.getAllcategories();

   }
}
