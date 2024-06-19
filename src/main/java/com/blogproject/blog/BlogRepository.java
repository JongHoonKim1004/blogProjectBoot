package com.blogproject.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, String> {
    Blog findByUsers_Id(String id);
    Blog findByAddress(String address);
}
