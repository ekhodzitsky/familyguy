package ru.free4all.familyguy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.BasicVideoManager;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.*;

@Service
public class VideoService implements BasicVideoManager {

    private final VideoRepo videoRepo;
    private final UtilsService utilsService;

    @Autowired
    public VideoService(VideoRepo videoRepo, UtilsService utilsService) {
        this.videoRepo = videoRepo;
        this.utilsService = utilsService;
    }

    /**
     * Вызвращает самую новую серию сериала.
     *
     * @return видео.
     */
    private Video getFresh() {
        Video fresh = null;
        List<Video> videoList = videoRepo.findAll();
        if (!videoList.isEmpty()) {
            List<Integer> seasons = new ArrayList<>();
            for (Video v : videoList) {
                seasons.add(v.getSeason());
            }
            Integer lastSeason = Collections.max(seasons);
            List<Integer> episodes = new ArrayList<>();
            for (Video v : videoList) {
                if (v.getSeason().intValue() == lastSeason.intValue()) {
                    episodes.add(v.getEpisode());
                }
            }
            Integer lastEpisode = Collections.max(episodes);
            fresh = videoRepo.findByEpisodeAndSeason(lastEpisode, lastSeason);
        }
        return fresh;
    }

    /**
     * Возвращает первую доступную серию сезона (если сезон начинается с 5 серии,
     * значит положит 5-ую, если добавить, например, еще 7 и 3, будет класть 3-ю.
     *
     * @param season номер сезона.
     */
    private Video getFirstEpisodeOfSeason(int season) {
        Video video = null;
        List<Video> list = videoRepo.findAll();
        List<Integer> episodes = new ArrayList<>();
        for (Video v : list) {
            if (v.getSeason() == season) {
                episodes.add(v.getEpisode());
            }
        }
        for (Video v : list) {
            if (v.getSeason() == season && v.getEpisode().intValue() == Collections.min(episodes).intValue()) {
                video = v;
                break;
            }
        }
        return video;
    }

    /**
     * Берет самую свежую серию сериала. Самую новую.
     * Устанавливает в зависимости от нее текущий сезон и серии этого сезона(список слева
     * на отображаемой странице).
     *
     * @param model страница.
     */
    @Override
    public void getEpisode(Model model) {
        Video fresh = getFresh();
        model.addAttribute("video", fresh);
        model.addAttribute("seasons", utilsService.getAvailableSeasons());
        model.addAttribute("episodes", utilsService.getAvailableEpisodes(fresh.getSeason()));
    }

    /**
     * Пользователь выбирает сезон, загружается первая доступная серия этого сезона.
     * Устанавливается в зависимости от выбранного сезона список серий слева.
     *
     * @param season выбранный сезон.
     * @param model  страница.
     */
    @Override
    public void getEpisode(int season, Model model) {
        Video first = getFirstEpisodeOfSeason(season);
        model.addAttribute("video", first);
        model.addAttribute("seasons", utilsService.getAvailableSeasons());
        model.addAttribute("episodes", utilsService.getAvailableEpisodes(first.getSeason()));
    }

    /**
     * Пользователь выбрал конкретную серию конкретного сезона. Загружается она.
     * Список серий слева в зависимости от выбранного сезона.
     *
     * @param episode выбранная серия.
     * @param season  выбранный сезон.
     * @param model   страница.
     */
    @Override
    public void getEpisode(int episode, int season, Model model) {
        Video chosen = videoRepo.findByEpisodeAndSeason(episode, season);
        model.addAttribute("video", chosen);
        model.addAttribute("seasons", utilsService.getAvailableSeasons());
        model.addAttribute("episodes", utilsService.getAvailableEpisodes(season));
    }
}
