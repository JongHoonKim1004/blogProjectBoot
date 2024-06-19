package com.blogproject.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(unique=true, nullable = false)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private String phone;

    private String zipNo;
    private String addr;
    private String addrDetail;

    private LocalDateTime regDate;

    // 소셜 로그인 구현 이후 소셜 로그인 이메일 확인 후 추가
}
