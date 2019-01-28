package ru.free4all.familyguy.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Video {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Num of episode.
     */
    private Integer episode;

    /**
     * Num of season.
     */
    private Integer season;

    /**
     * Ссылка на видео на сторонний хостинг.
     */
    private String link;

    /**
     * Русское название серии.
     */
    private String rusName;

    /**
     * Английское название серии.
     */
    private String engName;

    /**
     * Описание серии.
     */
    private String description;

    /**
     * Ключ-значение: перевод-ссылка. По enum достается ссылка на определенный перевод серии.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "video_id")
    @MapKeyColumn(name = "translation")
    private Map<Enum<Translation>, String> links;

    /**
     * Список комментариев под видео.
     */
    @ElementCollection(targetClass = Comment.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "video_comments")
    private List<Comment> comments;

    /**
     * Дефолтный конструктор.
     */
    public Video() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Enum<Translation>, String> getLinks() {
        return links;
    }

    public void setLinks(Map<Enum<Translation>, String> links) {
        this.links = links;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
