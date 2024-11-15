package leetcode;

// To Do::
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArray_4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 8, 10, 11, 13, 19, 20, 21};
    }

    //    TODO: Solve using binary search
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Middle = nums1.length / 2;
        int nums2Middle = nums2.length / 2;
        int totalLen = nums1.length + nums2.length;
        int leftPartitionLen = totalLen / 2;
        if (nums1[nums1Middle] >= nums2[nums2Middle - 1] && nums2[nums2Middle] >= nums1[nums1Middle - 1]) {
            return (nums1.length + nums2.length) % 2 != 0 ? Math.max(nums1[nums1Middle], nums2[nums2Middle]) : (double) (nums1[nums1Middle] + nums2[nums2Middle]) / 2;
        } else {
            if (nums1[nums1Middle] <= nums2[nums2Middle + 1] && nums2[nums2Middle] > nums1[nums1Middle + 1]) {
                if (nums2[0] >= nums1[nums1.length - 1] && nums1.length < leftPartitionLen) {
                    int medianIndex = (totalLen / 2) - nums1.length;
                    return (nums1.length + nums2.length) % 2 != 0 ? nums2[medianIndex] : (double) (nums2[medianIndex] + nums2[medianIndex - 1]) / 2;
                }
            }
        }
        return -1;
    }
}
