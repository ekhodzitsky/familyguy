package ru.free4all.familyguy.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class TitleService {
    public void setTitle(Model model) {
        String title = "Гриффины все сезоны смотреть онлайн | Family guy | Семьянин";
        model.addAttribute("title", title);
    }

    public void setTitle(int season, Model model) {
        String title = "Гриффины " + season + " сезон смотреть онлайн | Family guy | Семьянин";
        model.addAttribute("title", title);
    }

    public void setTitle(int episode, int season, Model model) {
        String title = "Гриффины " + season + " сезон " + episode + " серия смотреть онлайн | Family guy | Семьянин";
        model.addAttribute("title", title);
    }
}
