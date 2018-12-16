package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.free4all.familyguy.service.TitleService;
import ru.free4all.familyguy.service.VideoService;

@Controller
public class MainController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private TitleService titleService;

    @GetMapping("/")
    public String main(Model model) {
        videoService.getEpisode(model);
        titleService.setTitle(model);
        return "index";
    }

    @GetMapping("/season/{season}")
    public String season(@PathVariable int season, Model model) {
        titleService.setTitle(season, model);
        videoService.getEpisode(season, model);
        return "index";
    }

    @GetMapping("/season/{season}/episode/{episode}")
    public String watch(@PathVariable int season, @PathVariable int episode, Model model) {
        videoService.getEpisode(episode, season, model);
        titleService.setTitle(episode, season, model);
        return "index";
    }
}
