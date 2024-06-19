package com.blogproject.config;

import com.blogproject.blog.Blog;
import com.blogproject.blog.BlogDto;
import com.blogproject.users.UsersMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private final UsersMapper usersMapper;
    public ModelMapperConfig(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Blog
        modelMapper.addMappings(new PropertyMap<Blog, BlogDto>() {
            @Override
            protected void configure() {
                map().setUsers(usersMapper.toDto(source.getUsers()));
            }
        });

        // BlogDTO
        modelMapper.addMappings(new PropertyMap<BlogDto, Blog>() {

            @Override
            protected void configure() {
                map().setUsers(usersMapper.toEntity(source.getUsers()));
            }
        });

        return modelMapper;
    }
}
