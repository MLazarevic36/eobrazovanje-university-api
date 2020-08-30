package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.User;
import com.eobrazovanje.university.mapper.UserMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.UserDTO;
import com.eobrazovanje.university.repository.UserRepository;
import com.eobrazovanje.university.service.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findOne(Long id) {
        return userRepository.getOne(id);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public PagedResponse<UserDTO> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "user_id");
        Page<User> users = userRepository.findAllByDeleted(pageable);

        if (users.getNumberOfElements() == 0) {
            return new PagedResponse<UserDTO>(Collections.emptySet(), users.getNumber(), users.getSize(),
                    users.getTotalElements(), users.getTotalPages(), users.isLast());
        }

        return new PagedResponse<UserDTO>(userMapper.convertToDtos(users),  users.getNumber(), users.getSize(),
                users.getTotalElements(), users.getTotalPages(), users.isLast());

    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        user.setDeleted(true);
        userRepository.save(user);
    }
}
