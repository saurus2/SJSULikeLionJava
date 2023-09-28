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
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long user_id;

    @Column(length = 100,nullable = false, unique = true)
    private String username;

    @Column(length = 1500,nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;
}