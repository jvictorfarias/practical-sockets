package sockets.chat.chatcalc.backend.model;


public class Calculator {

    private static Calculator uniqueInstance;

    private Calculator() {
    }

    public static synchronized Calculator getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Calculator();
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
