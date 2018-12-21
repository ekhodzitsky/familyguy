package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;
import ru.free4all.familyguy.service.AdminService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VideoRepo videoRepo;

    @GetMapping("/admin")
    public String admin(Model m) {
        check();
        m.addAttribute("list", videoRepo.findAll());
        return "admin";
    }

    /**
     * To delete after first use :(
     */
    private void check(){
        String wrong = "height=\"100%";
        String correct = "height=\"100%\"";
        List<Video> videoList = videoRepo.findAll();
        for(Video v : videoList) {
            if(!v.getLink().contains(correct) && v.getLink().contains(wrong)) {
                String replaced = v.getLink().replace(wrong, correct);
                v.setLink(replaced);
                videoRepo.save(v);
            }
        }
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("episode") String e,
                         @RequestParam("season") String s,
                         @RequestParam("link") String l,
                         Model m) {
        adminService.upload(e, s, l, m);
        return "admin";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("episode") String e, @RequestParam("season") String s, Model m) {
        adminService.delete(e, s, m);
        return "admin";
    }

    @PostMapping("/deleteById")
    public String deleteById(@RequestParam("id") String id, Model m) {
        adminService.deleteById(id, m);
        return "admin";
    }
}
