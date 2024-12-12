//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        printSpiral(arr);
        System.out.println();
        printAntiSpiral(arr);

    }

    public static void printSpiral(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        int rStart = 0;
        int rEnd = m-1;
        int cStart = 0;
        int cEnd = n-1;

        while(rStart <= rEnd && cStart <= cEnd){
            //left
            for (int i = cStart; i <= cEnd; i++) {
                System.out.print(arr[rStart][i] + " ");
            }
            rStart++;

            // down
            for (int i = rStart; i <= rEnd; i++) {
                System.out.print(arr[i][cEnd] + " ");
            }
            cEnd--;

            // left
            for (int i = cEnd; i >= cStart; i--) {
                System.out.print(arr[rEnd][i] + " ");
            }
            rEnd--;

            // up
            for (int i = rEnd; i >= rStart; i--) {
                System.out.print(arr[i][cStart] + " ");
            }
            cStart++;
        }
    }

    public static void printAntiSpiral(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        List<Integer> list = new ArrayList<>();

        int rStart = 0;
        int rEnd = m-1;
        int cStart = 0;
        int cEnd = n-1;

        while(rStart <= rEnd && cStart <= cEnd){
            //left
            for (int i = cStart; i <= cEnd; i++) {
                list.add(arr[rStart][i]);
            }
            rStart++;

            // down
            for (int i = rStart; i <= rEnd; i++) {
                list.add(arr[i][cEnd]);
            }
            cEnd--;

            // left
            for (int i = cEnd; i >= cStart; i--) {
                list.add(arr[rEnd][i]);
            }
            rEnd--;

            // up
            for (int i = rEnd; i >= rStart; i--) {
                list.add(arr[i][cStart]);
            }
            cStart++;
        }
        Collections.reverse(list);

        System.out.println(list);
    }

}




