package dev.sjsuJava.demo.Entity;

import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long comment_id;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "commenter_id", referencedColumnName = "id") // 유저 테이블의 id를 commenter_id로 저장
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User commenter;

    @Column(length = 1500, nullable = false)
    private String content;
}