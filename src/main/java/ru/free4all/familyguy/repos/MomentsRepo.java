package ru.free4all.familyguy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.free4all.familyguy.entities.Moments;

public interface MomentsRepo extends JpaRepository<Moments, Long> {
}
