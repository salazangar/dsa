// time - O[n^2]
// space - O[1]

public class b_using_array {
    public static void main(String[] args) {
        int[] arr = {  2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int[] arr){
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int res = 0;

        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], arr[i]);  // including itself
        }

        right[n-1]  = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        for(int i = 1; i < n-1; i++){
            res += Math.min(left[i], right[i]) - arr[i];
        }
        return res;
    }
}
