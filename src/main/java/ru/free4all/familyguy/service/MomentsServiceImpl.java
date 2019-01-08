package ru.free4all.familyguy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Moments;
import ru.free4all.familyguy.interfaces.InputValidationService;
import ru.free4all.familyguy.interfaces.MessageService;
import ru.free4all.familyguy.interfaces.MomentsService;
import ru.free4all.familyguy.repos.MomentsRepo;

@Service
public class MomentsServiceImpl implements MomentsService {

    private final InputValidationService ivs;
    private final MessageService ms;
    private final MomentsRepo mr;

    @Autowired
    public MomentsServiceImpl(InputValidationService ivs, MessageService ms, MomentsRepo mr) {
        this.ivs = ivs;
        this.ms = ms;
        this.mr = mr;
    }

    @Override
    public void add(String title, String iframe, Model m) {
        if (ivs.isInputValid(title, iframe)) {
            Moments moments = new Moments();
            moments.setTitle(title);
            moments.setLink(iframe);
            mr.save(moments);
            ms.adminActionSuccess(m);
        } else {
            ms.adminActionIncorrectData(m);
        }
    }

    @Override
    public void edit(String id, String title, String iframe, Model m) {
        if (ivs.isInputValid(id) && mr.findById(Long.parseLong(id)).isPresent()) {
            Moments edit = mr.findById(Long.parseLong(id)).get();
            if (ivs.isInputValid(title)) edit.setTitle(title);
            if (ivs.isInputValid(iframe)) edit.setLink(iframe);
            mr.save(edit);
            ms.adminActionSuccess(m);
        } else {
            ms.adminActionIncorrectData(m);
        }
    }

    @Override
    public void remove(String id, Model m) {
        if (ivs.isInputValid(id) && mr.findById(Long.parseLong(id)).isPresent()) {
            mr.delete(mr.findById(Long.parseLong(id)).get());
            ms.adminActionSuccess(m);
        } else {
            ms.adminActionIncorrectData(m);
        }
    }

    @Override
    public void list(Model m) {
        m.addAttribute("moments", mr.findAll());
    }
}
