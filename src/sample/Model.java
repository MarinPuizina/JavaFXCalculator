package sample;

public class Model {

    public float calculate(long numberOne, long numberTwo, String operator) {

        return switch(operator) {
            case "+":
                yield numberOne + numberTwo;
            case "-":
                yield numberOne - numberTwo;
            case "*":
                yield numberOne * numberTwo;
            case "/":
                yield numberTwo == 0 ? 0 : numberOne / numberTwo;
            default:
                yield 0;
        };
    }

}
