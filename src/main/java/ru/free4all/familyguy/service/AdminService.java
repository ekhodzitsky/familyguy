package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

@Service
public class AdminService {

    @Autowired
    private VideoRepo videoRepo;

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
}
