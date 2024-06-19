package com.blogproject.board;

import com.blogproject.blog.Blog;
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
// 게시만 목록 엔티티
public class Board {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(nullable = false)
    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order; // 정렬 순서 (오름차순)

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name="board_id")
    private Blog blog;

    private LocalDateTime regDate;
}
