package com.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.core.domain.User;
import com.core.service.UserAccountService;

@RestController
public class UserAccountController
{
   @Autowired
   UserAccountService userAccountService;

   @RequestMapping(value = "/user", method = RequestMethod.POST)
   public boolean createUser(@RequestBody User user, BindingResult errors)
   {
      System.out.println("NewUserAccount to be created for " + user);

      if (errors.hasErrors())
         return false;

      return (userAccountService.createUserAccount(user));
   }

   @RequestMapping(value = "/loginUser/{userId}/{password}", method = RequestMethod.GET)
   public User loginUser(@PathVariable String userId, @PathVariable String password)
   {
      User user = userAccountService.loginUser(userId, password);
      System.out.println("User Logging in " + user);
      return user;
   }

   @RequestMapping(value = "/validateUser/{userId}", method = RequestMethod.GET)
   public boolean validateUserId(@PathVariable String userId)
   {
      return userAccountService.isUserExisting(userId);

   }

   @RequestMapping(value = "/user", method = RequestMethod.PUT)
   public boolean updateUser(@RequestBody User user, BindingResult errors)
   {
      System.out.println("UpdatingUser Account" + user);

      if (errors.hasErrors())
         return false;

      return (userAccountService.updateUser(user) != null ? true : false);
   }

   @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
   public boolean deleteUser(@PathVariable String userId)
   {
      if (!userId.isEmpty())
      {
         System.out.println("Deleting user");
         userAccountService.deleteUser(userId);
         return true;
      }
      return false;
   }

   @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
   public User getUser(@PathVariable String userId)
   {

      return userAccountService.findUserById(userId);

   }

   @RequestMapping(value = "/user", method = RequestMethod.GET)
   public List<User> getUsers()
   {
      return userAccountService.findAllUsers();
   }

}
