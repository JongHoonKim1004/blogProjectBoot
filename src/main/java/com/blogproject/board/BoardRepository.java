package com.blogproject.board;

import com.blogproject.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, String> {
    List<Board> findByBlog(Blog blog);
}
