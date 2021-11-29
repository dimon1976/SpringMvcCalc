package by.tms.storage;

import by.tms.entity.User;

import java.util.LinkedList;

public class InMemoryHistoryStorage {
    LinkedList<Double> historyOperation = new LinkedList<>();

    public void save(double num1, double num2, double result, User user, String operation) {

    }

    public LinkedList<Double> getHistoryOperation() {
        return historyOperation;
    }
}
