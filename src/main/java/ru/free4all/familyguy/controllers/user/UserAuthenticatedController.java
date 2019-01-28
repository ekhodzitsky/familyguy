package ru.free4all.familyguy.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.entities.Comment;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.repos.CommentRepo;
import ru.free4all.familyguy.repos.VideoRepo;
import ru.free4all.familyguy.service.video.VideoServiceExtended;

import java.util.List;
import java.util.Optional;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class UserAuthenticatedController {

    private final UtilsService utilsService;
    private final VideoServiceExtended videoService;
    private final CommentRepo commentRepo;
    private final VideoRepo videoRepo;

    @Autowired
    public UserAuthenticatedController(UtilsService utilsService, VideoServiceExtended videoService,
                                       CommentRepo commentRepo, VideoRepo videoRepo) {
        this.utilsService = utilsService;
        this.videoService = videoService;
        this.commentRepo = commentRepo;
        this.videoRepo = videoRepo;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/remove_comment/{commentID}/{videoID}")
    public String removeComment(@PathVariable ("commentID") String commentID,
                                @PathVariable ("videoID") String videoID,
                                Model model){
        Optional<Comment> c = commentRepo.findById(Long.parseLong(commentID));
        Video video = utilsService.getIfExists(videoID);
        if(c.isPresent()){
            List<Comment> list = video.getComments();
            list.remove(c.get());
            video.setComments(list);
            videoRepo.save(video);
            commentRepo.delete(c.get());
        }
        videoService.getEpisode(video.getEpisode(), video.getSeason(), model);
        return "index";
    }
}
