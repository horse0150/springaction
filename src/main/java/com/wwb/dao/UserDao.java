package com.wwb.dao;

import com.wwb.model.User;

public interface UserDao {

    public User findById(final Long id);
}
