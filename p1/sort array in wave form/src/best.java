import java.util.Arrays;

public class best {

    public static void main(String[] args) {
        int[] arr = {20, 10, 8, 6, 4, 2};
        waveForm(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void waveForm(int[] arr){
        int n = arr.length;
        if(n==0 || n == 1) return;

        for(int i = 0; i < n; i+=2){
            //swap odd and even positions
            if(i > 0 && arr[i - 1] > arr[i])
                swap(arr, i, i-1);
            if(i < n-1 && arr[i + 1] > arr[i])
                swap(arr, i, i+1);
        }
    }
}
