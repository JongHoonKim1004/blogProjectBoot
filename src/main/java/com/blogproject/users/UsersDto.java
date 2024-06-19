package com.blogproject.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {
    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;

    private String zipNo;
    private String addr;
    private String addrDetail;

    private LocalDateTime regDate = LocalDateTime.now();

}
