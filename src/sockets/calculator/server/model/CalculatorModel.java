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

    public double calc(Double operando1, String operador, Double operando2) {
        double result = 0.0f;
        switch (operador) {
            case "+":
                result = operando1 + operando2;
                break;
            case "-":
                result = operando1 - operando2;
                break;
            case "*":
                result = operando1 * operando2;
                break;
            case "/":
                result = operando1 / operando2;
                break;
        }
        return result;
    }

}
