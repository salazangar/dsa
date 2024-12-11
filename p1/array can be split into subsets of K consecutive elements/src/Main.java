// Given an array arr[] and integer K, the task is to split the array into subsets of size K,
// such that each subset consists of K consecutive elements.

// nput: arr[] = {1, 2, 3, 6, 2, 3, 4, 7, 8}, K = 3
//Output: true
//Explanation:
//The given array of length 9 can be split into 3 subsets
// {1, 2, 3}, {2, 3, 4} and {6, 7, 8} such that each subset consists of 3 consecutive elements.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int k = 3;
        System.out.println(canSplitArray(arr, k));
    }

    public static boolean canSplitArray(int[] arr, int K) {
        int n = arr.length;

        // Sort the array to simplify consecutive element checking
        Arrays.sort(arr);

        // Iterate through the sorted array and check for consecutive elements
        for (int i = 0; i < n - K + 1; i++) {
            // Check if each element can be grouped with the next (K - 1) elements
            if (arr[i + K - 1] - arr[i] != K - 1) {
                return false;

            }
        }
        return true;
    }
}