package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User saveUserDetails(User transientUser) {
		
		return userDao.save(transientUser);
	}

	@Override
	public List<User> getAllUser() {
		
		 return userDao.findAll();
	}

	@Override
	public Optional<User> signIn(User user) {
		return userDao.findByEmailAndPassword(user.getEmail(),user.getPassword());
	}

	@Override
	public User forgetPassword(User user) {
		// TODO Auto-generated method stub
		return userDao.findByMobileNumber(user.getMobileNumber());
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public Optional<User> getUserDetailsById(int productId) {
		return userDao.findById(productId);
	}

	@Override
	public User updateProfile(User user) {
		return userDao.save(user);
	}

	

}
