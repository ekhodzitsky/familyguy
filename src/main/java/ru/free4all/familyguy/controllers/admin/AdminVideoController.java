package ru.free4all.familyguy.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.free4all.familyguy.interfaces.UtilsService;
import ru.free4all.familyguy.interfaces.admin.AdminVideoServiceExtended;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminVideoController {

    private final AdminVideoServiceExtended adminVideoService;
    private final UtilsService us;

    @Autowired
    public AdminVideoController(AdminVideoServiceExtended adminVideoService, UtilsService us) {
        this.adminVideoService = adminVideoService;
        this.us = us;
    }

    /**
     * Главная страница для администрирования.
     *
     * @param m модель.
     * @return страницу администрирования с добавлением нового видео.
     */
    @GetMapping()
    public String admin(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/admin";
    }

    // TODO : TO DELETE :

    @GetMapping("/getRestList")
    public String restList(Model m){
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/video_details_vue";
    }

    // ----------------------------------

    /**
     * Получение таблицы конкретного сезона.
     *
     * @param season номер сезона.
     * @param m      страница.
     * @return возвращает список.
     */
    @GetMapping("/list/{season}")
    public String list(@PathVariable("season") String season, Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        m.addAttribute("season", us.getSortedSeason(Integer.parseInt(season)));
        return "blocks/admin/list";
    }

    /**
     * Добавление нового видоса.
     *
     * @param e номер эпизода.
     * @param s номер сезона.
     * @param l ссылка на видос.
     * @param t перевод.
     * @param m модель страницы.
     * @return страницу администрирования c формой добаления.
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("episode") String e,
                         @RequestParam("translation") String t,
                         @RequestParam("season") String s,
                         @RequestParam("link") String l,
                         Model m) {
        adminVideoService.addVideo(e, s, t, l, m);
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/admin";
    }

    @GetMapping("/translation")
    public String toTranslation(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/translation";
    }

    /**
     * Добавление перевода.
     *
     * @param id id.
     * @param t  студия перевода.
     * @param i  ссылка на видео.
     * @param m  модель.
     * @return страницу администрирования c формой изменения/добавления перевода.
     */
    @PostMapping("/add_translation")
    public String addTranslation(@RequestParam("id") String id,
                                 @RequestParam("translation") String t,
                                 @RequestParam("link") String i,
                                 Model m) {
        adminVideoService.addTranslation(id, t, i, m);
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/translation";
    }

    @GetMapping("/names")
    public String toNames(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/names";
    }

    /**
     * Добавление/редактирование описания и названий серии.
     *
     * @param id id.
     * @param r  русское название серии.
     * @param e  английское название серии.
     * @param d  описание.
     * @param m  модель.
     * @return страницу администрирования.
     */
    @PostMapping("/add_names_description")
    public String addNamesDescription(@RequestParam("id") String id,
                                      @RequestParam("rusName") String r,
                                      @RequestParam("engName") String e,
                                      @RequestParam("description") String d,
                                      Model m) {
        adminVideoService.addNamesDescription(id, r, e, d, m);
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/names";
    }

    @GetMapping("/remove")
    public String toRemove(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/remove";
    }

    /**
     * Удаление видео по id.
     *
     * @param id id.
     * @param m  модель.
     * @return страницу администрирования.
     */
    @PostMapping("/video_remove_by_id")
    public String deleteById(@RequestParam("id") String id, Model m) {
        adminVideoService.deleteById(id, m);
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/remove";
    }

    @GetMapping("/remove_translation")
    public String toRemoveTranslation(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/remove_translation";
    }

    /**
     * Удаление перевода.
     *
     * @param id    id видео.
     * @param t     перевод.
     * @param model страница.
     * @return страницу удаления перевода.
     */
    @PostMapping("/video_remove_translation")
    public String removeTranslation(@RequestParam("id") String id,
                                    @RequestParam("translation") String t,
                                    Model model) {
        adminVideoService.removeTranslation(id, t, model);
        model.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/remove_translation";
    }

    @PostMapping("/video_remove_translation/{id}/{translation}")
    public String removeTranslationDirectly(@PathVariable("id") String id,
                                            @PathVariable("translation") String t,
                                            Model model) {
        adminVideoService.removeTranslation(id, t, model);
        model.addAttribute("seasons", us.getAvailableSeasons());
        model.addAttribute("detailed", us.getIfExists(id));
        return "blocks/admin/video_details";
    }

    @GetMapping("/video_details/{id}")
    public String toVideoDetails(@PathVariable("id") String id, Model m) {
        m.addAttribute("detailed", us.getIfExists(id));
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/video_details";
    }

    @PostMapping("/remove_comment_by_id")
    public String removeCommentById(@RequestParam("videoID") String vid, @RequestParam("commentID") String cid, Model m){
        adminVideoService.removeComment(Long.parseLong(vid), Long.parseLong(cid), m);
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/comment_remove";
    }

    @GetMapping("/comment_remove")
    public String toRemoveCommentById(Model m){
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/comment_remove";
    }
}