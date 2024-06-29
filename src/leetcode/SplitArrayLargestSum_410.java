package leetcode;

// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum_410 {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        System.out.println(splitArray(arr, 2));
    }

    /**
     * Question: This question wants to find the "k" possible sub-arrays, in which, maximum sum of all elements in all
     * the array is minimised as compare to other possible pairs.
     * example:
     * array is [7,2,5,10,8] and partitions (k) are 2.
     * possible partitions:
     * [7] [2,5,10,8] => sums: 7 and 25 => Largest: 25
     * [7,2][5,10,8] => sums: 9 and 23 => Largest: 23
     * [7,2,5][10,8] => sums: 14 and 18 => Largest: 18 ::: answer
     * [7,2,5,10][8] => sums: 23 and 8 => Largest: 23
     * <p>
     * Logic:
     * find the range of maximum and minimum possible answer in the array range
     * until min < max
     * find the mid ==> possible answer
     * iterate over all the elements of the array:
     * add that number to the sum
     * if that sum exceeds the mid, make it the part of the next array
     * if the parts of array exceeds the given "k", then make the mid new lower limit
     * otherwise make the mid new upper limit
     * <p>
     * Method: Binary Search (Painter's Partitions)
     * Time Complexity: O(n log(n))
     */
    public static int splitArray(int[] nums, int k) {
        int minLargest = 0;
        int maxLargest = 0;
        for (int i = 0; i < nums.length; i++) {
            minLargest = Math.max(minLargest, nums[i]);
            maxLargest += nums[i];
        }
        while (minLargest < maxLargest) {
            int mid = (minLargest + maxLargest) / 2;

            int sum = 0;
            int pieces = 1;
            for (int n : nums) {
                if (sum + n > mid) {
                    sum = n;
                    pieces++;
                } else {
                    sum += n;
                }
            }
            if (pieces > k) {
                minLargest = mid + 1;
            } else {
                maxLargest = mid;
            }
        }
        return maxLargest;
    }
}
