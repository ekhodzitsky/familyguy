package ru.free4all.familyguy.service.admin;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Translation;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.admin.AdminVideoServiceExtended;

import java.util.Optional;

@Service
public class AdminVideoServiceExtendedImpl extends AdminVideoServiceImpl implements AdminVideoServiceExtended {
    /**
     * Удалить ссылку на перевод у видео.
     *
     * @param id id по которому мы видео найдем.
     * @param t  перевод.
     * @param m  страница для визуального отображения результата действия.
     */
    @Override
    public void removeTranslation(String id, String t, Model m) {
        if (inputValidationService.isInputValid(id, t) && NumberUtils.isCreatable(id)) {
            Optional<Video> v = videoRepo.findById(Long.parseLong(id));
            v.ifPresent(video -> video.getLinks().remove(Translation.valueOf(t)));
            v.ifPresent(video -> videoRepo.save(video));
            messageService.adminActionSuccess(m);
        } else messageService.adminActionIncorrectData(m);
    }
}
