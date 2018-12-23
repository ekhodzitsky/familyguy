package ru.free4all.familyguy.service;


import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.free4all.familyguy.entities.Video;
import ru.free4all.familyguy.repos.VideoRepo;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class SiteMapService {

    private static final String BASE_URL = "http://www.familyguy.space";
    private static final String AUTHORS_URL = "http://www.familyguy.space/authors";
    private static final String HEROES_URL = "http://www.familyguy.space/heroes";

    private final VideoRepo videoRepo;

    @Autowired
    public SiteMapService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public String createSiteMap() throws MalformedURLException {
        WebSitemapGenerator siteMap = new WebSitemapGenerator(BASE_URL);
        siteMap.addUrl(BASE_URL);
        siteMap.addUrl(AUTHORS_URL);
        siteMap.addUrl(HEROES_URL);
        List<Video> list = videoRepo.findAll();
        if (!list.isEmpty()) {
            Set<Integer> seasons = new TreeSet<>();
            for (Video video : list) {
                siteMap.addUrl(BASE_URL + "/season/" + video.getSeason() + "/episode/" + video.getEpisode());
            }
            for (Video video : list) {
                seasons.add(video.getSeason());
            }
            for (Integer i : seasons) {
                siteMap.addUrl(BASE_URL + "/season/" + i);
            }
        }
        return String.join("", siteMap.writeAsStrings());
    }
}
