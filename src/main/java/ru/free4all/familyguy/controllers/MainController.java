package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class MainController {

    @Autowired
    private VideoRepo videoRepo;

    @GetMapping("/")
    public String main(Model model) {
        List<Video> videoList = videoRepo.findAll();
        Set<Integer> seasons = new TreeSet<>();
        for (Video v : videoList) seasons.add(v.getSeason());
        model.addAttribute("seasons", seasons);
        if (seasons.isEmpty()) model.addAttribute("seasons", null);
        return "main";
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
        video(season, 0, model);
        return "season";
    }

    @GetMapping("/season/{season}/episode/{episode}")
    public String watch(@PathVariable int season, @PathVariable int episode, Model model) {
        video(season, episode, model);
        return "season";
    }

    private void video(int season, int episode, Model model) {
        List<Video> videoList = videoRepo.findAll();
        Set<Integer> episodes = new TreeSet<>();
        for (Video v : videoList) {
            if (v.getSeason() == season) episodes.add(v.getEpisode());
        }
        model.addAttribute("episodes", episodes);
        model.addAttribute("season", season);
        if (episode >= 1) {
            model.addAttribute("link", videoRepo.findByEpisodeAndSeason(episode, season).getLink());
        } else {
            model.addAttribute("link", videoRepo.findByEpisodeAndSeason(episodes.iterator().next(), season).getLink());
        }
    }
}
