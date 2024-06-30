package logics;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 14, 55, 76, 99}, 99));
        System.out.println(orderAgnosticBinarySearch(new int[]{1234, 1121, 455, 176, 99}, 1234));
        System.out.println(findCelling(new int[]{11, 14, 55, 76, 99}, 60));
        System.out.println(findFloor(new int[]{11, 14, 55, 76, 99}, 60));
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(binarySearchIn2DArray(matrix, 333)));
        System.out.println(Arrays.toString(binarySearchInFullySorted2DArray(matrix2, 13)));
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

    /**
     * Fully sorted 2D array: last element of the previous row is always smaller than first element of next row
     * Logic: divide rows in half, in the middle row, compare the target: arr[mid][0] <= target <= arr[mid][len]
     * if in the range => apply binary search on that row
     * else if smaller, then apply half logic in the first half, otherwise on the second half
     * Logic: Binary Search
     * Time Complexity: O(log n) + O(log n) = O(kog n)
     * Space Complexity:
     */
    public static int[] binarySearchInFullySorted2DArray(int[][] arr, int target) {
        int startR = 0;
        int endR = arr.length - 1;

//        executes log n times
        while (startR <= endR) {
            int midR = startR + (endR - startR) / 2;
            int currEnd = arr[startR].length - 1;
            if (arr[startR][0] == target) return new int[]{startR, 0};
            else if (arr[startR][currEnd] == target) return new int[]{startR, currEnd};
            else if (target > arr[startR][currEnd]) startR++;
            else if (target < arr[startR][0]) endR--;
            else {
//                executes only once with time complexity of O(log n)
                return new int[]{startR, binarySearchInRange(target, arr[startR], 1, currEnd - 1)};
            }
        }
        return new int[]{-1, -1};
    }
}
