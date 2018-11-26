package com.wwb.dao.jdbc;

import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDao /*implements UserRepository*/{

    /*@Autowired
    private JdbcOperations jdbcOperations;
    @Override
    public User findById(Long id) {
        return jdbcOperations.queryForObject("select id,username,first_name,last_name,time_create from user where id=?",(rs,rowNum) ->{
            return new User(
               rs.getLong("id"),
               rs.getString("username"),
               rs.getString("first_name"),
               rs.getString("last_name"),
               rs.getDate("time_create")
            );
        },id);
    }*/
}
