package com.blogproject.blog;

import com.blogproject.board.Board;
import com.blogproject.board.BoardDto;
import com.blogproject.board.BoardMapper;
import com.blogproject.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BoardMapper boardMapper;

    // CRUD
    // Create
    @Transactional
    public BoardDto create(BoardDto boardDto) {
        Board board = boardMapper.toEntity(boardDto);
        Board saved = boardRepository.save(board);
        log.info("Service : Board created : {}", saved.toString());

        return boardMapper.toDto(saved);
    }

    // Read
    public List<BoardDto> findByBlogId(String BlogId) {
        Blog blog = blogRepository.findById(BlogId).orElse(null);
        List<Board> list = boardRepository.findByBlog(blog);

        return boardMapper.toDto(list);
    }

    public BoardDto findById(String id){
        Board board = boardRepository.findById(id).orElse(null);
        return boardMapper.toDto(board);
    }

    // Update
    @Transactional
    public BoardDto update(BoardDto boardDto) {
        Board board = boardMapper.toEntity(boardDto);
        Board saved = boardRepository.save(board);
        log.info("Service : Board updated : {}", saved.toString());
        return boardMapper.toDto(saved);
    }

    // Delete
    @Transactional
    public void delete(String id) {
        boardRepository.deleteById(id);
        log.info("Service : Board deleted : {}", id);
    }
}
