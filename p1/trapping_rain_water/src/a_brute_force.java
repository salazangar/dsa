// time - O[n^2]
// space - O[1]

public class a_brute_force {
    public static void main(String[] args) {
        int[] arr = {  2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
    }

    private static int maxWater(int[] arr) {

        int max = 0;

        for(int i = 0; i < arr.length - 1; i++){
            int left = arr[i];
            for(int j =0; j < i; j++){
                left = Math.max(left, arr[j]);
            }
            int right = arr[i];
            for(int j =i+1; j < arr.length; j++){
                right = Math.max(right, arr[j]);
            }

            max += Math.min(left, right) - arr[i];
        }
        return max;
    }

}
