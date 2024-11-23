// https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        System.out.println("The minimum cost is :" + connectRopes(arr));

    }

    public static int connectRopes(int[] arr){
        int n = arr.length;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
        }

        int minCost = 0;

        while(q.size() > 1){

            int a = q.poll();
            int b = q.poll();

            minCost += a+b;
            q.add(a+b);
        }

        return minCost;
    }

}