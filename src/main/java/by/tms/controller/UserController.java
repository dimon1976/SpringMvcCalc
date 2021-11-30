package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.CalcService;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService = new UserService();
    private final CalcService calcService = new CalcService();

    @GetMapping("/authorization")
    public String auth() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public String auth(String username, String password, HttpSession httpSession, Model model) {
        User byUsername = userService.findByUsername(username);
        if (byUsername != null) {
            if (byUsername.getPassword().equals(password)) {
                ArrayList<User> userList = userService.findAllUsers();
                httpSession.setAttribute("user", byUsername);
                httpSession.setAttribute("users", userList);
                return "home";
            } else {
                model.addAttribute("message", "Wrong password!");
            }
        } else {
            model.addAttribute("message", "User not found!");
        }
        return "authorization";
    }


    @GetMapping("/register")
    public String reg() {
        return "register";
    }

    @PostMapping("/register")
    public String reg(User user, Model model) {
        if (!user.getName().isEmpty()) {
            if (!user.getUserName().isEmpty()) {
                if (!user.getPassword().isEmpty()) {
                    if (!userService.register(user)) {
                        model.addAttribute("message", "This login exists");
                    } else {
                        model.addAttribute("message", "Are you registered. Please log in.");
                        return "authorization";
                    }
                } else {
                    model.addAttribute("message", "password is NULL");
                }
            } else {
                model.addAttribute("message", "Login is NULL");
            }
        } else {
            model.addAttribute("message", "Name is NULL");
        }
        return "register";
    }


    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(String name, String username, String password, HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        User newUser = userService.editUser(user, name, username, password);
        model.addAttribute("user", newUser);
        model.addAttribute("message", "User updated");
        return "home";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        userService.deleteUser(user);
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/adminmenu")
    public String adminMenu() {
        return "adminmenu";
    }

    @PostMapping("/adminmenu")
    public String adminMenu(String operation, long userId, Model model,HttpSession httpSession) {
        userService.useAdminMenu(operation, userId);
        User user = (User) httpSession.getAttribute("user");
        List<User> userList = userService.findAllUsers();
        LinkedList<Double> results = calcService.select(user);
        model.addAttribute("results", results);
        model.addAttribute("users", userList);
        model.addAttribute("userid", userId);
        model.addAttribute("operation", operation);
        return "adminmenu";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession, Model model) {
        httpSession.invalidate();
        model.addAttribute("message", "You are logged off");
        return "redirect:/";
    }
}
