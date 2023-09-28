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
public class Post extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long post_id;

    @Column(length = 100,nullable = false, unique = true)
    private String writer;

    @Column(length = 1500,nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 50, nullable = false)
    private String pic_id;

    @Column(length = 50, nullable = false)
    private Long roars_count;
}