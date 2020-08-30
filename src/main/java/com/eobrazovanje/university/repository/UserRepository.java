package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);
    User getByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM users WHERE deleted = 0", nativeQuery = true)
    Page<User> findAllByDeleted(Pageable pageable);
}
