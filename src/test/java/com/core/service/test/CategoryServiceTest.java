package com.core.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.core.domain.Category;
import com.core.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest extends GenericServiceConfigTest
{

   @Autowired
   private CategoryService categoryService;

   private Category category;

   @Before
   public void setUp()
   {
      category = new Category("Toys", "Pet Toys");
   }

   @Test
   public void testAddCategory()
   {
      Category testCat = categoryService.addCategory(category);
      Assert.assertTrue(testCat.equals(category));
   }

   @Test
   public void testUpdateCategory()
   {
      category.setCategoryCode("FishToys");
      category.setCategoryName("Fish Toys");
      Category testCategory = categoryService.updateCategory(category);
      Assert.assertTrue(testCategory.equals(category));
   }

   @Test
   public void testGetCategory()
   {

      Assert.assertNotNull(categoryService.getCategory(category.getCategoryCode()));
   }

   @Test
   public void testGetAllCategory()
   {

      Assert.assertNotEquals(0, categoryService.getAllcategories());
   }

   @Test
   public void testRemoveCategory()
   {
      categoryService.deleteCategory(category.getCategoryCode());
      Assert.assertNull(categoryService.getCategory(category.getCategoryCode()));
   }

}
