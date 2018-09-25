package com.neo.repository;

import com.neo.entity.UserForJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserForJPA, Long> {

    UserForJPA findById(long id);

    Long deleteById(Long id);
}