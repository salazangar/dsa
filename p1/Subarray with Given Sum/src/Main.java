// Input: arr[] = { 15, 2, 4, 8, 9, 5, 10, 23}, sum = 23
//Output: 2 5
//Explanation: Sum of elements between indices 2 and 5 is 2 + 4 + 8 + 9 = 23

// 1- based indexing

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;
//        System.out.println(Arrays.toString(subarrayGivenSumNaive(arr,sum)));
//        System.out.println(Arrays.toString(subarrayGivenSumSliding(arr,sum)));
        System.out.println(Arrays.toString(subarrayGivenSumHashing(arr,sum))); // also handles negatives
    }

    public static int[] subarrayGivenSumNaive(int[] arr, int sum){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr += arr[j];
                if(sum == curr){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{-1};
    }

    public static int[] subarrayGivenSumSliding(int[] arr, int sum){
        int n = arr.length;
        int i = 0; int j = 0;

        int curr = 0;

        while( j < n){
            curr += arr[j];

            while(curr > sum && i < j){
                curr -= arr[i];
                i++;
            }

            if(curr == sum){
                return new int[]{i+1, j+1};
            }
            j++;
        }
        return new int[]{-1};
    }

    public static int[] subarrayGivenSumHashing(int[] arr, int sum){
        int n = arr.length;
        int start = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();  // to store prefix sum
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += arr[i];

            if(prefixSum.containsValue(curr - sum)){
                start = prefixSum.get(curr - sum);
                return new int[]{start + 1, i};
            }

            prefixSum.put(curr, i);
        }
        return new int[]{-1};
    }
}