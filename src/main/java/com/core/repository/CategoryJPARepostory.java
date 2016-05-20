
package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.domain.Category;

public interface CategoryJPARepostory extends JpaRepository<Category, String>
{

}
