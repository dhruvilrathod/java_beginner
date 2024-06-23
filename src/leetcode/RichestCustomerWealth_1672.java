package leetcode;

public class RichestCustomerWealth_1672 {

    public static void main(String[] args) {
        int[][] arr = {
                {2, 8, 7}, {7, 1, 3}, {1, 9, 5}
        };
        System.out.println(maximumWealth(arr));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int totalCustWealth = 0;
            for (int i : account) {
                totalCustWealth += i;
            }
            if (totalCustWealth > max) max = totalCustWealth;
        }
        return max;
    }
}
