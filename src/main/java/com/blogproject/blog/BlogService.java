package com.blogproject.blog;

import com.blogproject.users.Users;
import com.blogproject.users.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;

    // Delete 를 제외한 CRU
    // Create
    @Transactional
    public BlogDto create(BlogDto blogDto) {
        Blog blog = modelMapper.map(blogDto, Blog.class);
        Blog saved = blogRepository.save(blog);
        log.info("Service : Blog Created : {}", saved.toString());
        return modelMapper.map(saved, BlogDto.class);
    }

    // Read
    public List<BlogDto> getAll() {
        List<Blog> blogs = blogRepository.findAll();
        List<BlogDto> blogDtos = new ArrayList<>();
        for (Blog blog : blogs) {
            blogDtos.add(modelMapper.map(blog, BlogDto.class));
        }

        return blogDtos;
    }

    public BlogDto findByUsersId(String id){
        Blog blog = blogRepository.findByUsers_Id(id);
        return modelMapper.map(blog, BlogDto.class);
    }

    // Update
    public BlogDto update(BlogDto blogDto) {
        Blog blog = modelMapper.map(blogDto, Blog.class);
        Blog saved = blogRepository.save(blog);
        log.info("Service : Blog Updated : {}", saved.toString());

        return modelMapper.map(saved, BlogDto.class);
    }

    // Delete
    // 기본적으로 단독 시행은 하지 않음 (계정 삭제와 동시에 시행)
    public void delete(String id) {
        blogRepository.delete(blogRepository.findByUsers_Id(id));
        log.info("Service : Blog Deleted : {}", id);
    }
}
