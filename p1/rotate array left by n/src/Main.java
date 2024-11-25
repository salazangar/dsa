import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = { 1,2,3,4,5,6,7,8};
        int n = 3;

        rotateArray(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArray(int[] arr, int n){
        if(arr.length == 0 || arr.length == 1) return;

        n = n % arr.length;

        reverse(arr, 0, n-1);
        reverse(arr, n, arr.length -1);
        reverse(arr, 0, arr.length -1);
    }

    public static void reverse(int[] arr, int l, int r){
        int temp;
        while(l < r){
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}