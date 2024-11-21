import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 100, 300, 500 };
        int[] dep = { 900, 400, 600 };
        System.out.println(maxPlatforms(arr, dep));
    }

    public static int maxPlatforms(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 0;
        int max = 1;
        int i = 0, j = 0;

        while( i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
            } else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }

            max = Math.max(platforms, max);
        }
        return max;
    }
}