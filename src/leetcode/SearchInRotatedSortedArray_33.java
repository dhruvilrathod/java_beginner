package leetcode;

import static logics.BinarySearch.binarySearchInRange;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] arr = {7, 8, 8, 1, 2, 2, 3, 4, 5, 6};
//        int[] arr = {1, 3};
        System.out.println(search(arr, 8));
    }

    public static int search(int[] nums, int target) {
        int pivotIndex = findPivotIndexInAscendingArray(nums);
        int ans = binarySearchInRange(target, nums, 0, pivotIndex);
        if (ans != -1) return ans;
        else if (pivotIndex < nums.length - 1)
            return binarySearchInRange(target, nums, pivotIndex + 1, nums.length - 1);
        return -1;
    }

    /* logic:
        check if array has only one element -> return 0;
        if middle elem > middle + 1 elem, e.g. 9 > 1 in [8,9,1] return mid
        if middle elem < middle - 1 elem, e.g. 9 > 1 in [10,1,2] return mid - 1 if exists
        if none of middle's neighbours solves the issue:
        if middle elem < start elem, end = middle - 1 (search just in the left sub array)
        if middle elem > end elem, start = middle + 1 (search just in the right sub array)

       Method: Binary Search
       Time Complexity: O (log n)
     */
    public static int findPivotIndexInAscendingArray(int[] arr) {
        if (arr.length == 1) return 0;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] < arr[start]) {
                end = mid - 1;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                return start;
            }
        }
        return start;
    }

    public static int findTimesOfRotated(int[] arr) {
        return findPivotIndexInAscendingArray(arr) + 1;
    }
}
