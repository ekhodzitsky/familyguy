package ru.free4all.familyguy.service.admin;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.free4all.familyguy.entities.Role;
import ru.free4all.familyguy.entities.User;
import ru.free4all.familyguy.interfaces.admin.AdminUserService;
import ru.free4all.familyguy.interfaces.InputValidationService;
import ru.free4all.familyguy.interfaces.MessageService;
import ru.free4all.familyguy.repos.UserRepo;

import java.util.Collections;
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

    private static final int MIN_PASSWORD_SIZE = 6;
    private static final String UK_FORM_DANGER = "uk-form-danger";
    private static final String FAIL_USERNAME = "cr_fail_username";
    private static final String FAIL_PASSWORD = "cr_fail_password";
    private static final String FAIL_CONFIRM = "cr_fail_confirm";
    private static final String FAIL_MESSAGE = "cr_fail_message";
    private static final String FAIL_MESSAGE_FAIL = "Проверьте правильность введенных данных.";

    /**
     * Добавляет нового юзера в базу.
     *
     * @param u имя.
     * @param p пароль.
     * @param c повторить пароль.
     * @param m модель страницы.
     */
    @Override
    public void add(String u, String p, String c, Model m) {
        if (inputValidationService.isInputValid(u, p, c)
                && userRepo.findByUsername(u) == null
                && p.length() >= MIN_PASSWORD_SIZE
                && p.equals(c)) {
            User user = new User();
            user.setUsername(u);
            user.setPassword(passwordEncoder.encode(p));
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
            m.addAttribute("cr_success", "Регистрация прошла успешно.");
        } else if (inputValidationService.isInputValid(u, p, c) && userRepo.findByUsername(u) != null) {
            m.addAttribute(FAIL_MESSAGE, "Пользователь с именем \"" + u + "\" уже существует.");
            m.addAttribute(FAIL_USERNAME, UK_FORM_DANGER);
        }
        if (!inputValidationService.isInputValid(u)) {
            m.addAttribute(FAIL_USERNAME, UK_FORM_DANGER);
            m.addAttribute(FAIL_MESSAGE, FAIL_MESSAGE_FAIL);
        }
        if (!inputValidationService.isInputValid(p)) {
            m.addAttribute(FAIL_PASSWORD, UK_FORM_DANGER);
            m.addAttribute(FAIL_MESSAGE, FAIL_MESSAGE_FAIL);
        }
        if (!inputValidationService.isInputValid(c)) {
            m.addAttribute(FAIL_CONFIRM, UK_FORM_DANGER);
            m.addAttribute(FAIL_MESSAGE, FAIL_MESSAGE_FAIL);
        }
        if (!p.equals(c)) {
            m.addAttribute(FAIL_PASSWORD, UK_FORM_DANGER);
            m.addAttribute(FAIL_CONFIRM, UK_FORM_DANGER);
            m.addAttribute(FAIL_MESSAGE, "Пароли не совпали!");
        }
        if (inputValidationService.isInputValid(u, p, c) && p.length() < MIN_PASSWORD_SIZE) {
            m.addAttribute(FAIL_PASSWORD, UK_FORM_DANGER);
            m.addAttribute(FAIL_CONFIRM, UK_FORM_DANGER);
            m.addAttribute(FAIL_MESSAGE, "Минимум 6 символов для пароля!");
        }
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
    public void addRole(String id, String r, Model m) {
        if (inputValidationService.isInputValid(id, r)) {
            if (userRepo.findById(Long.parseLong(id)).isPresent()) {
                User user = userRepo.getOne(Long.parseLong(id));
                Set<Role> newRoles = new HashSet<>();
                newRoles.add(Role.ADMIN);
                newRoles.add(Role.USER);
                user.setRoles(newRoles);
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
