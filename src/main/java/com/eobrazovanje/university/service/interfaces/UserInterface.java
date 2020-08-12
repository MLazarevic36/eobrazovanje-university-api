package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserInterface {

    User findOne(Long id);
    Page<User> findAll(Pageable pageable);
    User save(User user);
    User update(User user);
    void delete(User user);
}
