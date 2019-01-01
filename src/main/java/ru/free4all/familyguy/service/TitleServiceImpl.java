package ru.free4all.familyguy.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.interfaces.TitleService;

@Service
public class TitleServiceImpl implements TitleService {
    /**
     * Устанавливает заголовок страницы.
     *
     * @param model страница.
     */
    @Override
    public void setTitle(Model model) {
        String title = "Гриффины | Family guy | Все сезоны | Смотреть онлайн";
        model.addAttribute("title", title);
    }

    /**
     * Устанавливает заголовок страницы.
     *
     * @param season сезон.
     * @param model  страница.
     */
    @Override
    public void setTitle(int season, Model model) {
        String title = "Гриффины " + season + " сезон | Смотреть онлайн | Family guy | Семьянин";
        model.addAttribute("title", title);
    }

    /**
     * Устанавливает заголовок страницы.
     *
     * @param episode номер серии.
     * @param season  сезон.
     * @param model   страница.
     */
    @Override
    public void setTitle(int episode, int season, Model model) {
        String title = "Гриффины " + season + " сезон " + episode + " серия | Смотреть онлайн | Family guy | Семьянин";
        model.addAttribute("title", title);
    }

    /**
     * Устанавливает заголовок страницы.
     *
     * @param episode     номер серии.
     * @param season      сезон.
     * @param translation выбранный перевод.
     * @param model       страница.
     */
    @Override
    public void setTitle(int episode, int season, String translation, Model model) {
        String title = "Гриффины " + season + " сезон " + episode + " серия " + "| Озвучка " + translation + " | Смотреть онлайн | Family guy | Семьянин";
        model.addAttribute("title", title);
    }
}
