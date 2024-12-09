//Given an array of words arr[],  The task is to find the most occurring word in arr[].

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String arr[] = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can",
                "be", "computer", "science",
                "zoom", "yup", "fire", "in",
                "be", "data", "geeks"};

//        System.out.println(mostFrequentNaive(arr));
        System.out.println(mostFrequentHash(arr));
    }

    public static String mostFrequentNaive(String[] arr){
        int max = 0;
        String res = "";

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i].equals(arr[j])){
                    count++;
                }
            }
            if(count >= max){
                max = count;
                res = arr[i];
            }
        }
        return res;
    }

    public static String mostFrequentHash(String[] arr){
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = "";
        for (String s : arr){
            map.put(s, map.getOrDefault(s,0) + 1);
            if(max <= map.get(s)){
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }
}