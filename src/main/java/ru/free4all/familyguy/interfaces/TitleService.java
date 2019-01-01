package ru.free4all.familyguy.interfaces;

import org.springframework.ui.Model;

public interface TitleService {
    /**
     * Устанавливает заголовок страницы.
     *
     * @param model страница.
     */
    void setTitle(Model model);

    /**
     * Устанавливает заголовок страницы.
     *
     * @param season сезон.
     * @param model  страница.
     */
    void setTitle(int season, Model model);

    /**
     * Устанавливает заголовок страницы.
     *
     * @param season  сезон.
     * @param episode номер серии.
     * @param model   страница.
     */
    void setTitle(int episode, int season, Model model);

    /**
     * Устанавливает заголовок страницы.
     *
     * @param season      сезон.
     * @param episode     номер серии.
     * @param translation выбранный перевод.
     * @param model       страница.
     */
    void setTitle(int episode, int season, String translation, Model model);
}
