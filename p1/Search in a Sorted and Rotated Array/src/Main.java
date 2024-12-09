// Given a sorted and rotated array arr[] of n distinct elements,
// the task is to find the index of given key in the array.
// If the key is not present in the array, return -1.

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int k = 6;
        System.out.println(searchLinear(arr, k));
        System.out.println(search(arr, k));
    }

    public static int searchLinear(int[] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    public static int search(int[] arr, int k){
        int n = arr.length;

        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == k) return mid;

            if(arr[low] <= arr[mid]){
                if(k >= arr[low] && k <= arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(k >= arr[mid] && k <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}