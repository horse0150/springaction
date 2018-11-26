package com.wwb.dao.jdbc;

import com.wwb.dao.UserDao;
import com.wwb.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserJpaDao implements UserDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    public User findById(final Long id) {
        return em.find(User.class,id);
    }
}
