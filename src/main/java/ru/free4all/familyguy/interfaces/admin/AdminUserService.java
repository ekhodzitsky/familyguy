package ru.free4all.familyguy.interfaces.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
    /**
     * Добавляет нового юзера в базу.
     *
     * @param u имя.
     * @param p пароль.
     * @param c повторить пароль.
     * @param m модель страницы.
     */
    void add(String u, String p, String c, Model m);

    void edit(String id, String u, String p, Model m);

    void editRole(String id, String r, Model m);

    void addRole(String id, String r, Model m);

    void delete(String id, Model m);

    void list(Model m);
}
