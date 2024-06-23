package logics;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 9};
        int[][] nums2D = {
                {4, 2, 7},
                {12, 87},
                {8, 7, 6, 5, 4, 3}
        };
        String name = "dhruvil";
        System.out.println(findIndex(7, nums));
        System.out.println(findIndex(21, nums));
        System.out.println(findIndex(7, nums, 1, 3));
        System.out.println(findIndex(21, nums, 1, 3));
        System.out.println(findIndex(21, nums, 1, 33));
        System.out.println(findIndex(21, nums, 3, 1));
        System.out.println(findIndexString(name, 'i'));
        System.out.println(findMinimum(nums));
        System.out.println(Arrays.toString(findIndex2D(12, nums2D)));
        System.out.println(findMax2D(nums2D));
    }

    public static int findIndex(int searchElement, int[] arr) {
        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) return i;
        }

        return -1;
    }

    public static int findIndex(int searchElement, int[] arr, int start, int end) {
        if (arr.length == 0 || end < start || start > arr.length - 1 || end > arr.length - 1) return -1;

        for (int i = start; i <= end; i++) {
            if (arr[i] == searchElement) return i;
        }

        return -1;
    }

    public static int findIndexString(String str, char searchElement) {
        if (str.isEmpty()) return -1;

//        Method 1: using a simple iteration
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == searchElement) return i;
//        }

//        Method 2: using the String class method: toCharArray()
        for (char c : str.toCharArray()) {
            if (c == searchElement) return str.indexOf(c);
        }
        return -1;
    }

    public static int findMinimum(int[] arr) {
        //    assume arr.length != 0
        int min = arr[0];

        if (arr.length == 1) return min;

        for (int j : arr) {
            if (j < min) min = j;
        }

        return min;
    }

    public static int[] findIndex2D(int searchElement, int[][] arr) {
        if (arr.length == 0) return new int[]{-1, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == searchElement) return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    public static int findMax2D(int[][] arr) {
        if (!(arr.length != 0 && arr[0].length != 0)) return Integer.MIN_VALUE;

        int max = arr[0][0];

        for (int[] i : arr) {
            for (int j : i) {
                if (j > max) max = j;
            }
        }

        return max;
    }
}
