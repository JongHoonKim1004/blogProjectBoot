package com.blogproject.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {
    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime regDate = LocalDateTime.now();
}
