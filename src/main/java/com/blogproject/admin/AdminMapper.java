package com.blogproject.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminMapper {
    @Autowired
    private ModelMapper modelMapper;

    public AdminDto toDto(Admin admin) {
        return modelMapper.map(admin, AdminDto.class);
    }

    public Admin toEntity(AdminDto adminDto) {
        return modelMapper.map(adminDto, Admin.class);
    }

    public List<AdminDto> toDto(List<Admin> admins) {
        return admins.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Admin> toEntity(List<AdminDto> adminDtos) {
        return adminDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
