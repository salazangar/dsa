//Given an array arr[], the task is to find the subarray
// that has the maximum sum and return its sum.

public class Main {
    public static void main(String[] args)
    {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySumNaive(arr));
        System.out.println(maxSubarraySum(arr));
    }

    public static int maxSubarraySumNaive(int[] arr){
        int n = arr.length;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr += arr[j];
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static int maxSubarraySum(int[] arr){
        int n = arr.length;

        int prevMax = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            prevMax = prevMax < 0 ? arr[i] : prevMax + arr[i];
            max = Math.max(prevMax, max);
        }
        return max;
    }
}