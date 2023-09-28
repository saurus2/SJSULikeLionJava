package dev.sjsuJava.demo.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Roar extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long roar_id;

    @Column(length = 100,nullable = false, unique = true)
    private Long user_id;

    @Column(length = 1500,nullable = false)
    private Long post_id;
}