package ru.free4all.familyguy.interfaces.video;

public interface BasicVideoManagerExtended extends BasicVideoManager {
    /**
     * Добавить комментарий к видео.
     *
     * @param comment какой-то комментарий.
     * @param userID  id пользователя.
     * @param videoID id видео.
     */
    void comment(String comment, Long userID, Long videoID);

    /**
     * Проверяет коммент на всякие требования.
     *
     * @param comment какой-то комментарий пользователя.
     * @return true/false.
     */
    boolean validateComment(String comment);
}
