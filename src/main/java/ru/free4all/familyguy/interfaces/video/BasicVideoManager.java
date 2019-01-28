package ru.free4all.familyguy.interfaces.video;

import org.springframework.ui.Model;

public interface BasicVideoManager {
    /**
     * Берет самую свежую серию сериала. Самую новую.
     * Устанавливает в зависимости от нее текущий сезон и серии этого сезона(список слева
     * на отображаемой странице).
     *
     * @param model страница.
     */
    public void getEpisode(Model model);

    /**
     * Пользователь выбирает сезон, загружается первая доступная серия этого сезона.
     * Устанавливается в зависимости от выбранного сезона список серий слева.
     *
     * @param season выбранный сезон.
     * @param model  страница.
     */
    public void getEpisode(int season, Model model);

    /**
     * Пользователь выбрал конкретную серию конкретного сезона. Загружается она.
     * Список серий слева в зависимости от выбранного сезона.
     *
     * @param episode выбранная серия.
     * @param season  выбранный сезон.
     * @param model   страница.
     */
    public void getEpisode(int episode, int season, Model model);

    /**
     * Пользователь выбрал конкретную серию конкретного сезона с определенным переводом.
     * Загружается она. Список серий слева в зависимости от выбранного сезона.
     *
     * @param episode     выбранная серия.
     * @param season      выбранный сезон.
     * @param translation выбранный перевод.
     * @param model       страница.
     */
    public void getEpisode(int episode, int season, String translation, Model model);
}
