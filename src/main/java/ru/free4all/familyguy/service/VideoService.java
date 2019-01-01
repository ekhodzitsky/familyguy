package ru.free4all.familyguy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Translation;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.BasicVideoManager;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VideoService implements BasicVideoManager {

    private static final String VIDEO_ATTR = "video";
    private static final String TRANSLATION_ATTR = "translation";
    private static final String TR_ACTIVE_ATTR = "tr_active";
    private static final String EPISODES_ATTR = "episodes";
    private static final String SEASONS_ATTR = "seasons";

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

    private void chooseTranslationIfExists(Video v, Model m) {
        if (!v.getLinks().isEmpty()) {
            if (v.getLinks().containsKey(Translation.FILIZA)) {
                m.addAttribute("translation", v.getLinks().get(Translation.FILIZA));
                m.addAttribute("tr_active", Translation.FILIZA.getAuthority());
            } else {
                for (Enum e : Translation.values()) {
                    if (v.getLinks().containsKey(e)) {
                        m.addAttribute("translation", v.getLinks().get(e));
                        m.addAttribute("tr_active", e.name());
                        break;

                    }
                }
            }
        }
    }

    /**
     * Берет самую свежую серию сериала. Самую новую.
     * Устанавливает в зависимости от нее текущий сезон и серии этого сезона(список слева
     * на отображаемой странице).
     *
     * @param m страница.
     */
    @Override
    public void getEpisode(Model m) {
        Video f = getFresh();
        if (f != null) {
            m.addAttribute(VIDEO_ATTR, f);
            m.addAttribute(SEASONS_ATTR, utilsService.getAvailableSeasons());
            m.addAttribute(EPISODES_ATTR, utilsService.getAvailableEpisodes(f.getSeason()));
            chooseTranslationIfExists(f, m);
        }
    }

    /**
     * Пользователь выбирает сезон, загружается первая доступная серия этого сезона.
     * Устанавливается в зависимости от выбранного сезона список серий слева.
     *
     * @param s выбранный сезон.
     * @param m страница.
     */
    @Override
    public void getEpisode(int s, Model m) {
        Video f = getFirstEpisodeOfSeason(s);
        m.addAttribute(VIDEO_ATTR, f);
        m.addAttribute(EPISODES_ATTR, utilsService.getAvailableEpisodes(f.getSeason()));
        m.addAttribute(SEASONS_ATTR, utilsService.getAvailableSeasons());
        chooseTranslationIfExists(f, m);
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
        model.addAttribute(VIDEO_ATTR, chosen);
        chooseTranslationIfExists(chosen, model);
        model.addAttribute(SEASONS_ATTR, utilsService.getAvailableSeasons());
        model.addAttribute(EPISODES_ATTR, utilsService.getAvailableEpisodes(season));
    }

    /**
     * Пользователь выбрал конкретную серию конкретного сезона с определенным переводом.
     * Загружается она. Список серий слева в зависимости от выбранного сезона.
     *
     * @param e выбранная серия.
     * @param s выбранный сезон.
     * @param t выбранный перевод.
     * @param m страница.
     */
    @Override
    public void getEpisode(int e, int s, String t, Model m) {
        Video v = videoRepo.findByEpisodeAndSeason(e, s);
        m.addAttribute(VIDEO_ATTR, v);
        if (utilsService.isTranslationExists(v, t)) {
            m.addAttribute(TRANSLATION_ATTR, v.getLinks().get(Translation.valueOf(t)));
            m.addAttribute(TR_ACTIVE_ATTR, t);
        }
        m.addAttribute(SEASONS_ATTR, utilsService.getAvailableSeasons());
        m.addAttribute(EPISODES_ATTR, utilsService.getAvailableEpisodes(s));
    }
}
