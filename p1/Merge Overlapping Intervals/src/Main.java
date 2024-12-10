//Given an array of time intervals where arr[i] = [starti, endi],
// the task is to merge all the overlapping intervals into one and
// output the result which should have only mutually exclusive intervals.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
//        List<int[]> list = mergeOverlapBrute(arr);   // O(n^2) Time and O(n) space
        List<int[]> list = mergeOverlapCheckLastMerged(arr);  // O(n*log(n)) Time and O(n) space

        for(int[] a : list){
            System.out.println(a[0] + " " + a[1]);
        }
    }

    public static List<int[]> mergeOverlapBrute(int[][] arr){
        int n = arr.length;

        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {

            int start = arr[i][0];
            int end = arr[i][1];

            // skipping already merged ones
            if(!list.isEmpty() && list.get(list.size()-1)[1] >= end){
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }
            }
            list.add(new int[] {start, end});
        }
        return list;
    }

    public static List<int[]> mergeOverlapCheckLastMerged(int[][] arr){
        Arrays.sort(arr, Comparator.comparingInt(a ->a[0]));
        int n = arr.length;

        List<int[]> list = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        list.add(new int[]{start, end});

        for (int i = 1; i < n; i++) {
            int[] recent = list.get(list.size()-1);
            if(arr[i][0] <= recent[1]){                             // if merge-able
                recent[1] = Math.max(recent[1], arr[i][1]);
            }else{
                list.add(new int[]{arr[i][0], arr[i][1]});
            }
        }
        return list;
    }
}






















