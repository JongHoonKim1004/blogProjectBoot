package com.blogproject.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminMapper adminMapper;

    // Create
    @Transactional
    public AdminDto create(AdminDto adminDto) {
        Admin saved = adminRepository.save(adminMapper.toEntity(adminDto));
        log.info("Service : Admin Saved : {}", saved.toString());

        return adminMapper.toDto(saved);
    }

    // Read
    public List<AdminDto> findAll() {
        List<Admin> all = adminRepository.findAll();
        return adminMapper.toDto(all);
    }
    public AdminDto getAdmin(String id) {
        Admin admin = adminRepository.findById(id).get();
        log.info("Service : Admin Retrieved : {}", admin.toString());

        return adminMapper.toDto(admin);
    }

    // Update
    @Transactional
    public AdminDto update(AdminDto adminDto) {
        Admin saved = adminRepository.save(adminMapper.toEntity(adminDto));
        log.info("Service : Admin Updated : {}", saved.toString());
        return adminMapper.toDto(saved);
    }

    // Delete
    @Transactional
    public void delete(String id) {
        adminRepository.deleteById(id);
        log.info("Service : Admin Deleted : {}", id);
    }

}
