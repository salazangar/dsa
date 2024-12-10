// Given an array prices[] of size n denoting the cost of stock on each day,
// the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

public class Main {
    public static void main(String[] args)
    {

        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitPrefix(prices));
    }

    public static int maxProfit(int[] arr){
        int total = 0;
        int min = arr[0];
        int currMax = arr[0];
        int n = arr.length;
        int i = 0;
        while(i < n-1){
            while(i < n -1 && arr[i] >= arr[i+1]){
                i++;
            }
            min = arr[i];

            while(i < n -1 && arr[i] <= arr[i+1]){
                i++;
            }
            total += arr[i] - min;
        }
        return total;
    }

    public static int maxProfitPrefix(int[] arr){
        int n = arr.length;
        int total = 0;

        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                total += arr[i] - arr[i-1];
            }
        }
        return total;
    }
}