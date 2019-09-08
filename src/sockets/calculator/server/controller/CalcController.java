package sockets.calculator.server.controller;

import sockets.calculator.server.model.CalculatorModel;

public class CalcController {
    private CalculatorModel calculator;

    public CalcController() {
        calculator = CalculatorModel.getInstance();
    }

    public synchronized double calcula(String request) {
        String[] newData = request.split(";");
        Double op1 = Double.parseDouble(newData[1]);
        Double op2 = Double.parseDouble(newData[2]);
        switch (newData[0]) {
            case "ADD":
                return this.getCalculator().add(op1, op2);
            case "SUB":
                return this.getCalculator().sub(op1, op2);
            case "MULT":
                return this.getCalculator().mult(op1, op2);
            case "DIV":
                return this.getCalculator().div(op1, op2);
        }
        return 0;
    }

    private CalculatorModel getCalculator() {
        return calculator;
    }

    public void setCalculator(CalculatorModel calculator) {
        this.calculator = calculator;
    }
}
