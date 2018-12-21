package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.repos.VideoRepo;
import ru.free4all.familyguy.service.AdminService;

@Controller
public class AdminController {

    private final AdminService adminService;

    private final VideoRepo videoRepo;

    @Autowired
    public AdminController(AdminService adminService, VideoRepo videoRepo) {
        this.adminService = adminService;
        this.videoRepo = videoRepo;
    }

    @GetMapping("/admin")
    public String admin(Model m) {
        m.addAttribute("list", videoRepo.findAll());
        return "admin";
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
