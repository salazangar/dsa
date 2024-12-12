// Given an array A of length n such that it contains only ‘0s’ and ‘1s’.
// The task is to divide the array into THREE different non-empty parts such that
// all of these parts represent the same binary value(in decimals).

//If it is possible, return any [i, j] with i+1 < j, such that:
//
//    A[0], A[1], …, A[i] is the first part.
//    A[i+1], A[i+2], …, A[j-1] is the second part.
//    A[j], A[j+1], …, A[n- 1] is the third part.
//    Note: All three parts should have equal binary values.
//    However, If it is not possible, return [-1, -1].

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(threePartsNaive(arr))); // O[N^3]
    }

    public static int[] threePartsNaive(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n-2; i++) {
            for (int j = i+2; j < n; j++) {
                int sum1 = 0, sum2 = 0, sum3 = 0;

                for (int k = i; k >= 0; k--) {
                    int val = (int)Math.pow(2, i - k);
                    sum1 += val * arr[k];
                }
                for (int k = j-1; k >= i+1; k--) {
                    int val = (int)Math.pow(2, j-1 - k);
                    sum2 += val * arr[k];
                }
                for (int k = n-1; k >= j; k--) {
                    int val = (int)Math.pow(2, n-1 - k);
                    sum3 += val * arr[k];
                }

                if(sum1 == sum2 && sum2 == sum3){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};

    }
}