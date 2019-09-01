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

    public double calc(String data) {
        double result = 0;
        String[] newData = data.split(" ");
        switch (newData[1]) {
            case "+":
                result = Double.parseDouble(newData[0]) + Double.parseDouble(newData[2]);
                break;
            case "-":
                result = Double.parseDouble(newData[0]) - Double.parseDouble(newData[2]);
                break;
            case "*":
                result = Double.parseDouble(newData[0]) * Double.parseDouble(newData[2]);
                break;
            case "/":
                if (newData[2].equals("0")) {
                    System.out.println("Impossível dividir por 0!");
                } else {
                    result = Double.parseDouble(newData[0]) / Double.parseDouble(newData[2]);
                }
                break;
        }
        return result;
    }

}
