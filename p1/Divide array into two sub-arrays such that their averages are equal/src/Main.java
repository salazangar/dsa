// Given an integer array,
// the task is to divide an integer array into two sub-arrays to make their averages equal if possible.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 2, 0};
        subIndicesNaive(arr);
        subIndicesLeftSum(arr);
    }

    public static void subIndicesNaive(int[] arr){
        int n = arr.length;
        int lsum = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            lsum += arr[i];
            int rsum = 0;
            for (int j = i+1; j < n; j++) {
                rsum += arr[j];
            }
            if(lsum * (n - 1 - i) == rsum * (i+1)){
                System.out.println("From (0 " + i
                        + ") to (" +(i + 1) + " "
                        + (n - 1)+ ")");
                flag = true;
                break;
            }
        }
        if(!flag) System.out.println("not found");
    }

    public static void subIndicesLeftSum(int[] arr){
        int n = arr.length;
        boolean found = false;
        int lsum = 0;
        int rsum = 0;
        int sum = 0;

        for(int x : arr){
            sum += x;
        }

        for (int i = 0; i < n; i++) {
            lsum += arr[i];
            rsum = sum - lsum;

            if(lsum * (n-1-i) == rsum * (i+1)){
                System.out.printf("From (%d %d) to (%d %d)\n",
                        0, i, i + 1, n - 1);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("not found");
        }
    }
}