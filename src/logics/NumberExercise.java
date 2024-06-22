package logics;

public class NumberExercise {

    public int number;

    NumberExercise(int num) {
        this.number = num > 0 ? num : 1;
    }

    public static void main(String[] args) {
        NumberExercise n = new NumberExercise(84);
        System.out.println(n.sumUptoN());
        n.printNumberTriangle();
        System.out.println(n.sumOfDivisors());
        System.out.println(n.getLastDigit());
    }

    public int sumUptoN() {
        int sum = 0;
        for (int i = 1; i <= this.number; i++) {
            sum += i;
        }
        return sum;
    }

    public void printNumberTriangle() {
        for (int i = 1; i <= this.number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    public int getLastDigit() {
        if (this.number < 0) return -1;
        return this.number % 10;
    }

    public int sumOfDivisors() {
        int sum = 1 + this.number;

        if (PrimeNumbers.isPrime(this.number)) {
            return sum;
        } else {
            int i = 2;
            int j = number - 1;

//            when we find a divisor, just divide the number with that divisor so that we do not have to iterate over
//            all the numbers, hence the overall time complexity is O(√number).
            while (i < j) {
                if (number % i == 0) {
                    j = number / i;
                    sum += i;
                    sum += j;
                }
                i++;
            }
        }
        return sum;
    }
}
