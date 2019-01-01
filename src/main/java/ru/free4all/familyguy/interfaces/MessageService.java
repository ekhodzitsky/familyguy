package ru.free4all.familyguy.interfaces;

import org.springframework.ui.Model;

public interface MessageService {
    /**
     * Добавляет результат действия на страничку. Действие совершено успешно.
     *
     * @param model страница куда добавляется результат.
     */
    void adminActionSuccess(Model model);

    /**
     * Добавляет результат действия на страничку. Какие-то данные некорректны.
     *
     * @param model страница куда добавляется результат.
     */
    void adminActionIncorrectData(Model model);

    /**
     * Добавляет результат действия на страничку. Такое видео уже есть.
     *
     * @param model страница куда добавляется результат.
     */
    void adminActionVideoExists(Model model);

    /**
     * Добавляет результат действия на страничку. Такой пользователь уже есть.
     *
     * @param model страница куда добавляется результат.
     */
    void adminActionUserExists(Model model);

    /**
     * Добавляет результат действия на страничку. Видео не найдено.
     *
     * @param model страница куда добавляется результат.
     */
    void adminActionVideoNotFound(Model model);

    /**
     * Добавляет результат действия на страничку. Пользователь не найден.
     *
     * @param model страница куда добавляется результат.
     */
    void adminActionUserNotFound(Model model);

    /**
     * Сообщает что такой перевод уже есть.
     *
     * @param model модель страницы.
     */
    void adminTranslationExists(Model model);
}
