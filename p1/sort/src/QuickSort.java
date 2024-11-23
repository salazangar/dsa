import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,8, 3,5,9,4 ,1 };
        quickSort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left < right){

            int p = partition(arr, left, right);

            quickSort(arr,p+ 1, right );
            quickSort(arr, left, p - 1);
        }
    }

    public static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l;

        for (int j = l; j < r; j++){
            if(arr[j] < pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, r, i);
        return i;
    }

    public static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
