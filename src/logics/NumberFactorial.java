package logics;

public class NumberFactorial {

    public static void main(String[] args) {
        System.out.println(iterativeFactorialCalculator(0));
    }

    public static int iterativeFactorialCalculator(int number) {
        if (number < 0) return -1;
        int factorial = 1;
        int count = 1;
        while (count <= number) {
            factorial *= count;
            count++;
        }
        return factorial;
    }

}
