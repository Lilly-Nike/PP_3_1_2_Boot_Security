package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        return "user";
    }

    @GetMapping("/admin/add")
    public String getAddPage() {
        return "add_user";
    }

    @GetMapping("/admin/update/{id}")
    public String getUpdatePage(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));
        return "update_user";
    }

    @PostMapping("/admin/update")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/add")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
