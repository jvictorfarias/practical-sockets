package sockets.calculator.server.controller;

import sockets.calculator.server.model.CalculatorModel;

public class CalcController {
    private CalculatorModel calculator;

    public CalcController() {
        calculator = CalculatorModel.getInstance();
    }

    public synchronized double calcula(String request) {
        String[] newData = request.split(" ");
        double operando1 = Double.parseDouble(newData[0]);
        String operador = newData[1];
        double operando2 = Double.parseDouble(newData[2]);
        return this.getCalculator().calc(operando1, operador, operando2);
    }

    private CalculatorModel getCalculator() {
        return calculator;
    }

    public void setCalculator(CalculatorModel calculator) {
        this.calculator = calculator;
    }
}
