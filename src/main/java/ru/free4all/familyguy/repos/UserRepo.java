package ru.free4all.familyguy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.free4all.familyguy.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
