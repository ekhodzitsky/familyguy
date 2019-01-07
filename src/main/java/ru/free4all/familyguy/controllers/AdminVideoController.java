package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.interfaces.AdminVideoService;
import ru.free4all.familyguy.interfaces.UtilsService;

@Controller
@RequestMapping("/admin")
public class AdminVideoController {

    private final AdminVideoService adminVideoService;
    private final UtilsService us;

    @Autowired
    public AdminVideoController(AdminVideoService adminVideoService, UtilsService us) {
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
}