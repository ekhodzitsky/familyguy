package ru.free4all.familyguy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.free4all.familyguy.entities.Video;

public interface VideoRepo extends JpaRepository<Video, Long> {
    Video findByEpisodeAndSeason(Integer episode, Integer season);
}
