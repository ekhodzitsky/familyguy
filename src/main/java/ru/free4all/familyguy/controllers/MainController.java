package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.free4all.familyguy.entities.Moments;
import ru.free4all.familyguy.repos.MomentsRepo;
import ru.free4all.familyguy.service.VideoService;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    private final VideoService videoService;
    private final MomentsRepo momentsRepo;

    @Autowired
    public MainController(VideoService videoService, MomentsRepo momentsRepo) {
        this.videoService = videoService;
        this.momentsRepo = momentsRepo;
    }

    /**
     * Залогиниться.
     *
     * @return страница с формой логина.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String main(Model model) {
        videoService.getEpisode(model);
        return "index";
    }

    @GetMapping("/moments")
    public String moments(Model m) {
        List<Moments> momentsList = momentsRepo.findAll();
        if (!momentsList.isEmpty()) {
            m.addAttribute("moments", momentsList);
            m.addAttribute("moment", momentsList.get(momentsList.size() - 1));
        }
        return "moments";
    }

    @GetMapping("/moments/{id}")
    public String moment(@PathVariable("id") String id, Model model) {
        List<Moments> momentsList = momentsRepo.findAll();
        if (!momentsList.isEmpty()) {
            model.addAttribute("moments", momentsList);
        }
        Optional<Moments> moments = momentsRepo.findById(Long.parseLong(id));
        moments.ifPresent(m -> model.addAttribute("moment", m));
        return "moments";
    }

    @GetMapping("/authors")
    public String authors() {
        return "authors";
    }

    @GetMapping("/rights")
    public String rightHolders() {
        return "rights";
    }

    @GetMapping("/license")
    public String license() {
        return "license";
    }

    @GetMapping("/heroes")
    public String heroes() {
        return "heroes";
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

    @GetMapping("/season/{season}/episode/{episode}/{translation}")
    public String watch(@PathVariable int season, @PathVariable int episode, @PathVariable String translation, Model m) {
        videoService.getEpisode(episode, season, translation, m);
        return "index";
    }
}
