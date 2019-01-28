package ru.free4all.familyguy.service.admin;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Comment;
import ru.free4all.familyguy.entities.Translation;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.interfaces.admin.AdminVideoServiceExtended;
import ru.free4all.familyguy.repos.CommentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminVideoServiceExtendedImpl extends AdminVideoServiceImpl implements AdminVideoServiceExtended {

    @Autowired
    private CommentRepo commentRepo;

    /**
     * Удалить ссылку на перевод у видео.
     *
     * @param id id по которому мы видео найдем.
     * @param t  перевод.
     * @param m  страница для визуального отображения результата действия.
     */
    @Override
    public void removeTranslation(String id, String t, Model m) {
        if (inputValidationService.isInputValid(id, t) && NumberUtils.isCreatable(id)) {
            Optional<Video> v = videoRepo.findById(Long.parseLong(id));
            v.ifPresent(video -> video.getLinks().remove(Translation.valueOf(t)));
            v.ifPresent(video -> videoRepo.save(video));
            messageService.adminActionSuccess(m);
        } else messageService.adminActionIncorrectData(m);
    }

    /**
     * Проверяет, если есть одинаковые комментарии под видео, удаляет дублирующиеся комменты.
     *
     * @param list список с видео.
     */
    @Override
    public void removeCommentDuplicates(List<Video> list) {
        for (Video video : list) {
            List<Comment> comments = video.getComments();
            List<Comment> clean = new ArrayList<>();
            for (Comment comment : comments) {
                if (!clean.contains(comment)) clean.add(comment);
            }
            // TODO разобраться с этим.
        }
    }

    /**
     * Удаляет комментарий.
     *
     * @param videoID   id видео.
     * @param commentID id коммента.
     * @param model     модель.
     */
    @Override
    public void removeComment(Long videoID, Long commentID, Model model) {
        Optional<Comment> c = commentRepo.findById(commentID);
        Video video = utilsService.getIfExists(String.valueOf(videoID));
        List<Comment> list = video.getComments();
        Comment toDel = null;
        for (Comment comment : list) {
            if (comment.getId().equals(commentID)) toDel = comment;
        }
        list.remove(toDel);
        video.setComments(list);
        videoRepo.save(video);
        c.ifPresent(comment -> commentRepo.delete(comment));
    }
}
