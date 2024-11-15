package leetcode;

// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProductExceptSelf_238 {

    public static void main(String[] args) {
        int[] ans = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ans));
    }

    /*
     *   Solution: O(3n) = O(n)
     *   An element's product except self is product of all the left elements to it * all the right elements to it
     *   To use this, we can maintain two arrays for left products of an index and right products of an index.
     *   To get the final array, at any index of original array, the product will be the multiplication of corresponding index from lefts and rights
     *   -> for simplifying the edges, the left of first and right of last is considered as "1", and iteration will exclude first and last for rights and lefts respectively.
     * */

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] lefts = new int[len];
        int[] rights = new int[len];
        Arrays.fill(lefts, 1);
        Arrays.fill(rights, 1);
        for (int i = 1; i < len; i++) {
            lefts[i] = lefts[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i > -1; i--) {
            rights[i] = rights[i + 1] * nums[i + 1];
        }
        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rights));
        for (int i = 0; i < len; i++) {
            ans[i] = lefts[i] * rights[i];
        }
        return ans;
    }
}
