package com.blogproject.blog;

import com.blogproject.users.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto {
    private String id;
    private UsersDto users;
    private String title;
    private LocalDateTime regDate;
    private String address; // 경로에 붙을 이름
}
