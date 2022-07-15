package com.unique.unique_api.repositories;

import com.unique.unique_api.repositories.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    //    User findByName(String username);
    User findByUsername(String username);
}