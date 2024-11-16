package leetcode;

// https://leetcode.com/problems/gas-station/
// Time complexity: O(n)
// key point: we just need to return the start index. it is given that "If there exists a solution, it is guaranteed to be unique".
// we can check it in one pass. Keep traversing as per cost, and if cost exceeds then make the start to the next element.

public class GasStation_134 {
    public static void main(String[] args) {

    }

    /*
     * Approach:
     * - First check if completing the circle is possible or not: compare total of both gas and cost
     * - Start with the initial station
     * - For each, add up the remaining gas after reaching to next station
     * - if it becomes negative, then make it zero, and start from the next station i.e. i+1
     * - return the start
     * */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost) {
            return -1;
        }
        int start = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
