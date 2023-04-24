package ru.spring.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.spring_boot.model.User;
import ru.spring.spring_boot.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getlistUsers());
        return "showUsers";
    }

    @GetMapping("/{id}")
    public String showId(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.showId(id));
        return "showId";
    }

    @GetMapping("/new")
    public String addUserPage(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserPage(@ModelAttribute("user") User user) {
        return "updateUser";
    }

    @PatchMapping()
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
