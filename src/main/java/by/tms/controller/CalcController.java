package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.CalcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

@Controller
@RequestMapping("/")
public class CalcController {
    CalcService service = new CalcService();

    @GetMapping("/calculator")
    public String calc() {
        return "calc";
    }

    @PostMapping("/calculator")
    public String calc(double num1, double num2, String operation, HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        Double result = service.getOperation(num1, num2, operation, user);
        LinkedList<Double> results = service.select(user);
        model.addAttribute("results", results);
        model.addAttribute("message", result);
        return "calc";
    }
}
