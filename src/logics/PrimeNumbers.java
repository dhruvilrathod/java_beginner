package logics;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(isPrime(9));
        System.out.println(isPrime(-9));
        System.out.println(isPrime(5));
        printPrimeNumbers(1, 100);
        printFirstNPrimeNumbers(40);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        int count = 2;

        while (count * count <= n) {
            if (n % count == 0) {
                return false;
            }
            count++;
        }

        return count * count > n;
    }

    public static void printPrimeNumbers(int from, int to) {
        if (from < 1) {
            System.out.println("invalid");
            return;
        }

        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void printFirstNPrimeNumbers(int n) {
        if (n <= 0) {
            System.out.println("invalid");
            return;
        }

        int count = 1;
        int num = 1;

        while (count <= n) {
            if (isPrime(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }
}
