package com.reyansh.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reyansh.shop.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByEmail(String email);
}