package com.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @Column
   private String userId;

   @Column
   private String address;

   @Column
   @Email
   private String emailId;

   @Column
   private String city;

   /** The user. */
   @OneToOne
   @JoinColumn(name = "userId", referencedColumnName = "userId")
   private User user;

   public Address()
   {

   }

   public Address(String userId, String address, String emailId, String city)
   {

      this.userId = userId;
      this.address = address;
      this.emailId = emailId;
      this.city = city;
   }

   public String getUserId()
   {
      return userId;
   }

   public void setUserId(String userId)
   {
      this.userId = userId;
   }

   public String getAddress()
   {
      return address;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public String getEmailId()
   {
      return emailId;
   }

   public void setEmailId(String emailId)
   {
      this.emailId = emailId;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((address == null) ? 0 : address.hashCode());
      result = prime * result + ((city == null) ? 0 : city.hashCode());
      result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
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
      Address other = (Address) obj;
      if (address == null)
      {
         if (other.address != null)
            return false;
      }
      else if (!address.equals(other.address))
         return false;
      if (city == null)
      {
         if (other.city != null)
            return false;
      }
      else if (!city.equals(other.city))
         return false;
      if (emailId == null)
      {
         if (other.emailId != null)
            return false;
      }
      else if (!emailId.equals(other.emailId))
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
      return "Address [userId=" + userId + ", address=" + address + ", emailId=" + emailId + ", city=" + city + "]";
   }

}
