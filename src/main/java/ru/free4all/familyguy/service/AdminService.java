package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.Optional;

@Service
public class AdminService {

    private final VideoRepo videoRepo;

    @Autowired
    public AdminService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public void upload(String episode, String season, String link, Model model) {
        boolean equal = false;
        if (episode != null && season != null && link != null && !link.equals("")) {
            if (NumberUtils.isCreatable(episode) && NumberUtils.isCreatable(season)) {
                for (Video video : videoRepo.findAll()) {
                    if (video.getEpisode() == Integer.parseInt(episode) && video.getSeason() == Integer.parseInt(season)) {
                        equal = true;
                        break;
                    }
                }
                if (!equal) {
                    Video v = new Video();
                    v.setEpisode(Integer.parseInt(episode));
                    v.setSeason(Integer.parseInt(season));
                    v.setLink(link);
                    videoRepo.save(v);
                    model.addAttribute("message", "Видео добавлено.");
                } else {
                    model.addAttribute("message", "Такое видео уже есть. Ничего не добавлено.");
                }
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

    public void deleteById(String id, Model model) {
        if (id != null) {
            Optional<Video> video = videoRepo.findById(Long.parseLong(id));
            if (video.isPresent()) {
                videoRepo.deleteById(Long.parseLong(id));
                model.addAttribute("message", "Видео удалено");
            }else {
                model.addAttribute("message", "Такого видео не существует. Ничего не удалено.");
            }
        } else {
            model.addAttribute("message", "Некорректный ввод.");
        }
    }
}
