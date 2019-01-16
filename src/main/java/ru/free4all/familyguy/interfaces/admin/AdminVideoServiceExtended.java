package ru.free4all.familyguy.interfaces.admin;

import org.springframework.ui.Model;

public interface AdminVideoServiceExtended extends AdminVideoService {
    /**
     * Удалить ссылку на перевод у видео.
     *
     * @param id id по которому мы видео найдем.
     * @param t  перевод.
     * @param m  страница для визуального отображения результата действия.
     */
    void removeTranslation(String id, String t, Model m);
}
