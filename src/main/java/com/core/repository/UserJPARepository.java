
package com.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.domain.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, String>
{
   public List<User> findByRole(String role);

}
