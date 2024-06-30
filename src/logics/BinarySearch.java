package logics;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 14, 55, 76, 99}, 99));
        System.out.println(orderAgnosticBinarySearch(new int[]{1234, 1121, 455, 176, 99}, 1234));
        System.out.println(findCelling(new int[]{11, 14, 55, 76, 99}, 60));
        System.out.println(findFloor(new int[]{11, 14, 55, 76, 99}, 60));
        int[][] martix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(binarySearchIn2DArray(martix, 333)));
    }

    //    time complexity = O(log2 n)
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
//            int middle = (start + end) / 2; // this start + end might exceed the int range in java
            int middle = start + (end - start) / 2;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    //    for identifying the sorted order first and then perform the binary search
    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAscending = arr[start] <= arr[end];

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (target == arr[middle]) {
                return middle;
            }

            if (isAscending) {
                if (target > arr[middle]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                if (target < arr[middle]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

        }
        return -1;
    }

    //    find the floor of a number : return start instead of -1 (smallest number >= target)
    public static int findCelling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if (target > arr[end]) return -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    //    find the floor of a number : return end instead of -1 (greatest number <= target)
    public static int findFloor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if (target < arr[start]) return -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return end;
    }

    //    Binary search (agnostic) for given start and end range
    public static int binarySearchInRange(int target, int[] arr, int start, int end) {
        boolean isAsc = arr[start] <= arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currMid = arr[mid];
            if (currMid == target) {
                return mid;
            }
            if (isAsc) {
                if (currMid < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (currMid > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Search for an element in column wise and row wise sorted array
     * Concept: Reduce the search space every iteration by comparing row element and column element with target
     * Assumption: It's a matrix in which the size of all rows are same
     * Time Complexity: O(n)
     * Space Complexity: o(1)
     */
    public static int[] binarySearchIn2DArray(int[][] arr, int target) {
        int row = 0;
        int col = arr.length - 1;
        while (col >= 0 && row < arr.length) {
            if (arr[row][col] == target) return new int[]{row, col};
            else if (arr[row][col] < target) row++;
            else col--;
        }
        return new int[]{-1, -1};
    }

}
