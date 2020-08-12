package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);
    User getByUsernameAndPassword(String username, String password);
}
