package logics;

public class LCM_GCD {
    private int number1;
    private int number2;

    /**
     * Constructor that initializes the two numbers.
     *
     * @param number1: The first number.
     * @param number2: The second number.
     */
    public LCM_GCD(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public static void main(String[] args) {
        LCM_GCD numbers = new LCM_GCD(20, 15);
        System.out.println(numbers.calculateLCM());
        System.out.println(numbers.calculateGCD());
        System.out.println(numbers.calculateLCMUsingGCD());
    }

    /**
     * Getter for the first number.
     *
     * @return the first number.
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * Getter for the second number.
     *
     * @return the second number.
     */
    public int getNumber2() {
        return number2;
    }

    /**
     * Calculates and returns the least common multiple (LCM) of the two numbers.
     * If either number is negative, returns -1 as the LCM for negative numbers is undefined.
     * If either number is zero, returns 0 as the LCM of 0 and any other number is 0.
     *
     * @return LCM of the two numbers, or -1 if either number is negative, or 0 if either number is zero.
     */
    public int calculateLCM() {
        if (number1 < 0 || number2 < 0) return -1;
        if (number1 == 0 || number2 == 0) return 0;
        int max = number1 > number2 ? number1 : number2;
        while (true) {
            if ((max % number1 == 0) && (max % number2 == 0)) {
                return max;
            }
            max++;
        }
    }

    public int calculateGCD() {
        if (number1 < 0 || number2 < 0) return 1;
        if (number1 == 0 || number2 == 0) return 0;
        int n1 = number1;
        int n2 = number2;
        while (true) {
            if (n1 % n2 == 0) {
                return n2;
            }
            n1 = (n1 + n2) - (n2 = n1 % n2);
        }
    }

    /*
    formula to calculate LCM using GCD: lcm = (num1 * num2) / gcd
     */
    public int calculateLCMUsingGCD() {
        if (number1 < 0 || number2 < 0) return 1;
        if (number1 == 0 || number2 == 0) return 0;
        return (number1 * number2) / calculateGCD();
    }
}
