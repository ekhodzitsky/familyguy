package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.List;
import java.util.Set;

@Service
public class AdminService {

    private final VideoRepo videoRepo;
    private final UtilsService utilsService;

    @Autowired
    public AdminService(VideoRepo videoRepo, UtilsService utilsService) {
        this.videoRepo = videoRepo;
        this.utilsService = utilsService;
    }

    public void list(Model model) {
        List<Video> videos = videoRepo.findAll();
        Set<Integer> seasons = utilsService.getAvailableSeasons();
        if (!videos.isEmpty()) model.addAttribute("seasons", seasons);
        String horror = "";
        for(Integer i : seasons){
            List<Video> videosOfConcreteSeason = utilsService.getAvailableEpisodes(i);
            horror = horror + "<li><ul class=\"uk-list\">";
            for(Video v : videosOfConcreteSeason) {
                horror = horror + "<li>" + v.getEpisode() + " серия</li>";
            }
            horror = horror + "</ul></li>";
        }
        model.addAttribute("episodes", horror);
    }

    public void upload(String episode, String season, String link, Model model) {
        if (episode != null && season != null && link != null && !link.equals("")) {
            if (NumberUtils.isCreatable(episode) && NumberUtils.isCreatable(season)) {
                Video v = new Video();
                v.setEpisode(Integer.parseInt(episode));
                v.setSeason(Integer.parseInt(season));
                v.setLink(link);
                videoRepo.save(v);
                model.addAttribute("message", "Видео добавлено.");
            } else {
                model.addAttribute("message", "Вы ввели некорректные данные. Видео не добавлено.");
            }
        } else {
            model.addAttribute("message", "Вы оставили какие-то поля пустыми. Видео не добавлено.");
        }
    }

    public void delete(String episode, String season, Model model) {
        if (episode != null && season != null) {
            if (NumberUtils.isCreatable(episode) && NumberUtils.isCreatable(season)) {
                Video v = videoRepo.findByEpisodeAndSeason(Integer.parseInt(episode), Integer.parseInt(season));
                if (v != null) {
                    videoRepo.delete(v);
                    model.addAttribute("message", "Cерия " + episode + " сезон " + season + " была удалена.");
                } else {
                    model.addAttribute("message", "Такого видео не существует. Ничего не удалено.");
                }
            } else {
                model.addAttribute("message", "Вы ввели некорректные данные. Ничего не удалено.");
            }
        } else {
            model.addAttribute("message", "Вы оставили какие-то поля пустыми. Ничего не удалено.");
        }
    }
}
