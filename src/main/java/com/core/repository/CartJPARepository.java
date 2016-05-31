package com.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.domain.Cart;

public interface CartJPARepository extends JpaRepository<Cart, String>
{

   public Cart findByUserProdCodeAndProductCode(String userId, String productCode);

   //pass only userID
   public List<Cart> findByUserId(String userId);

}
