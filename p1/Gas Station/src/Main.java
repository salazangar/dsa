/*
We have a car with an unlimited gas tank. We are given an array of gas and an array of costs.
Each index in the gas array represents the amount of gas available to fill up your car with. Each index in the cost array represents the amount of gas that will be used when travelling from this gas station to next.

Our goal is to determine whether it is possible to start at any of the gas stations and
complete one trip around.

If it is, we need to return the index of that starting gas station,
if no such gas station exists then we return -1.
 */

public class Main {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(startIndexBrute(gas,cost));
        System.out.println(startIndexSkip(gas,cost));

    }

    public static int startIndexBrute(int[] gas, int[] cost){
        int n = gas.length;
        int balance = 0, count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            balance = 0;
            j = i;
            while(count < n){
                balance += gas[j%n] - cost[j%n];
                if(balance < 0) break;
                count++;
                j++;
            }
            if(count == n && balance >= 0) return i;
        }
        return -1;
    }

    public static int startIndexSkip(int[] gas, int[] cost){
        int n = gas.length;

        int total_surplus= 0;
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                start = i + 1;
                surplus = 0;
            }
        }
        if(total_surplus < 0){
            return -1;
        }else{
            return start;
        }

    }
}




