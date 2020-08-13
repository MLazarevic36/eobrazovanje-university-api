package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Teacher;
import com.eobrazovanje.university.entity.User;
import com.eobrazovanje.university.mapper.dto.TeacherDTO;
import com.eobrazovanje.university.mapper.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public Set<UserDTO> convertToDtos(Page<User> userPage) {
        return userPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public Set<User> convertToEntities(Collection<UserDTO> userDTOS) {
        return userDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
