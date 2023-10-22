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
public class Roar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동생성
    @Column(name = "id")
    private Long roar_id;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "commenter_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User commenter;

    // removing persistency
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;
}