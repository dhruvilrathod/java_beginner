package logics;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 14, 55, 76, 99}, 99));
        System.out.println(orderAgnosticBinarySearch(new int[]{1234, 1121, 455, 176, 99}, 1234));
        System.out.println(findCelling(new int[]{11, 14, 55, 76, 99}, 60));
        System.out.println(findFloor(new int[]{11, 14, 55, 76, 99}, 60));
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
}
