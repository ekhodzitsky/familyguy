package ru.free4all.familyguy.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.service.video.VideoServiceExtended;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class UserAuthenticatedController {

    private final UtilsService utilsService;
    private final VideoServiceExtended videoService;

    @Autowired
    public UserAuthenticatedController(UtilsService utilsService, VideoServiceExtended videoService) {
        this.utilsService = utilsService;
        this.videoService = videoService;
    }

    @GetMapping("/add_comment")
    public String comment(@RequestParam("comment") String c,
                          @RequestParam("user_id") String userID,
                          @RequestParam("video_id") String videoID,
                          Model model) {
        Video video = utilsService.getIfExists(videoID);
        videoService.comment(c, Long.parseLong(userID), video.getId());
        videoService.getEpisode(video.getEpisode(), video.getSeason(), model);
        return "index";
    }
}
