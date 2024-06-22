package logics;

public class ArmstrongNumbers {

    /*
        3 digits numbers, in which power num.digit-length of all the digits add up to the actual number
        ex. 153 => 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
     */

    public static void main(String[] args) {
        System.out.println(isArmstrong(154));
        System.out.println(isArmstrong(153));
        printArmstrongNumbers(0, 999);
        printFirstNArmstrongNumbers(15);
    }

    public static boolean isArmstrong(int num) {

        int original = num;
        int sum = 0;
        int totalDigits = String.valueOf(num).length();

        while (num > 0) {
            sum += (int) Math.pow(num % 10, totalDigits);
            num = num / 10;
        }

        return sum == original;
    }

    public static void printArmstrongNumbers(int from, int to) {
        if (from < 0) {
            System.out.println("Invalid");
            return;
        }

        for (int i = from; i <= to; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    public static void printFirstNArmstrongNumbers(int n) {
        if (n <= 0) {
            System.out.println("invalid");
            return;
        }

        int count = 1;
        int num = 1;

        while (count <= n) {
            if (isArmstrong(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }
}
