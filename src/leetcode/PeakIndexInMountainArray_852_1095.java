package leetcode;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
// https://leetcode.com/problems/find-in-mountain-array/ => Hard => Combination of this code and binary search

// Binary Search as mountain array is consists of two sorted arrays
public class PeakIndexInMountainArray_852_1095 {
    public static void main(String[] args) {
        int[] mountainArray = {0, 5, 3, 1};
//        System.out.println(peakIndexInMountainArray(mountainArray));
        System.out.println(findInMountainArray(4, mountainArray));
    }

    /*
        Logic:
        If the middle element is greater than the middle + 1, then peak is in the left sub array (middle inclusive)
        if the middle element is smaller than the middle + 1, then the peak is in the right sub array (middle exclusive)

        Method: Binary Search
        Time Complexity: O(lon n)
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start != end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] > arr[middle + 1]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int ans = binarySearchInRange(target, mountainArr, 0, peak);
        return ans > -1 ? ans : binarySearchInRange(target, mountainArr, peak + 1, mountainArr.length - 1);
    }

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
}
