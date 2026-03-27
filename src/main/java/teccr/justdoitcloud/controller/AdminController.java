package teccr.justdoitcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import teccr.justdoitcloud.data.User;
import teccr.justdoitcloud.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("user", new User());
        return "admin";
    }

    /*@PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/admin?success";
    }*/

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin?success";
    }
}

