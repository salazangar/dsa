// You are given n activities with their start and finish times.
// Select the maximum number of activities that can be performed by a single person,
// assuming that a person can only work on a single activity at a time.

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{5,9}, {1,2}, {3,4}, {0,6}, {5,7}, {8,9}};
        System.out.println("\n" + findMaxActivities(arr) + "max activities"); // greedy
        // also can use priority queue
    }

    public static int findMaxActivities(int[][] arr){
        int n = arr.length;

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));  // sort based on finishing time
        int i = 0;
        int count = 1;

        print(arr[0]); // select first activity

        for (int j = 1; j < n; j++) {
            if(arr[i][1] <= arr[j][0]){
                print(arr[j]);
                i = j;
                count++;
            }
        }
        return count;
    }

    public static void print(int[] arr){
        System.out.print("(" + arr[0] + ", "
                + arr[1] + ") ");
    }
}