package oops;

public class CalculatorSimple {

    private int number1;
    private int number2;

    CalculatorSimple(int a, int b) {
        this.number1 = a;
        this.number2 = b;
    }

    public static void main(String[] args) {
        CalculatorSimple numbers = new CalculatorSimple(2, 3);
        System.out.println(numbers.add());
        System.out.println(numbers.multiply());
        numbers.double1();
        System.out.println(numbers.getNumber1());
        System.out.println(numbers.getNumber2());
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int add() {
        return this.number1 + this.number2;
    }

    public int multiply() {
        return this.number1 * this.number2;
    }

    public void double1() {
        this.number1 *= 2;
        this.number2 *= 2;
    }
}
