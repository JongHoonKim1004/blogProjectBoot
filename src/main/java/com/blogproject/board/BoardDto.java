package com.blogproject.board;

import com.blogproject.blog.BlogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private String id;
    private String name;
    private Integer order;
    private BlogDto blog;
    private LocalDateTime regDate = LocalDateTime.now();

}
