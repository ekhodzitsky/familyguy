package ru.free4all.familyguy.interfaces.admin;

import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Video;

import java.util.List;

public interface AdminVideoServiceExtended extends AdminVideoService {
    /**
     * Удалить ссылку на перевод у видео.
     *
     * @param id id по которому мы видео найдем.
     * @param t  перевод.
     * @param m  страница для визуального отображения результата действия.
     */
    void removeTranslation(String id, String t, Model m);

    /**
     * Проверяет, если есть одинаковые комментарии под видео, удаляет дублирующиеся комменты.
     *
     * @param list список с видео.
     */
    void removeCommentDuplicates(List<Video> list);

    /**
     * Удаляет комментарий.
     *
     * @param videoID   id видео.
     * @param commentID id коммента.
     * @param model     модель.
     */
    void removeComment(Long videoID, Long commentID, Model model);
}
