package ru.free4all.familyguy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class UtilsService {

    private final VideoRepo videoRepo;

    @Autowired
    public UtilsService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    /**
     * Получаем список серий сезона.
     *
     * @param season какой-то сезон (его номер).
     * @return возвращаем список серий.
     */
    public List<Video> getAvailableEpisodes(int season) {
        List<Video> episodes = new ArrayList<>();
        for (Video v : videoRepo.findAll()) {
            if (v.getSeason() == season) episodes.add(v);
        }

        UtilsService.VideoEpisodesComparator vec = new UtilsService.VideoEpisodesComparator();
        episodes.sort(vec);
        return episodes;
    }

    private class VideoEpisodesComparator implements Comparator<Video> {
        public int compare(Video a, Video b){
            return a.getEpisode().compareTo(b.getEpisode());
        }
    }

    /**
     * Получаем список сезонов в базе данных в виде сета чисел.
     *
     * @return по сути номера сезонов, которые есть в базе данных.
     */
    public Set<Integer> getAvailableSeasons(){
        Set<Integer> result = new TreeSet<>();
        List<Video> videoList = videoRepo.findAll();
        if (!videoList.isEmpty()) {
            for (Video v : videoList) {
                result.add(v.getSeason());
            }
        } else {
            result = null;
        }
        return result;
    }
}
