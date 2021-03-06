package com.core.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "USER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @Column
   private String userId;

   @Column
   private String userName;

   @Column
   private String password;

   @Column
   private String role;

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Address.class)
   private Address address;

   public User()
   {

   }

   public User(String userId, String userName, String password, String role, Address address)
   {

      this.userId = userId;
      this.userName = userName;
      this.password = password;
      this.address = address;
      this.role = role;
   }

   public String getUserId()
   {
      return userId;
   }

   public void setUserId(String userId)
   {
      this.userId = userId;
   }

   public String getUserName()
   {
      return userName;
   }

   public void setUserName(String userName)
   {
      this.userName = userName;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public Address getAddress()
   {
      return address;
   }

   public void setAddress(Address address)
   {
      this.address = address;
   }

   public String getRole()
   {
      return role;
   }

   public void setRole(String role)
   {
      this.role = role;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      result = prime * result + ((role == null) ? 0 : role.hashCode());
      result = prime * result + ((userId == null) ? 0 : userId.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      User other = (User) obj;
      if (password == null)
      {
         if (other.password != null)
            return false;
      }
      else if (!password.equals(other.password))
         return false;
      if (role == null)
      {
         if (other.role != null)
            return false;
      }
      else if (!role.equals(other.role))
         return false;
      if (userId == null)
      {
         if (other.userId != null)
            return false;
      }
      else if (!userId.equals(other.userId))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + ", address=" + address + "]";
   }

}
