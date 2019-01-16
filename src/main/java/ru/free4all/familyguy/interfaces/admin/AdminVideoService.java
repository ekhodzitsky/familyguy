package ru.free4all.familyguy.interfaces.admin;

import org.springframework.ui.Model;

public interface AdminVideoService {
    /**
     * Добавление видео в базу.
     *
     * @param e номер эпизода.
     * @param s номер сезона.
     * @param t перевод.
     * @param i ссылка на видео.
     * @param m страница для визуального отображения результата действия.
     */
    void addVideo(String e, String s, String t, String i, Model m);

    /**
     * Добавить перевод к видео (еще одна ссылка на другое видео с другим переводом).
     *
     * @param id id по которому мы видео найдем.
     * @param t  перевод.
     * @param i  ссылка на видео.
     * @param m  страница для визуального отображения результата действия.
     */
    void addTranslation(String id, String t, String i, Model m);

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
    void addNamesDescription(String id, String r, String e, String d, Model m);

    /**
     * Удаление видео по id.
     *
     * @param id id по которому мы найдем видео.
     * @param m  страница для отображения результата.
     */
    void deleteById(String id, Model m);

    /**
     * Добавление отсортированного списка серий и сезонов.
     *
     * @param m страница куда положим этот список.
     */
    void list(Model m);
}
