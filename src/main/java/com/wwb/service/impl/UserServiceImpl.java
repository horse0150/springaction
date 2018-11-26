package com.wwb.service.impl;

import com.wwb.dao.UserDao;
import com.wwb.model.User;
import com.wwb.repository.UserRepository;
import com.wwb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    public User findByUsername(final String username){
        return userRepository.findByUsername(username);
    }
}
