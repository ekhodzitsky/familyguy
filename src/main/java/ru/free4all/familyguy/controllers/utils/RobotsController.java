package ru.free4all.familyguy.controllers.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RobotsController {
    @RequestMapping(value = "/robots.txt")
    public void robots(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write(
                    "User-agent: *\n"
                            + "Disallow: /js\n"
                            + "Disallow: /css\n"
                            + "Disallow: /images\n"
                            + "Disallow: /login\n"
                            + "Disallow: /admin\n"
                            + "Disallow: /user\n"
                            + "Disallow: /license\n"
                            + "Disallow: /rights\n"
                            + "Sitemap: http://www.familyguy.space/sitemap.xml\n"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
