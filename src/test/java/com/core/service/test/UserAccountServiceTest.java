package com.core.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.core.domain.Address;
import com.core.domain.User;
import com.core.repository.UserJPARepository;
import com.core.service.UserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserAccountServiceTest extends GenericServiceConfigTest
{

   @Autowired
   private UserAccountService userService;

   @Autowired
   private UserJPARepository repository;

   private User testUser;

   @Before
   public void setup()
   {
      testUser = new User("testUser", "Test", "Test", "USER", new Address("testUser", "Nacy Avenue", "test.user@xyz.com", "Newyork"));

   }

   @Test
   public void testSave()
   {

      Assert.assertTrue(userService.createUserAccount(testUser));
   }

   @Test
   public void testFindOneUser()
   {
      User user = userService.findUserById("testUser");
      Assert.assertNotNull(user);
      Assert.assertEquals("testUser", user.getUserId());

      Assert.assertTrue(userService.isUserExisting("testUser"));
      Assert.assertFalse(userService.isUserExisting("test"));
   }

   @Test
   public void testLoginUser()
   {
      User user = userService.loginUser(testUser.getUserId(), testUser.getPassword());
      Assert.assertNotNull(user);
      Assert.assertEquals("testUser", user.getUserId());
      Assert.assertEquals("Test", user.getPassword());
   }

   @Test
   public void testLoginUserNegative()
   {
      User user = userService.loginUser("Ashok", testUser.getPassword());
      Assert.assertNull(user);

   }

   @Test
   public void testUpdateUser()
   {
      testUser.setUserName("Taruna");
      User user = userService.updateUser(testUser);
      Assert.assertNotNull(user);
      Assert.assertEquals("Taruna", user.getUserName());
      testUser.setUserName("Ruchi");
      userService.updateUser(testUser);
   }

   @Test
   public void testFindAllUsers()
   {
      Assert.assertNotEquals(0, userService.findAllUsers().size());
   }

   @Test
   public void testDeleteUser()
   {
      userService.deleteUser("testUser");
   }

}
