package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Translation;
import ru.free4all.familyguy.entities.User;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.UserRepo;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.Optional;

@Service
public class AdminService {

    private final VideoRepo videoRepo;
    private final VideoService videoService;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(VideoRepo videoRepo, VideoService videoService, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.videoRepo = videoRepo;
        this.videoService = videoService;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
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

    public void deleteById(String id, Model model) {
        if (id != null) {
            Optional<Video> video = videoRepo.findById(Long.parseLong(id));
            if (video.isPresent()) {
                videoRepo.deleteById(Long.parseLong(id));
                model.addAttribute("message", "Видео удалено");
            } else {
                model.addAttribute("message", "Такого видео не существует. Ничего не удалено.");
            }
        } else {
            model.addAttribute("message", "Некорректный ввод.");
        }
    }

    public void changeUserLoginAndPassword(String oldLogin, String newLogin, String newPass, Model m) {
        User user = userRepo.findByUsername(oldLogin);
        if (user != null) {
            if (newLogin != null && newPass != null && !newLogin.equals("") && !newPass.equals("")) {
                user.setUsername(newLogin);
                user.setPassword(passwordEncoder.encode(newPass));
                userRepo.save(user);
                m.addAttribute("message", "Данные пользователя изменены.");
            } else {
                m.addAttribute("message", "Некорректный ввод.");
            }
        } else {
            m.addAttribute("message", "Пользователь не найден.");
        }
    }


    public void editVideoAddNewTranslation(String id, String translation, String link, Model m) {
        Video video = videoService.findById(id);
        if (video != null && translation != null && link != null && !translation.equals("") && !link.equals("")) {
            if (!video.getLinks().containsKey(Translation.valueOf(translation))) {
                video.getLinks().put(Translation.valueOf(translation), link);
                videoRepo.save(video);
                m.addAttribute("message", "Перевод " + translation + " добавлен.");
            } else {
                m.addAttribute("message", "Видео с таким переводом уже есть.");
            }
        } else {
            m.addAttribute("message", "Некорректный ввод.");
        }
    }

    public void editVideoNames(String id, String rusName, String engName, Model m) {
        Video video = videoService.findById(id);
        if (video != null) {
            if (!rusName.isEmpty() && !engName.isEmpty()) {
                video.setRusName(rusName);
                video.setEngName(engName);
                videoRepo.save(video);
                m.addAttribute("message", "Название видео добавлено");
            } else {
                m.addAttribute("message", "Поля были не заполнены.");
            }
        } else {
            m.addAttribute("message", "Видео не найдено по этому id.");
        }
    }

    public void editVideoDescription(String id, String description, Model m) {
        Video video = videoService.findById(id);
        if (video != null) {
            if (!description.isEmpty()) {
                video.setDescription(description);
                videoRepo.save(video);
                m.addAttribute("message", "Описание добавлено.");
            } else {
                m.addAttribute("message", "Вы оставили поле описание пустым.");
            }
        } else {
            m.addAttribute("message", "Видео не найдено.");
        }
    }

    /**
     * Добавляет отсортированный список (объект) к html.
     *
     * @param m наша страница.
     */
    public void list(Model m) {
        m.addAttribute("list", videoService.findAllAndSort());
    }
}


