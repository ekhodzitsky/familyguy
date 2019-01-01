package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.interfaces.AdminUserService;
import ru.free4all.familyguy.interfaces.AdminVideoService;

@Controller
public class AdminController {
    @Autowired
    private AdminVideoService adminVideoService;
    @Autowired
    private AdminUserService adminUserService;


    /**
     * Залогиниться.
     *
     * @return страница с формой логина.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Главная страница для администрирования.
     *
     * @param m модель.
     * @return страницу admin.ftl
     */
    @GetMapping("/admin")
    public String admin(Model m) {
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }


    /**
     * Добавление нового видоса.
     *
     * @param e номер эпизода.
     * @param s номер сезона.
     * @param l ссылка на видос.
     * @param t перевод.
     * @param m модель страницы.
     * @return страницу администрирования.
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("episode") String e,
                         @RequestParam("translation") String t,
                         @RequestParam("season") String s,
                         @RequestParam("link") String l,
                         Model m) {
        adminVideoService.addVideo(e, s, t, l, m);
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }

    /**
     * Добавление перевода.
     *
     * @param id id.
     * @param t  студия перевода.
     * @param i  ссылка на видео.
     * @param m  модель.
     * @return страницу администрирования.
     */
    @PostMapping("/add_translation")
    public String addTranslation(@RequestParam("id") String id,
                                 @RequestParam("translation") String t,
                                 @RequestParam("link") String i,
                                 Model m) {
        adminVideoService.addTranslation(id, t, i, m);
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
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
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
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
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }

    @PostMapping("/user_add")
    public String addUser(@RequestParam("username") String u, @RequestParam("password") String p, Model m) {
        adminUserService.add(u, p, m);
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }

    @PostMapping("/user_edit")
    public String editUser(@RequestParam("id") String id, @RequestParam("newUsername") String u, @RequestParam("newPassword") String p, Model m) {
        adminUserService.edit(id, u, p, m);
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }

    @PostMapping("/user_remove_by_id")
    public String removeUserById(@RequestParam("id") String id, Model m) {
        adminUserService.delete(id, m);
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }

    @PostMapping("/user_edit_role")
    public String editUserRole(@RequestParam("id") String id, @RequestParam("role") String r, Model m) {
        adminUserService.editRole(id, r, m);
        adminVideoService.list(m);
        adminUserService.list(m);
        return "admin";
    }
}