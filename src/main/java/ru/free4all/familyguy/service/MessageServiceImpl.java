package ru.free4all.familyguy.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.interfaces.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private static final String ADMIN_ACTION_RESULT = "message";
    private static final String ADMIN_ACTION_SUCCESS = "Действие совершено успешно.";
    private static final String ADMIN_ACTION_INCORRECT_DATA = "Введены некорректные данные. Действие не совершено.";
    private static final String ADMIN_ACTION_VIDEO_EXISTS = "Такое видео уже существует. Действие не совершено.";
    private static final String ADMIN_ACTION_USER_EXISTS = "Такой пользователь уже существует. Действие не совершено.";
    private static final String ADMIN_ACTION_VIDEO_NOT_FOUND = "Видео не найдено.";
    private static final String ADMIN_ACTION_USER_NOT_FOUND = "Пользователь не найден.";
    private static final String ADMIN_ACTION_TRANSLATION_EXISTS = "Такой перевод уже есть. Действие не совершено.";

    /**
     * Добавляет результат действия на страничку. Действие совершено успешно.
     *
     * @param model страница куда добавляется результат.
     */
    @Override
    public void adminActionSuccess(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_SUCCESS);
    }

    /**
     * Добавляет результат действия на страничку. Какие-то данные некорректны.
     *
     * @param model страница куда добавляется результат.
     */
    @Override
    public void adminActionIncorrectData(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_INCORRECT_DATA);
    }

    /**
     * Добавляет результат действия на страничку. Такое видео уже есть.
     *
     * @param model страница куда добавляется результат.
     */
    @Override
    public void adminActionVideoExists(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_VIDEO_EXISTS);
    }

    /**
     * Добавляет результат действия на страничку. Такой пользователь уже есть.
     *
     * @param model страница куда добавляется результат.
     */
    @Override
    public void adminActionUserExists(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_USER_EXISTS);
    }

    /**
     * Добавляет результат действия на страничку. Видео не найдено.
     *
     * @param model страница куда добавляется результат.
     */
    @Override
    public void adminActionVideoNotFound(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_VIDEO_NOT_FOUND);
    }

    /**
     * Добавляет результат действия на страничку. Пользователь не найден.
     *
     * @param model страница куда добавляется результат.
     */
    @Override
    public void adminActionUserNotFound(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_USER_NOT_FOUND);
    }

    /**
     * Сообщает что такой перевод уже есть.
     *
     * @param model модель страницы.
     */
    @Override
    public void adminTranslationExists(Model model) {
        model.addAttribute(ADMIN_ACTION_RESULT, ADMIN_ACTION_TRANSLATION_EXISTS);
    }
}
