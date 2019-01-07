package ru.free4all.familyguy.interfaces;

import ru.free4all.familyguy.entities.Video;

import java.util.List;
import java.util.Set;

public interface UtilsService {
    /**
     * Проверяет, если такое видео существует.
     *
     * @param id id видео.
     * @return true/false.
     */
    boolean isVideoExists(String id);

    /**
     * Проверяет, если такое видео существует (используя номер сезона и номер серии).
     *
     * @param e - номер серии.
     * @param s - номер сезона.
     * @return true/false.
     */
    boolean isVideoExists(String e, String s);

    /**
     * Получаем видео если таковое есть.
     *
     * @param id id видео.
     * @return какое-то видео или null.
     */
    Video getIfExists(String id);

    /**
     * Проверяет, если такой пользователь существует.
     *
     * @param id id пользователя.
     * @return true/false.
     */
    boolean isUserExists(String id);

    /**
     * Проверяет, существует ли такой перевод у видео.
     *
     * @param video       какое-то видео.
     * @param translation перевод.
     * @return true/false.
     */
    boolean isTranslationExists(Video video, String translation);

    /**
     * Получаем список серий сезона.
     *
     * @param season какой-то сезон (его номер).
     * @return возвращаем список серий.
     */
    List<Video> getAvailableEpisodes(int season);

    /**
     * Получаем список сезонов в базе данных в виде сета чисел.
     *
     * @return по сути номера сезонов, которые есть в базе данных.
     */
    Set<Integer> getAvailableSeasons();

    /**
     * Получаем отсортированный список видосов всех что есть.
     *
     * @return список видео.
     */
    List<Video> findAllAndSort();

    /**
     * Получаем конкретный сезон уже отсортированный.
     *
     * @param season номер сезона.
     * @return список серий.
     */
    List<Video> getSortedSeason(int season);
}
