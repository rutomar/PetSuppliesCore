
package com.core.controllers;

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

   @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
   public boolean addCategory(@RequestBody Category category, BindingResult errors)
   {
      if (errors.hasErrors())
         return false;

      return (categoryService.addCategory(category) != null) ? true : false;
   }

   @RequestMapping(value = "/updateCategory", method = RequestMethod.PUT)
   public boolean updateCategory(@RequestBody Category category, BindingResult errors)
   {
      if (errors.hasErrors())
         return false;

      return (categoryService.updateCategory(category) != null) ? true : false;
   }

   @RequestMapping(value = "/deleteCategory/{categoryCode}", method = RequestMethod.DELETE)
   public boolean deleteCategory(@PathVariable String categoryCode)
   {
      if (!categoryCode.isEmpty())
      {
         categoryService.deleteCategory(categoryCode);
         return true;
      }
      return false;
   }

   @RequestMapping(value = "/getCategory/{categoryCode}", method = RequestMethod.GET)
   public Category getCategory(@PathVariable String categoryCode)
   {
      if (!categoryCode.isEmpty())
      {
         return categoryService.getCategory(categoryCode);
      }
      return new Category();
   }
}
