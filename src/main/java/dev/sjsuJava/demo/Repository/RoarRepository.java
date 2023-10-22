package dev.sjsuJava.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.sjsuJava.demo.Entity.Post;
import dev.sjsuJava.demo.Entity.Roar;
import dev.sjsuJava.demo.Entity.User;

@Repository
// JPA를 사용할 때는 엔티티의 타입정보(Memo)와 @Id 타입(Long)을 지정한다
// JPA는 인터페이스 선언만으로도 자동으로 스프링의 빈(Bean)으로 등록된다
public interface RoarRepository extends JpaRepository<Roar, Long> {
    Roar findByCommenterAndPost(User commenter, Post post);

    List<Roar> findAllByCommenter(User user);
}
