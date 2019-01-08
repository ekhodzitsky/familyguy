package ru.free4all.familyguy.interfaces;

import org.springframework.ui.Model;

public interface MomentsService {
    void add(String title, String iframe, Model m);
    void edit(String id, String title, String iframe, Model m);
    void remove(String id, Model m);
    void list(Model m);
}
