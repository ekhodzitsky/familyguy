package ru.free4all.familyguy.service;


import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.free4all.familyguy.entities.Translation;
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
    private static final String SEASON = "/season/";
    private static final String EPISODE = "/episode/";

    private static final Enum[] TRANSLATIONS = {
            Translation.FILIZA,
            Translation.COLDFILM,
            Translation.JASKIER,
            Translation.OMSKBIRD,
            Translation.SUNSHINE
    };

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
                siteMap.addUrl(BASE_URL + SEASON + video.getSeason() + EPISODE + video.getEpisode());
            }
            for (Video video : list) {
                seasons.add(video.getSeason());
            }
            for (Integer i : seasons) {
                siteMap.addUrl(BASE_URL + SEASON + i);
            }
            for (Video video : list) {
                if (!video.getLinks().isEmpty()) {
                    for (Enum e : TRANSLATIONS) {
                        if (video.getLinks().containsKey(e)) {
                            siteMap.addUrl(BASE_URL + SEASON + video.getSeason() + EPISODE + video.getEpisode() + "/" + e.name());
                        }
                    }
                }
            }
        }
        return String.join("", siteMap.writeAsStrings());
    }
}
