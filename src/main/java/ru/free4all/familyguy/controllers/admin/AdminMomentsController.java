package ru.free4all.familyguy.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.free4all.familyguy.interfaces.MomentsService;
import ru.free4all.familyguy.interfaces.UtilsService;

@Controller
@RequestMapping("/admin/moments/")
public class AdminMomentsController {

    private final UtilsService us;
    private final MomentsService ms;

    @Autowired
    public AdminMomentsController(UtilsService us, MomentsService ms) {
        this.us = us;
        this.ms = ms;
    }

    @PostMapping("add")
    public String add(@RequestParam("title") String title, @RequestParam("link") String link, Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        ms.add(title, link, m);
        return "blocks/admin/moments_add_new";
    }

    @PostMapping("edit")
    public String edit(@RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("link") String link, Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        ms.edit(id, title, link, m);
        return "blocks/admin/moments_edit";
    }

    @PostMapping("remove")
    public String remove(@RequestParam("id") String id, Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        ms.remove(id, m);
        return "blocks/admin/moments_remove";
    }

    @GetMapping("add_page")
    public String getAddPage(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/moments_add_new";
    }

    @GetMapping("edit_page")
    public String getEditPage(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/moments_edit";
    }

    @GetMapping("remove_page")
    public String getRemovePage(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        return "blocks/admin/moments_remove";
    }

    @GetMapping("list_page")
    public String getListPage(Model m) {
        m.addAttribute("seasons", us.getAvailableSeasons());
        ms.list(m);
        return "blocks/admin/moments_list";
    }
}
