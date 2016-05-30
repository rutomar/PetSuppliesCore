
package com.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.domain.Product;

public interface ProductJPARepository extends JpaRepository<Product, String>
{
   public List<Product> findByCategoryCodeLike(String categoryCode);
}
