package ru.free4all.familyguy.controllers;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

@Controller
public class VideoController {

    @Autowired
    private VideoRepo videoRepo;

    @PostMapping("/upload")
    public String upload(@RequestParam("episode") String e, @RequestParam("season") String s, @RequestParam("link") String l) {
        if (e != null && s != null && l != null) {
            if (NumberUtils.isCreatable(e) && NumberUtils.isCreatable(s)) {
                Video v = new Video();
                v.setEpisode(Integer.parseInt(e));
                v.setSeason(Integer.parseInt(s));
                v.setLink(l);
                videoRepo.save(v);
            }
        }
        return "admin";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("episode") String e, @RequestParam("season") String s) {
        if (e != null && s != null) {
            if (NumberUtils.isCreatable(e) && NumberUtils.isCreatable(s)) {
                Video v = videoRepo.findByEpisodeAndSeason(Integer.parseInt(e), Integer.parseInt(s));
                if (v != null) {
                    videoRepo.delete(v);
                }
            }
        }
        return "admin";
    }
}
