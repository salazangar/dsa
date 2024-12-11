// Given an unsorted array arr[] with both positive and negative elements,
// the task is to find the smallest positive number missing from the array.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};
//        System.out.println(findMissingNaive(arr));
//        System.out.println(findMissingVisitedArray(arr));
//        System.out.println(findMissingMarkingIndices(arr));
        System.out.println(findMissingNegating(arr));
    }

    public static int findMissingNaive(int[] arr){
        Arrays.sort(arr);
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == j){
                j++;
            }else if (arr[i] > j){
                break;
            }
        }
        return j;
    }

    public static int findMissingVisitedArray(int[] arr){
        int n = arr.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(arr[i] > 0 && arr[i] <= n){
                visited[arr[i] - 1] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(visited[i-1] != true){
                return i;
            }
        }
        return n+1;
    }

    // mark all indices outside range (n) and negative numbers as 1
    public static int findMissingMarkingIndices(int[] arr){
        int n = arr.length;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if(arr[i] == 1){
                flag = true;
                break;
            }
        }
        if(!flag){
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] <= 0 || arr[i] > n){
                arr[i] = 1;
            }
        }

        // mark all occurences in range as ">n"
        for (int i = 0; i < n; i++) {
            if(arr[i] <= n){
                arr[(arr[i]-1) % n] += n;   // "%n" because if already marked, to remove outOfBoundErrors
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] <= n){
                return i+1;
            }
        }
        // all numbers from 1 to n are present
        return n+1;
    }

    public static int findMissingNegating(int[] arr){
        int n = arr.length;
        int k = partition(arr);

        for (int i = 0; i < k; i++) {
            int val = Math.abs(arr[i]);  // abs() in case of already marked negative

            if(val-1 < k && arr[val - 1] > 0){
                arr[val-1] = -arr[val-1];
            }
        }
        for (int i = 0; i < k; i++){
            if(arr[i] > 0){
                return i+1;
            }
        }
        return k+1;
    }

    public static int partition(int[] arr){
        int n = arr.length;
        int pivot = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] > arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = arr[i];
                pivot++;
            }
        }
        return pivot;
    }

}















