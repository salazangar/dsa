//Given an arr[] containing n integers and a positive integer k.
// The problem is to find the longest sub-array's length with the sum of the elements
// divisible by the given value k.

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;
//        System.out.println(maxLengthNaive(arr,k));
        System.out.println(maxLengthSliding(arr,k));
    }

    public static int maxLengthNaive(int[] arr, int k){
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum+= arr[j];
                if(sum % k == 0){
                    max = Math.max(max, j - i +1);
                }
            }
        }
        return max;
    }

    public static int maxLengthSliding(int[] arr, int k){
        int n = arr.length;

        
    }
}