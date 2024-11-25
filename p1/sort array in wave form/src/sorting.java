// arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
// Input: arr[] = {20, 10, 8, 6, 4, 2}
// Output: arr[] = {20, 8, 10, 4, 6, 2}

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] arr = {20, 10, 8, 6, 4, 2};
        waveForm(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void waveForm(int[] arr){
        int n = arr.length;

        Arrays.sort(arr);

        for(int i = 0; i < n-1; i+=2){
            swap(arr,i, i+1);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
