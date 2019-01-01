package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Translation;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.AdminVideoService;
import ru.free4all.familyguy.interfaces.InputValidationService;
import ru.free4all.familyguy.interfaces.MessageService;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.TreeMap;

@Service
public class AdminVideoServiceImpl implements AdminVideoService {
    @Autowired
    private MessageService messageService;
    @Autowired
    private InputValidationService inputValidationService;
    @Autowired
    private UtilsService utilsService;
    @Autowired
    private VideoRepo videoRepo;

    /**
     * Добавление видео в базу.
     *
     * @param e номер эпизода.
     * @param s номер сезона.
     * @param t перевод.
     * @param i ссылка на видео.
     * @param m страница для визуального отображения результата действия.
     */
    @Override
    public void addVideo(String e, String s, String t, String i, Model m) {
        if (inputValidationService.isInputValid(e, s, t, i)) {
            if (!utilsService.isVideoExists(e, s)) {
                if (NumberUtils.isCreatable(e) && NumberUtils.isCreatable(s)) {
                    Video video = new Video();
                    video.setEpisode(Integer.parseInt(e));
                    video.setSeason(Integer.parseInt(s));
                    video.setLinks(new TreeMap<>());
                    video.getLinks().put(Translation.valueOf(t), i);
                    videoRepo.save(video);
                    messageService.adminActionSuccess(m);
                } else messageService.adminActionIncorrectData(m);
            } else messageService.adminActionVideoExists(m);
        } else messageService.adminActionIncorrectData(m);
    }

    /**
     * Добавить перевод к видео (еще одна ссылка на другое видео с другим переводом).
     *
     * @param id id по которому мы видео найдем.
     * @param t  перевод.
     * @param i  ссылка на видео.
     * @param m  страница для визуального отображения результата действия.
     */
    @Override
    public void addTranslation(String id, String t, String i, Model m) {
        if (inputValidationService.isInputValid(id, t, i)) {
            if (utilsService.isVideoExists(id)) {
                Video video = utilsService.getIfExists(id);
                if (!utilsService.isTranslationExists(video, t)) {
                    video.getLinks().put(Translation.valueOf(t), i);
                    videoRepo.save(video);
                    messageService.adminActionSuccess(m);
                } else messageService.adminTranslationExists(m);
            } else messageService.adminActionVideoNotFound(m);
        } else messageService.adminActionIncorrectData(m);
    }

    /**
     * Добавление/редактирование названий видео (на русском и английскои) и описания.
     * Если какое-то поле (кроме id) не будет заполнено, то не будет и изменено.
     *
     * @param id id по которому мы найдем видео.
     * @param r  название видео на русском.
     * @param e  название видео на английском.
     * @param d  описание видео.
     * @param m  страница для визуального отображения результата.
     */
    @Override
    public void addNamesDescription(String id, String r, String e, String d, Model m) {
        if (inputValidationService.isInputValid(id)) {
            if (videoRepo.findById(Long.parseLong(id)).isPresent()) {
                Video v = videoRepo.getOne(Long.parseLong(id));
                if (inputValidationService.isInputValid(r)) v.setRusName(r);
                if (inputValidationService.isInputValid(e)) v.setEngName(e);
                if (inputValidationService.isInputValid(d)) v.setDescription(d);
                videoRepo.save(v);
                messageService.adminActionSuccess(m);
            } else messageService.adminActionVideoNotFound(m);
        } else messageService.adminActionIncorrectData(m);
    }

    /**
     * Удаление видео по id.
     *
     * @param id id по которому мы найдем видео.
     * @param m  страница для отображения результата.
     */
    @Override
    public void deleteById(String id, Model m) {
        if (inputValidationService.isInputValid(id)) {
            if (videoRepo.findById(Long.parseLong(id)).isPresent()) {
                videoRepo.deleteById(Long.parseLong(id));
                messageService.adminActionSuccess(m);
            } else messageService.adminActionVideoNotFound(m);
        } else messageService.adminActionIncorrectData(m);
    }

    /**
     * Добавление отсортированного списка серий и сезонов.
     *
     * @param m страница куда положим этот список.
     */
    @Override
    public void list(Model m) {
        m.addAttribute("list", utilsService.findAllAndSort());
    }
}
