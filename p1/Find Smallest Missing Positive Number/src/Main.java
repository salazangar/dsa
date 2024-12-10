// Given an unsorted array arr[] with both positive and negative elements,
// the task is to find the smallest positive number missing from the array.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};
//        System.out.println(findMissingNaive(arr));
        System.out.println(findMissingVisitedArray(arr));
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
}