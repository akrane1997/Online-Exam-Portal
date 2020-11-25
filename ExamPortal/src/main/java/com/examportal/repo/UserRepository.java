package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


	 @Query("SELECT u FROM User u WHERE u.username = :username")
   public User getUserByUsername(@Param("username") String username);

}
