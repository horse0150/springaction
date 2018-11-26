package com.wwb.repository;

import com.wwb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUsername(final String username);
}
