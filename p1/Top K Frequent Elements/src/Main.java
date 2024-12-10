// Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr  = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(mostFrequent(arr, k));
    }

    public static List<Integer> mostFrequent(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[arr.length + 1];
        List<Integer> res = new ArrayList<>();

        for(int x : arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }

        for(int i = bucket.length-1; i >= 0 && res.size() < k; i--){
            if(bucket[i]!= null){
                res.addAll(bucket[i]);
            }
        }
        return res;

    }
}