//Find a Fixed Point (Value equal to index) in a given array
// Fixed Point in an array is an index i such that arr[i] equals i.

public class FixedPoint {

    public static void main(String[] args) {
        int arr[] = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
        System.out.println("The fixed point is :" + fixedPointBinary(arr, 0, arr.length-1));
//        System.out.println("The fixed point is :" + fixedPointLinear(arr));
    }

    public static int fixedPointLinear(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == i){
                return i;
            }
        }
        return -1;
    }

    public static int fixedPointBinary(int[] arr, int left, int right){
        int n = arr.length;

        if(left <= right){
            int mid = left + (right-left)/2;
            if (mid == arr[mid])
                return mid;
            int res = -1;
            if (mid + 1 <= arr[right]) {
                res = fixedPointBinary(arr, mid + 1, right);
            }
            if(res != -1){
                return res;
            }
            if (mid - 1 >= arr[left])
                return fixedPointBinary(arr,left, mid-1);
        }
        return -1;
    }
}
