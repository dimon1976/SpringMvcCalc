package by.tms.service;

import by.tms.entity.History;
import by.tms.entity.User;
import by.tms.storage.InMemoryHistoryStorage;

import java.util.LinkedList;

import static by.tms.service.MathService.*;

public class CalcService {
    InMemoryHistoryStorage history = new InMemoryHistoryStorage();

    public Double start(Double num1, Double num2, String op, User user) {
        switch (op) {
            case "sum":
                double sum = sum(num1, num2);
                history.save(num1, num2, sum, user, "+");
                return sum;
            case "subtrack":
                double sub = sub(num1, num2);
                history.save(num1, num2, sub, user, "-");
                return sub;
            case "div":
                double div = division(num1, num2);
                history.save(num1, num2, div, user, "/");
                return div;
            case "multiply":
                double multi = multi(num1, num2);
                history.save(num1, num2, multi, user, "*");
                return multi;
        }
        return null;
    }

    public LinkedList<History> select(long userid) {
        return history.returnHistoryOfOperation(userid);
    }

}
