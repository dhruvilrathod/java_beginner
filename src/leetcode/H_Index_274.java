package leetcode;

// https://leetcode.com/problems/h-index/
// Time Complexity: O(n)

public class H_Index_274 {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    /*
     * Problem: Find H-index
     * Definition: H-index(H) is the largest value such that the researcher has published at least H papers that have been cited at least H times.
     * Approach: (Count Sort)
     * - First create an array of frequency with value 0, and length of total papers + 1
     * - if: Iterate over each paper, if the citation count is > total papers, last place of frequency array += 1
     * - else: Corresponding frequency count += 1
     * - Second, start from the end of frequency.
     * - store it into a variable: result
     * - if: result >= current frequency => return current frequency as h-index
     * - else: add value at current frequency to result
     * - if nothing is returned, then return 0
     * */
    public static int hIndex(int[] citations) {
        int len = citations.length;
        int[] freq = new int[len + 1];
        for (int i : citations) {
            if (i >= len) {
                freq[len]++;
            } else {
                freq[i]++;
            }
        }
        int result = 0;
        for (int i = len; i >= 0; i--) {
            result += freq[i];
            if (result >= i) {
                return i;
            }
        }
        return 0;
    }
}
