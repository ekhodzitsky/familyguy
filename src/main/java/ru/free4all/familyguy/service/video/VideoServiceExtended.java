package ru.free4all.familyguy.service.video;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.free4all.familyguy.entities.Comment;
import ru.free4all.familyguy.entities.User;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.video.BasicVideoManagerExtended;
import ru.free4all.familyguy.repos.CommentRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoServiceExtended extends VideoService implements BasicVideoManagerExtended {

    /**
     * Максимальная длинна комментария.
     */
    private static final int COMMENT_MAX_LENGTH = 300;
    /**
     * Максимальная длинна слова.
     */
    private static final int COMMENT_MAX_WORD_LENGTH = 30;
    /**
     * Что нельзя использовать в комментарии.
     */
    private static final char[] FORBIDDEN_CHARS = {'/', '*', '_', '\\', '^', '<', '>', '@', '[', ']', '{', '}', '|'};

    @Autowired
    private CommentRepo commentRepo;

    /**
     * Добавить комментарий к видео.
     *
     * @param comment какой-то комментарий.
     * @param userID  id пользователя.
     * @param videoID id видео.
     */
    @Override
    public void comment(String comment, Long userID, Long videoID) {
        if (validateComment(comment) && Strings.isNotEmpty(comment)) {
            Video video = utilsService.getIfExists(String.valueOf(videoID));
            User user = utilsService.getUserIfExists(String.valueOf(userID));
            if (isAllowedByDate(video, user) && validateComment(comment)) {
                Comment c = new Comment();
                c.setAuthorID(userID);
                c.setAuthorName(user.getUsername());
                c.setValue(comment);
                c.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
                commentRepo.save(c);
                video.getComments().add(c);
                videoRepo.save(video);
            }
        }
    }

    /**
     * Проверяет коммент на всякие требования.
     *
     * @param value какой-то комментарий пользователя.
     * @return true/false.
     */
    @Override
    public boolean validateComment(String value) {
        boolean result = true;
        if (value.length() > COMMENT_MAX_LENGTH) result = false;
        for (String s : value.split(" ")) {
            if (s.length() > COMMENT_MAX_WORD_LENGTH) result = false;
        }
        if (!checkForbiddenSymbols(value)) result = false;
        return result;
    }

    /**
     * Validation of forbidden chars.
     *
     * @param s some string (comment).
     * @return true/false.
     */
    private boolean checkForbiddenSymbols(String s) {
        boolean result = true;
        for (char c : s.toCharArray()) {
            for (char ch : FORBIDDEN_CHARS) {
                if (c == ch) result = false;
            }
        }
        return result;
    }

    /**
     * Пользователь может оставить под одним видео только один комментарий в час.
     *
     * @param video видео.
     * @param user  пользователь.
     * @return true/false.
     */
    private boolean isAllowedByDate(Video video, User user) {
        boolean result = true;
        List<Comment> comments = video.getComments();
        if (comments.size() >= 1) {
            Timestamp current = Timestamp.valueOf(LocalDateTime.now());
            for (Comment c : comments) {
                if (isDatesTooNear(current.toLocalDateTime(), c.getCreationDate().toLocalDateTime())
                        && user.getId().equals(c.getAuthorID())) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isDatesTooNear(LocalDateTime a, LocalDateTime b) {
        boolean result = false;
        if (a.getYear() == b.getYear()
                && a.getMonth() == b.getMonth()
                && a.getDayOfMonth() == b.getDayOfMonth()
                && a.getHour() == b.getHour()) result = true;
        return result;
    }
}
