package by.tms.controller;

import by.tms.entity.History;
import by.tms.entity.User;
import by.tms.service.CalcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

@Controller
@RequestMapping("/calc")
public class CalcController {
    CalcService service = new CalcService();

    @GetMapping
    public String calc() {
        return "calc";
    }

    @PostMapping("/")
    public String calc(double num1, double num2, String operation, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        Double result = service.start(num1, num2, operation, user);
        LinkedList<History> results = service.select(user.getId());
        httpSession.setAttribute("results", results);
        httpSession.setAttribute("message", result);
        return "calc";
    }
}
