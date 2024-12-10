//Given an array of coins[] of size n and a target value sum,
// where coins[i] represent the coins of different denominations.
// You have an infinite supply of each of the coins.
// The task is to find the minimum number of coins required to make the given value sum

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int sum = 19;
//        System.out.println(minCoinsRec(coins,sum));
        System.out.println(minCoinsPrefix(coins,sum));
    }

    public static int minCoinsRec(int[] coins, int sum){
        int val =  recursion(coins, sum, 0);
        return val == Integer.MAX_VALUE? -1 : val;
    }

    public static int recursion(int[] coins, int sum, int i){
        if(sum == 0) return 0;
        if(sum < 0 || i == coins.length) return Integer.MAX_VALUE;

        int take = Integer.MAX_VALUE;
        take = recursion(coins, sum - coins[i], i);
        if(take!= Integer.MAX_VALUE) take++;
        int noTake = recursion(coins, sum, i+ 1);

        return Math.min(take, noTake);
    }

    public static int minCoinsPrefix(int[] coins, int sum){
        int[] pre = new int[sum+1];
        Arrays.fill(pre, sum + 1);
        pre[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for(int x : coins){
                if(i >= x){
                    pre[i]  = Math.min(pre[i], pre[i-x] + 1);
                }
            }
        }
        return pre[sum] > sum ? -1 : pre[sum];
    }
}