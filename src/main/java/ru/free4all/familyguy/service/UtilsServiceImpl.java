package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.free4all.familyguy.entities.Translation;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.repos.UserRepo;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.*;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private InputValidationServiceImpl inputValidationService;

    /**
     * Получаем список серий сезона.
     *
     * @param season какой-то сезон (его номер).
     * @return возвращаем список серий.
     */
    @Override
    public List<Video> getAvailableEpisodes(int season) {
        List<Video> episodes = new ArrayList<>();
        for (Video v : videoRepo.findAll()) {
            if (v.getSeason() == season) episodes.add(v);
        }

        UtilsServiceImpl.VideoEpisodesComparator vec = new UtilsServiceImpl.VideoEpisodesComparator();
        episodes.sort(vec);
        return episodes;
    }

    private class VideoEpisodesComparator implements Comparator<Video> {
        public int compare(Video a, Video b) {
            return a.getEpisode().compareTo(b.getEpisode());
        }
    }

    /**
     * Получаем список сезонов в базе данных в виде сета чисел.
     *
     * @return по сути номера сезонов, которые есть в базе данных.
     */
    @Override
    public Set<Integer> getAvailableSeasons() {
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
     * Получаем видео если таковое есть.
     *
     * @param id id видео.
     * @return какое-то видео или null.
     */
    @Override
    public Video getIfExists(String id) {
        Video result = null;
        if (inputValidationService.isInputValid(id) && NumberUtils.isCreatable(id)) {
            Long l = Long.parseLong(id);
            if (videoRepo.findById(l).isPresent()) result = videoRepo.findById(l).get();
        }
        return result;
    }

    /**
     * Проверяет, если такое видео существует.
     *
     * @param id id видео.
     * @return true/false.
     */
    @Override
    public boolean isVideoExists(String id) {
        boolean result = false;
        if (inputValidationService.isInputValid(id) && NumberUtils.isCreatable(id)) {
            if (videoRepo.findById(Long.parseLong(id)).isPresent()) result = true;
        }
        return result;
    }

    /**
     * Проверяет, если такое видео существует (используя номер сезона и номер серии).
     *
     * @param e - номер серии.
     * @param s - номер сезона.
     * @return true/false.
     */
    @Override
    public boolean isVideoExists(String e, String s) {
        boolean result = false;
        if (inputValidationService.isInputValid(e, s) && NumberUtils.isCreatable(e) && NumberUtils.isCreatable(s)) {
            if (videoRepo.findByEpisodeAndSeason(Integer.parseInt(e), Integer.parseInt(s)) != null) result = true;
        }
        return result;
    }

    /**
     * Проверяет, если такой пользователь существует.
     *
     * @param id id пользователя.
     * @return true/false.
     */
    @Override
    public boolean isUserExists(String id) {
        boolean result = true;
        if (inputValidationService.isInputValid(id) && NumberUtils.isCreatable(id)) {
            if (!userRepo.findById(Long.parseLong(id)).isPresent()) result = false;
        }
        return result;
    }

    /**
     * Проверяет, существует ли такой перевод у видео.
     *
     * @param video       какое-то видео.
     * @param translation перевод.
     * @return true/false.
     */
    @Override
    public boolean isTranslationExists(Video video, String translation) {
        boolean result = false;
        if (!Translation.valueOf(translation).getAuthority().isEmpty() && video != null) {
            if (video.getLinks() != null) {
                if (video.getLinks().containsKey(Translation.valueOf(translation))) result = true;
            }
        }
        return result;
    }

    /**
     * Получаем отсортированный список видосов всех что есть.
     *
     * @return список видео.
     */
    @Override
    public List<Video> findAllAndSort() {
        List<Video> result = null;
        Set<Integer> seasons = getAvailableSeasons();
        if (!seasons.isEmpty()) {
            result = new ArrayList<>();
            for (Integer i : seasons) {
                result.addAll(getAvailableEpisodes(i));
            }
        }
        return result;
    }

    /**
     * Получаем конкретный сезон уже отсортированный.
     *
     * @param season номер сезона.
     * @return список серий.
     */
    @Override
    public List<Video> getSortedSeason(int season) {
        List<Video> result = new ArrayList<>();
        for (Video v : findAllAndSort()) {
            if (v.getSeason() == season) {
                result.add(v);
            }
        }
        return result;
    }
}
