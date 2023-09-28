package dev.sjsuJava.demo;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long comment_id;

    @Column(name="post_id")
    private Long post_id;

    @Column(length = 50,nullable = false)
    private String commenter;

    @Column(length = 1500,nullable = false)
    private String content;

}