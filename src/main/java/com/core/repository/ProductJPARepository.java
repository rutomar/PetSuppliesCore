
package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.domain.Product;

public interface ProductJPARepository extends JpaRepository<Product, String>
{

}
