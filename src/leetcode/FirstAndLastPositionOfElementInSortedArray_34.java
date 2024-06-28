package leetcode;

public class FirstAndLastPositionOfElementInSortedArray_34 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    public int search(int[] nums, int target, boolean forStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
//                potential answer is found
                ans = middle;
                if (forStartIndex) end = middle - 1;
                else start = middle + 1;
            } else if (nums[middle] > target) {
//                left sub array
                end = middle - 1;
            } else {
//                right sub array
                start = middle + 1;
            }
        }

        return ans;
    }
}
