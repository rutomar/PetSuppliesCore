
package com.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.domain.User;
import com.core.repository.UserJPARepository;

@Service
public class UserAccountService
{
   @Autowired
   UserJPARepository jpaRepository;

   public List<User> findAllUsers()
   {
      return jpaRepository.findAll();
   }

   public boolean createUserAccount(User user)
   {
      if (user.equals(findUserById(user.getUserId())))
         return false;
      else
         jpaRepository.saveAndFlush(user);
      return true;
   }

   public User loginUser(String userId, String password)
   {
      User user = findUserById(userId);
      if (user != null && userId.equals(user.getUserId()) && password.equals(user.getPassword()))
      {
         return user;
      }
      return new User();
   }

   public User findUserById(String userId)
   {
      return jpaRepository.findOne(userId);
   }

   public User updateUser(User user)
   {
      return jpaRepository.save(user);
   }

   public boolean isUserExisting(String userId)
   {
      if (findUserById(userId) != null)
         return true;
      return false;
   }

}
