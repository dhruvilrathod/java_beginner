package logics;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(Arrays.toString(reverse(arr2)));
    }

    //    Move till half of the array from beginning and ending and swapping the elements
    //    in-place swapping, no extra copy is made of array, hence return value is not needed
    public static int[] reverse(int[] arr) {
        int pointer = 0;

        while (pointer < arr.length / 2) {
            swapWithoutExtraVariable(arr, pointer, arr.length - 1 - pointer);
            pointer++;
        }

        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void swapWithoutExtraVariable(int[] arr, int index1, int index2) {
//        logic: two values => val1 and val2
//        make val1 total: val1 = val1 + val2
//        subtract val2 from total (val1) to get value of original val1 and store in val2
//        val2 = val1 - val2;
//        now that val2 has the original value of val1, we can get original value of val2 by total (val1) - val1 (val2)
//        val1 = val1 - val2;

//        multi line code
//        arr[index1] = arr[index1] + arr[index2];
//        arr[index2] = arr[index1] - arr[index2];
//        arr[index1] = arr[index1] - arr[index2];

//        one-liner code (with addition and subtraction)
//        val1 = (val1 + val2) - (val2 = val1)
        arr[index1] = (arr[index1] + arr[index2]) - (arr[index2] = arr[index1]);

//        same logic available for multiplication and division
//        val1 = (val1 * val2) / (val2 = val1)
//               ---second----   -----first----
//               -----------third--------------
//        -final-

//        XOR logic
//        x = x ^ y ^ (y = x);

    }
}
