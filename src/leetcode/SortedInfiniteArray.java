package leetcode;

// question (Amazon): Find position of an element in a sorted array of infinite number (DO NOT USE .length)
// logic: in binary search do n/2 until single element remains -> Reduce
// we need to reverse this logic -> start from 1 and do n * 2 until no more elements in the array
// Question on GFG
public class SortedInfiniteArray {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 234, 767};
        System.out.println(findFromInfiniteSortedArray(arr, 10));
    }

    public static int findFromInfiniteSortedArray(int[] arr, int target) {
//        initially start with first 2 indexes = [0,1]
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {

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

}
