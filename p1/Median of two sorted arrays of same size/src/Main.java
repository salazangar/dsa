// Since the size of the merged array will always be even,
// the median will be the average of the middle two numbers.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2, 13, 17, 30, 45};
        int[] arr2 = {1, 12, 15, 26, 38};
        System.out.println(medianNaive(arr1,arr2));
        System.out.println(medianMerge(arr1,arr2));

    }

    static public double medianNaive(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, res, 0, arr1.length);
        System.arraycopy(arr2, 0, res, arr1.length, arr2.length);

        Arrays.sort(res);

        return (res[arr1.length] + res[arr1.length - 1]) / 2.0;
    }

    static public double medianMerge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m1 = -1, m2 = -1;
        int i = 0, j = 0, k = 0;
        while(k <= n){
            m2 = m1;

            if(i < n && j < n){
                if(arr1[i] < arr2[j]){
                    m1 = arr1[i++];
                }else{
                    m1 = arr2[j++];
                }
            }else if(i == n){
                m1 = arr2[j++];
            }else{
                m1 = arr1[i++];
            }
            k++;
        }
        return (m1 + m2)/2.0;
    }
}