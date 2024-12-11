//Find the largest rectangular area possible in a given histogram where the
// largest rectangle can be made of a number of contiguous bars whose heights are given in an array.
// For simplicity, assume that all bars have the same width and the width is 1 unit.

public class Main {
    public static void main(String[] args) {
        int[] arr  = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(largestRectangleAreaNaive(arr));
    }

    public static int largestRectangleAreaNaive(int[] arr){
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            for (int j = i-1; j >=0 && arr[j] >= arr[i]; j--) {
                curr+= arr[i];
            }

            for (int j = i+1; j < n && arr[j] >= arr[i]; j++) {
                curr += arr[i];
            }

            max = Math.max(max, curr);
        }
        return max;
    }
}