package com.voyager.mallVoyager.repo;

import com.voyager.mallVoyager.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepo extends CrudRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer integer);
}
