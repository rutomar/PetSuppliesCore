
package com.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.core.domain.ProductOrder;

public interface OrderJPARepostory extends JpaRepository<ProductOrder, String>
{
   public List<ProductOrder> findByOrderIdOrUserId(@Param("orderId") String orderId, @Param("userId") String userId);
}
