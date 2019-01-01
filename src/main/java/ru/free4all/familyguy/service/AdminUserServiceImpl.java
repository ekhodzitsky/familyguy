package ru.free4all.familyguy.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Role;
import ru.free4all.familyguy.entities.User;
import ru.free4all.familyguy.interfaces.AdminUserService;
import ru.free4all.familyguy.interfaces.InputValidationService;
import ru.free4all.familyguy.interfaces.MessageService;
import ru.free4all.familyguy.repos.UserRepo;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private InputValidationService inputValidationService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void add(String u, String p, Model m) {
        if (inputValidationService.isInputValid(u, p)) {
            if (userRepo.findByUsername(u) == null) {
                User user = new User();
                user.setUsername(u);
                user.setPassword(passwordEncoder.encode(p));
                userRepo.save(user);
                messageService.adminActionSuccess(m);
            } else messageService.adminActionUserExists(m);
        } else messageService.adminActionIncorrectData(m);
    }

    @Override
    public void edit(String id, String u, String p, Model m) {
        if (inputValidationService.isInputValid(id) && NumberUtils.isCreatable(id)) {
            if (userRepo.findById(Long.parseLong(id)).isPresent()) {
                User user = userRepo.findById(Long.parseLong(id)).get();
                if (inputValidationService.isInputValid(u) && userRepo.findByUsername(u) == null) user.setUsername(u);
                if (inputValidationService.isInputValid(p)) user.setPassword(passwordEncoder.encode(p));
                userRepo.save(user);
                messageService.adminActionSuccess(m);
            } else messageService.adminActionUserNotFound(m);
        } else messageService.adminActionIncorrectData(m);
    }

    @Override
    public void editRole(String id, String r, Model m) {
        if (inputValidationService.isInputValid(id, r)) {
            if (userRepo.findById(Long.parseLong(id)).isPresent()) {
                User user = userRepo.getOne(Long.parseLong(id));
                Set<Role> role = new HashSet<>();
                role.add(Role.valueOf(r));
                user.setRoles(role);
                userRepo.save(user);
                messageService.adminActionSuccess(m);
            } else messageService.adminActionUserNotFound(m);
        } else messageService.adminActionIncorrectData(m);
    }

    @Override
    public void delete(String id, Model m) {
        if (inputValidationService.isInputValid(id) && NumberUtils.isCreatable(id)) {
            if (userRepo.findById(Long.parseLong(id)).isPresent()) {
                userRepo.deleteById(Long.parseLong(id));
                messageService.adminActionSuccess(m);
            } else messageService.adminActionUserNotFound(m);
        } else messageService.adminActionIncorrectData(m);
    }

    @Override
    public void list(Model m) {
        m.addAttribute("user_list", userRepo.findAll());
    }
}
