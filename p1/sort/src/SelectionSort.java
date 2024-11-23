
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2,8, 3,5,9,4 ,1 };
        System.out.println("The sorted array is :" );
        int[] sorted = (selectionSort(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }

    public static int[] selectionSort(int[] arr){
        int min = 0;
        int curr = 0;

        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, min, i);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
