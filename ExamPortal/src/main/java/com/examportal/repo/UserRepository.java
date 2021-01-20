package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examportal.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.role = 'ROLE_SUPER_ADMIN'")
	 List <User> findByUserBySuperRole();

//
//	 @Query("SELECT u FROM User u WHERE u.username = :username")
//   public User getUserByUsername(@Param("username") String username);
	
//	 public User findByUserIdentityUser_Id(long user_Id);
//	
//	@Query("update User u set u.user_Name= ?1, u.role = ?2 where u.user_Id = ?3")
//	public User updateuser(String name,String role,long id) ;
	
	@Query("SELECT u FROM User u WHERE u.user_Name = :user_Name")
	 public User findByUser_Name(String user_Name); 
	
	@Query("SELECT u.enabled FROM User u WHERE u.user_Name = :user_Name")
	 public String findEnable(String user_Name); 
//	 
//	@Query("delete from User u where u.user_Id = :user_Id")
//	 public User deleteByUser_Id(long user_Id);

	@Query("SELECT u FROM User u WHERE u.role= 'ROLE_USER'")
	 List <User> findByUserByRole(); 
	
	@Query("UPDATE User  SET enabled = '1' WHERE role = :role AND institute= :institute")
	 List <User> updateByUserByRole2(String role,String institute);
	
	@Query("SELECT u FROM User u WHERE u.role = :role AND u.institute= :institute")
	 List <User> findByUserByRole2(String role,String institute); 
	

	@Query("SELECT u FROM User u WHERE u.role= :role AND u.institute= :institute")
	 List <User> findByAdminByRole2(String role,String institute);
}
