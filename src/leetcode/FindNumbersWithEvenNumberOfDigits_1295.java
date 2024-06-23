package leetcode;

// Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
public class FindNumbersWithEvenNumberOfDigits_1295 {

    public static void main(String[] args) {
        int[] nums = {12, 345, 21, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int n : nums) {
//            formula for finding the total number of digits in a decimal number
//            int totalDigits = (int) Math.log10(n) + 1;
//            formula for finding the total number of digits in a binary number
//            int totalDigits = (int) Math.log10(n) + 1;
//            formula for finding the total number of digits in an octal number
//            int totalDigits = (int) Math.log10(n) + 1;
//            similar for hexadecimal and other number systems
            if (((int) Math.log10(n) + 1) % 2 == 0) evenCount++;
        }
        return evenCount;
    }
}
