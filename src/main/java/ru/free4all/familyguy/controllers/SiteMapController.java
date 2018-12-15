package ru.free4all.familyguy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.free4all.familyguy.components.SiteMapView;

import javax.inject.Inject;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
public class SiteMapController {

    private SiteMapView view;

    @Inject
    public SiteMapController(SiteMapView view) {
        this.view = Objects.requireNonNull(view);
    }

    @RequestMapping(path = "/sitemap.xml", produces = APPLICATION_XML_VALUE)
    public SiteMapView create() {
        return view;
    }
}
