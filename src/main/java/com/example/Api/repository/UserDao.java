package com.example.Api.repository;

import com.example.Api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDao extends CrudRepository<User, String> {

    Optional<User> findByUserName(String username);
    Optional<User> findByUserNameAndPassword(String username, String password);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);

    Iterable<User> findByEnabledTrue();
}
