package by.tms.entity;

import java.util.Date;

public class History {
    private double num1;
    private double num2;
    private double result;
    private String operation;
    private Date dt;

    public History(double num1, double num2, double result, String operation, Date dt) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        this.dt = dt;
    }

    public Double getNum1() {
        return num1;
    }

    public Double getNum2() {
        return num2;
    }

    public Double getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }
}
