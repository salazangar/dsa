// Given an array and an integer K,
// find the maximum for each and every contiguous subarray of size K.

/*
Input: arr[] = {1, 2, 3, 1, 4, 5}, K = 3
Output: 3 3 4 5
Explanation: Maximum of 1, 2, 3 is 3
                       Maximum of 2, 3, 1 is 3
                       Maximum of 3, 1, 4 is 4
                       Maximum of 1, 4, 5 is 5
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
        int k = 4;
        System.out.println((windowMaxDeque(arr, k)));
    }

    public static List<Integer> windowMaxDeque(int[] arr, int k){
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            while(!dq.isEmpty() && dq.peekLast() <= i-(k+1)){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                    dq.removeLast();
            }
            dq.addLast(i);

            if(i >= k-1){
                list.add(arr[dq.peek()]);
            }
        }
        return list;
    }

}