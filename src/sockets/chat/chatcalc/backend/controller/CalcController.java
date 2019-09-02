package sockets.chat.chatcalc.backend.controller;

import sockets.chat.chatcalc.backend.model.Calculator;

public class CalcController {
    private Calculator calculator;

    public CalcController() {
        calculator = Calculator.getInstance();
    }

    public synchronized String calcula(String request) {
        return this.getCalculator().calc(request);
    }

    private Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
