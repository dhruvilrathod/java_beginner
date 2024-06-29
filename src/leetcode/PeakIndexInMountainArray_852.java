package leetcode;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
// Binary Search as mountain array is consists of two sorted arrays
public class PeakIndexInMountainArray_852 {
    public static void main(String[] args) {
        int[] mountainArray = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(mountainArray));
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

}
