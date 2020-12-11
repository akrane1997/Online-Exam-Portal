package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examportal.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	@Query("SELECT u FROM User u WHERE u.user_Id = :user_Id")
//	public User findByUser_Id(long user_Id);

//
//	 @Query("SELECT u FROM User u WHERE u.username = :username")
//   public User getUserByUsername(@Param("username") String username);
	
//	 public User findByUserIdentityUser_Id(long user_Id);
//	
//	@Query("update User u set u.user_Name= ?1, u.role = ?2 where u.user_Id = ?3")
//	public User updateuser(String name,String role,long id) ;
	
	@Query("SELECT u FROM User u WHERE u.user_Name = :user_Name")
	 public User findByUser_Name(String user_Name); 
//	 
//	@Query("delete from User u where u.user_Id = :user_Id")
//	 public User deleteByUser_Id(long user_Id);

//	@Query("SELECT u FROM User u WHERE u.exam1.Exam_Id = :Exam_Id")
//	 List <User> findByUser_IdWhereExam_Id(long Exam_Id); 
}
