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

    @Autowired
    private VideoRepo videoRepo;

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
     * Получаем список сезонов в базе данных в виде сета чисел.
     *
     * @return по сути номера сезонов, которые есть в базе данных.
     */
    private Set<Integer> getAvailableSeasons() {
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

    /**
     * Получаем список серий сезона.
     *
     * @param season какой-то сезон (его номер).
     * @return возвращаем список серий.
     */
    private List<Video> getAvailableEpisodes(int season) {
        List<Video> episodes = new ArrayList<>();
        for (Video v : videoRepo.findAll()) {
            if (v.getSeason() == season) episodes.add(v);
        }

        VideoEpisodesComparator vec = new VideoEpisodesComparator();
        episodes.sort(vec);
        return episodes;
    }

    private class VideoEpisodesComparator implements Comparator<Video> {
        public int compare(Video a, Video b){
            return a.getEpisode().compareTo(b.getEpisode());
        }
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
        model.addAttribute("seasons", getAvailableSeasons());
        model.addAttribute("episodes", getAvailableEpisodes(fresh.getSeason()));
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
        model.addAttribute("seasons", getAvailableSeasons());
        model.addAttribute("episodes", getAvailableEpisodes(first.getSeason()));
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
        model.addAttribute("seasons", getAvailableSeasons());
        model.addAttribute("episodes", getAvailableEpisodes(season));
    }

//
//    public void putEpisodesList(int season, Model model) {
//        model.addAttribute("number_of_season", season);
//        List<Video> videos = new ArrayList<>();
//        for (Video v : videoRepo.findAll()) {
//            if (v.getSeason() == season) {
//                videos.add(v);
//            }
//        }
//        model.addAttribute("episodes", videos);
//    }
//
//
//    /**
//     * Кладет первую доступную серию сезона на страничку (если сезон начинается с 5 серии,
//     * значит положит 5-ую, если добавить, например, еще 7 и 3, будет класть 3-ю.
//     * <p>
//     * ЛИБО
//     * <p>
//     * Кладет конкретно выбранный эпизод.
//     *
//     * @param season  номер сезона.
//     * @param episode номер серии.
//     * @param model   страница.
//     */
//    public void putEpisode(int season, int episode, Model model) {
//        model.addAttribute("first_episode_of_season", videoRepo.findByEpisodeAndSeason(episode, season));
//    }
//
//    private void video(int season, int episode, Model model) {
//        List<Video> videoList = videoRepo.findAll();
//        Set<Integer> episodes = new TreeSet<>();
//        for (Video v : videoList) {
//            if (v.getSeason() == season) episodes.add(v.getEpisode());
//        }
//        model.addAttribute("episodes", episodes);
//        model.addAttribute("season", season);
//        if (episode >= 1) {
//            model.addAttribute("link", videoRepo.findByEpisodeAndSeason(episode, season).getLink());
//        } else {
//            model.addAttribute("link", videoRepo.findByEpisodeAndSeason(episodes.iterator().next(), season).getLink());
//        }
//    }
//
//
//    /**
//     * Кладет доступные сезоны на страничку.
//     *
//     * @param model model.
//     */
//    public void putAvailableSeasons(Model model) {
//        model.addAttribute("seasons", getAvailableSeasons());
//    }
//
//    /**
//     * Добавляет самую свежую серию на главную страницу
//     * (не последнюю добавленную, а самую новую).
//     *
//     * @param model model.
//     */
//    public void putFresh(Model model) {
//        Video fresh = getFresh();
//        model.addAttribute("last_episode", fresh.getEpisode());
//        model.addAttribute("last_season", fresh.getSeason());
//        model.addAttribute("fresh", fresh.getLink());
//    }
}
