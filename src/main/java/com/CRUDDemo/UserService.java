package com.CRUDDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	private final UserRepository userRepository = null;
	
	public User findUserByLastNamee(String lastname) {
        return userRepository.findUserByLastName(lastname);
    }
	
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
	
	public User getUser(long userID) {
        return userRepository.findById(userID).get();
    }
	
	public void deleteUser(long userID) {
		userRepository.deleteById(userID);
	}

	public List<User> findUserByKeyword(String keyword) {
		return userRepository.findUserByKeyword(keyword);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
    }
	
	public User updateUser(User user) {
        Long id = user.getId();
        User u = this.getUser(id);
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setEmail(u.getEmail());
        user.setPhone(u.getPhone());
        return userRepository.save(user);
    }
	
}
