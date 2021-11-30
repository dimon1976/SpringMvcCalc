package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class CalcService {
    InMemoryUserStorage storage;

    public Double getOperation(double num1, double num2, String op, User user) {
        switch (op) {
            case "+":
                storage.save((sum(num1, num2)), user);
                return sum(num1, num2);
            case "-":
                storage.save((sub(num1, num2)), user);
                return sub(num1, num2);
            case "*":
                storage.save((multi(num1, num2)), user);
                return multi(num1, num2);
            case "/":
                storage.save((division(num1, num2)), user);
                return division(num1, num2);
        }
        return null;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static double multi(double a, double b) {
        return a * b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }


    public LinkedList<Double> select(User user) {
        return user.getResultList();
    }

}
