package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.model.User;
import com.examportal.repo.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	@Autowired(required = true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public List<User> listAll() {
        return repo.findAll();
    }
     
    public void save(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
  
	public User findByUsername(String username) {
		return repo.getUserByUsername(username);
	}
     
    public User get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
