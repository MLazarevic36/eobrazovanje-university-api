package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.User;
import com.eobrazovanje.university.mapper.UserMapper;
import com.eobrazovanje.university.mapper.dto.UserDTO;
import com.eobrazovanje.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<Set<UserDTO>> getUsers(Pageable pageable) {
        try {
            Page<User> users = userService.findAll(pageable);
            return new ResponseEntity<>(userMapper.convertToDtos(users),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
        try {
            User user = userService.findOne(id);
            return new ResponseEntity<>(userMapper.convertToDto(user), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.convertToEntity(userDTO);
        try {
            user = userService.save(user);
            return new ResponseEntity<>(userMapper.convertToDto(user), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.convertToEntity(userDTO);
        try {
            user.setId(userDTO.getId());
            user = userService.save(user);
            return new ResponseEntity<>(userMapper.convertToDto(user), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        try {
            User user = userService.findOne(id);
            userService.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
