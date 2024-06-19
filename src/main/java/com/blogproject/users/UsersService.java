package com.blogproject.users;

import com.blogproject.blog.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private BlogService blogService;

    // 기본 CRUD
    // Create
    @Transactional
    public UsersDto create(UsersDto usersDto) {
        Users saved = usersRepository.save(usersMapper.toEntity(usersDto));
        log.info("Service : Users created : {}", saved.toString());
        return usersMapper.toDto(saved);
    }

    // Read
    public List<UsersDto> findAll() {
        List<Users> users = usersRepository.findAll();
        return usersMapper.toDto(users);
    }
    public UsersDto findById(String id) {
        Users user = usersRepository.findById(id).get();
        return usersMapper.toDto(user);
    }

    // Update
    @Transactional
    public UsersDto update(UsersDto usersDto) {
        Users saved = usersRepository.save(usersMapper.toEntity(usersDto));
        log.info("Service : Users updated : {}", saved.toString());
        return usersMapper.toDto(saved);
    }

    // Delete
    @Transactional
    public void delete(String id) {
        // 블로그 게시글과 답글 제거
        
        // 블로그 내 게시판 카테고리 제거
        
        // 블로그 메타데이터 제거
        blogService.delete(id);

        // 유저 정보 제거
        usersRepository.deleteById(id);
        log.info("Service : Users deleted : {}", id);
    }
}
