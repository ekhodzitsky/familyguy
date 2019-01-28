package ru.free4all.familyguy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.free4all.familyguy.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
