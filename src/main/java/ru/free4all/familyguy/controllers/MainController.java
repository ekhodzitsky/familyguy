package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.free4all.familyguy.service.VideoService;

@Controller
public class MainController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public String main(Model model) {
        videoService.getEpisode(model);
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/season/{season}")
    public String season(@PathVariable int season, Model model) {
        videoService.getEpisode(season, model);
        return "index";
    }

    @GetMapping("/season/{season}/episode/{episode}")
    public String watch(@PathVariable int season, @PathVariable int episode, Model model) {
        videoService.getEpisode(episode, season, model);
        return "index";
    }
}
