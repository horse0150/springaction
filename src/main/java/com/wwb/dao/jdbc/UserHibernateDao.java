package com.wwb.dao.jdbc;

import com.wwb.dao.UserDao;
import com.wwb.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserHibernateDao /*implements UserRepository*/{

   /* @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public User findById(Long id) {
        return currentSession().get(User.class,id);
    }*/
}
