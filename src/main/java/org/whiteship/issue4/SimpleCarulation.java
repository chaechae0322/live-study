package org.whiteship.issue4;

public class SimpleCarulation {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double sub(double number1, double number2) {
        return number1 - number2;
    }

    public double mul(double number1, double number2) {
        return number1 * number2;
    }

    public double div(double number1, double number2) {
        if(number2 == 0) throw new ArithmeticException("divided by zero");
        return number1 / number2;
    }
}
