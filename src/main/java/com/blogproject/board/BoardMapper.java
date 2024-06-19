package com.blogproject.board;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BoardMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BoardDto toDto(Board board) {
        return modelMapper.map(board, BoardDto.class);
    }

    public Board toEntity(BoardDto boardDto) {
        return modelMapper.map(boardDto, Board.class);
    }

    public List<BoardDto> toDto(List<Board> boards) {
        return boards.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Board> toEntity(List<BoardDto> boardDtos) {
        return boardDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
