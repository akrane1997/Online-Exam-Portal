package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examportal.model.Exam_user;
import com.examportal.model.Score;
import com.examportal.model.User;

@Repository
public interface Exam_UserRepo extends JpaRepository<Exam_user, Long> {
	
//	@Query("insert into Exam_user(exam,user) values (:exam,:user)")
//	public void save(Exam exam,User user);
	
	@Query("SELECT e FROM Exam_user e WHERE e.exam.Exam_Id = :Exam_Id")
	List<Exam_user> findByExam_userbyexamid(int Exam_Id);
	
	@Query("SELECT e FROM Exam_user e WHERE e.user.user_Id = :user_Id")
	List<Exam_user> showExamId(long user_Id);
	
	/*
	 * @Query("SELECT e FROM Exam_user e WHERE e.exam.Exam_Id= :Exam_Id AND e.user.user_Id= :user_Id"
	 * ) Score getScore(int Exam_Id, long user_Id);
	 */
}
