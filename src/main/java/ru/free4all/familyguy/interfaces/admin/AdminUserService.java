package ru.free4all.familyguy.interfaces.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
    void add(String u, String p, Model m);
    void edit(String id, String u, String p, Model m);
    void editRole(String id, String r, Model m);
    void delete(String id, Model m);
    void list(Model m);
}
