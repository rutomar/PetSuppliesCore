
package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.domain.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, String>
{

}
