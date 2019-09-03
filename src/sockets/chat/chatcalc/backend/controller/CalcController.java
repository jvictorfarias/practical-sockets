package sockets.chat.chatcalc.backend.controller;

import sockets.chat.chatcalc.backend.model.Calculator;

public class CalcController {
    private Calculator calculator;

    public CalcController() {
        calculator = Calculator.getInstance();
    }

    public synchronized double calcula(String request) {
        String[] newData = request.split(" ");
        double operando1 = Double.parseDouble(newData[0]);
        String operador = newData[1];
        double operando2 = Double.parseDouble(newData[2]);
        return this.getCalculator().calc(operando1, operador, operando2);
    }

    private Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
