package ru.free4all.familyguy.components;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import ru.free4all.familyguy.service.SiteMapService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Map;
import java.util.Objects;

@Component
public class SiteMapView extends AbstractView {

    private final SiteMapService service;

    @Inject
    public SiteMapView(SiteMapService service) {
        this.service = Objects.requireNonNull(service);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType(MediaType.APPLICATION_XML_VALUE);

        try (Writer writer = httpServletResponse.getWriter()) {
            writer.append(service.createSiteMap());
        }
    }
}
