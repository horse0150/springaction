package com.wwb.service;

import com.wwb.model.User;

public interface UserService {

    public User findById(final Long id);

    public User findByUsername(final String username);
}
