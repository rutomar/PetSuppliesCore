package com.core.controllers;

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
   UserAccountService service;

   @RequestMapping(value = "/newUserAccount", method = RequestMethod.POST)
   public boolean createUser(@RequestBody User user, BindingResult errors)
   {
      System.out.println("NewUserAccount to be created for " + user);

      if (errors.hasErrors())
         return false;

      return (service.createUserAccount(user));
   }

   @RequestMapping(value = "/loginUser/{userId}/{password}", method = RequestMethod.GET)
   public User loginUser(@PathVariable String userId, @PathVariable String password)
   {
      User user = service.loginUser(userId, password);
      System.out.println("User Logging in " + user);
      return user;
   }

   @RequestMapping(value = "/validateUser/{userId}", method = RequestMethod.GET)
   public boolean validateUserId(@PathVariable String userId)
   {
      return service.isUserExisting(userId);

   }

}
