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
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long post_id;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    private User writer;

    @Column(length = 200, nullable = false)
    private String content;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "pic_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Picture picture;

    @Column(columnDefinition = "BIGINT(20) NOT NULL DEFAULT 0")
    private Long roars_count;
}