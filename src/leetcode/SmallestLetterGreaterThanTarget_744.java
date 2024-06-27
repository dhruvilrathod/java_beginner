package leetcode;

public class SmallestLetterGreaterThanTarget_744 {

    public static void main(String[] args) {
        System.out.println(findSmallestLetterGreaterThanTarget(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }

    //    Pattern Category: Binary Search
    public static char findSmallestLetterGreaterThanTarget(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        if (target < letters[start] || target > letters[end]) return letters[0];

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target < letters[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return letters[start];
    }
}
