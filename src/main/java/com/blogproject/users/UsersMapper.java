package com.blogproject.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UsersDto toDto(Users users) {
        return modelMapper.map(users, UsersDto.class);
    }

    public Users toEntity(UsersDto dto) {
        return modelMapper.map(dto, Users.class);
    }

    public List<UsersDto> toDto(List<Users> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Users> toEntity(List<UsersDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
