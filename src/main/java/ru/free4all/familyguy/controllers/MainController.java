package ru.free4all.familyguy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.entities.Moments;
import ru.free4all.familyguy.interfaces.admin.AdminUserService;
import ru.free4all.familyguy.repos.MomentsRepo;
import ru.free4all.familyguy.service.video.VideoServiceExtended;

import java.util.List;
import java.util.Optional;

/**
 * Это главный контроллер, который выдает нам нужные серии и нарезки из серий, также отдает простые страницы,
 * чтобы попасть на которые не нужна регистрация. Ну и он же может зарегистрировать нового пользователя.
 */
@Controller
public class MainController {

    private final VideoServiceExtended videoService;
    private final MomentsRepo momentsRepo;
    private final AdminUserService adminUserService;

    @Autowired
    public MainController(VideoServiceExtended videoService,
                          MomentsRepo momentsRepo,
                          AdminUserService adminUserService) {
        this.videoService = videoService;
        this.momentsRepo = momentsRepo;
        this.adminUserService = adminUserService;
    }

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
     * Перейти на страницу регистрации.
     *
     * @return страницу с формой регистрации.
     */
    @GetMapping("/registration")
    public String toRegistration() {
        return "registration";
    }

    /**
     * Регистрация пользователя.
     *
     * @param u     имя.
     * @param p     пароль.
     * @param c     повторить пароль.
     * @param model страница.
     * @return возвращает эту же страницу.
     */
    @PostMapping("/register")
    public String register(@RequestParam("username") String u,
                           @RequestParam("password") String p,
                           @RequestParam("password_confirm") String c,
                           Model model) {
        adminUserService.add(u, p, c, model);
        return "registration";
    }

    /**
     * Главная страница.
     *
     * @param model страница.
     * @return главную.
     */
    @GetMapping("/")
    public String main(Model model) {
        videoService.getEpisode(model);
        return "index";
    }

    /**
     * На страницу с нарезками видео.
     *
     * @param m модель.
     * @return страницу с нарезками.
     */
    @GetMapping("/moments")
    public String moments(Model m) {
        List<Moments> momentsList = momentsRepo.findAll();
        if (!momentsList.isEmpty()) {
            m.addAttribute("moments", momentsList);
            m.addAttribute("moment", momentsList.get(momentsList.size() - 1));
        }
        return "moments";
    }

    /**
     * Страницу с какой-то конкретной нарезкой.
     *
     * @param id    id нарезки.
     * @param model модель страницы.
     * @return страницу с нарезкой.
     */
    @GetMapping("/moments/{id}")
    public String moment(@PathVariable("id") String id, Model model) {
        List<Moments> momentsList = momentsRepo.findAll();
        if (!momentsList.isEmpty()) {
            model.addAttribute("moments", momentsList);
        }
        Optional<Moments> moments = momentsRepo.findById(Long.parseLong(id));
        moments.ifPresent(m -> model.addAttribute("moment", m));
        return "moments";
    }

    /**
     * На страницу с авторами сериала.
     */
    @GetMapping("/authors")
    public String authors() {
        return "authors";
    }

    /**
     * На страницу с правообладателями.
     *
     * @return правообладателей.
     */
    @GetMapping("/rights")
    public String rightHolders() {
        return "rights";
    }

    /**
     * На страницу с пользовательским соглашением.
     *
     * @return страницу пользовательского соглашения.
     */
    @GetMapping("/license")
    public String license() {
        return "license";
    }

    /**
     * На страницу с персонажами.
     *
     * @return страницу с персонажами.
     */
    @GetMapping("/heroes")
    public String heroes() {
        return "heroes";
    }

    /**
     * Главная страница с определенным сезоном.
     *
     * @param season какой-то сезон.
     * @param model  модель.
     * @return главную страницу с определенным сезоном.
     */
    @GetMapping("/season/{season}")
    public String season(@PathVariable int season, Model model) {
        videoService.getEpisode(season, model);
        return "index";
    }

    /**
     * Главная страница с определенной серией какого-то сезона.
     *
     * @param season  сезон.
     * @param episode эпизод.
     * @param model   модель.
     * @return главную страницу с серией.
     */
    @GetMapping("/season/{season}/episode/{episode}")
    public String watch(@PathVariable int season, @PathVariable int episode, Model model) {
        videoService.getEpisode(episode, season, model);
        return "index";
    }

    /**
     * Главная страница с определенной серией какого-то сезона и конкретным выбранным переводом.
     *
     * @param season      сезон.
     * @param episode     серия.
     * @param translation перевод.
     * @param m           модель.
     * @return главную страницу с выбранной серией.
     */
    @GetMapping("/season/{season}/episode/{episode}/{translation}")
    public String watch(@PathVariable int season, @PathVariable int episode, @PathVariable String translation, Model m) {
        videoService.getEpisode(episode, season, translation, m);
        return "index";
    }
}
