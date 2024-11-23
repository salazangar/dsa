import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,8, 3,5,9,4 ,1 };
        mergeSort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr,mid+1, right);
            merge(arr,left, right, mid);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid) {

        // sizes of arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // temp arrays
        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            r[i] = arr[mid + 1 + i];
        }

        int i = 0; int j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(l[i] <= r[j]){
                arr[k++] = l[i++];
            }else{
                arr[k++] = r[j++];
            }
        }
        while(i < n1){
            arr[k++] = l[i++];
        }
        while(j < n2) {
            arr[k++] = r[j++];
        }
    }


}
