package ru.free4all.familyguy.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.free4all.familyguy.entities.Comment;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.repos.UserRepo;

import java.util.List;

@RestController()
@RequestMapping("/adminRest")
public class AdminRestController {

    @Autowired
    private UtilsService utilsService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getVideos")
    public List<Video> getVideos() {
        return utilsService.findAllAndSort();
    }

    @GetMapping("/getVideoComments/{id}")
    public List<Comment> getUsername(@PathVariable("id") Long id) {
        return utilsService.getIfExists(String.valueOf(id)).getComments();
    }
}
