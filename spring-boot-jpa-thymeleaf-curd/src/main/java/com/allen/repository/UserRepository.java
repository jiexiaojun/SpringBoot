package com.allen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.allen.entity.UserForJPA;

public interface UserRepository extends JpaRepository<UserForJPA, Long> {

    UserForJPA findById(long id);

    Long deleteById(Long id);
}