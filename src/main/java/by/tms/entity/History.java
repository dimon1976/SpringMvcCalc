package by.tms.entity;

public class History {
    private double num1;
    private double num2;
    private double result;
    private String operation;


    public History(double num1, double num2, double result, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
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

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
