package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examportal.model.User;
import com.examportal.model.UserIdentity;

@Repository
public interface UserRepository extends JpaRepository<User, UserIdentity> {

	@Query("SELECT u FROM User u WHERE u.userIdentity.user_Id = :user_Id")
	public User findByUser_Id(long user_Id);

//
//	 @Query("SELECT u FROM User u WHERE u.username = :username")
//   public User getUserByUsername(@Param("username") String username);
	
//	 public User findByUserIdentityUser_Id(long user_Id);
//	
	@Query("SELECT u FROM User u WHERE u.userIdentity.user_Name = :user_Name")
	 public User findByUser_Name(String user_Name); 
	 
	@Query("delete from User u where u.userIdentity.user_Id = :user_Id")
	 public User deleteByUser_Id(long user_Id);

}
