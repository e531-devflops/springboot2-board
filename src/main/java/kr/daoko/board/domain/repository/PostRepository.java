package kr.daoko.board.domain.repository;

import kr.daoko.board.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
