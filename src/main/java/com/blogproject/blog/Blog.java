package com.blogproject.blog;

import com.blogproject.users.Users;
import jakarta.persistence.*;
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
public class Blog {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "users_id")
    private Users users;

    @Column(nullable = false, length = 100)
    private String title;

    private LocalDateTime regDate;

    private String address; // 경로에 붙을 이름
}
