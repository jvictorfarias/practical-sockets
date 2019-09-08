package sockets.calculator.server.model;


public class CalculatorModel {

    private static CalculatorModel uniqueInstance;

    private CalculatorModel() {
    }

    public static synchronized CalculatorModel getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CalculatorModel();
        }
        return uniqueInstance;
    }

    public double add(Double operando1, Double operando2) {
        double result = operando1 + operando2;
        return result;
    }

    public double sub(Double operando1, Double operando2) {
        double result = operando1 - operando2;
        return result;
    }

    public double mult(Double operando1, Double operando2) {
        double result = operando1 * operando2;
        return result;
    }

    public double div(Double operando1, Double operando2) {
        double result = operando1 / operando2;
        return result;
    }
}
