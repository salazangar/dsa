// Given a string, find the smallest window length with all distinct characters of the given string.
// For ex: str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "aabcbcdb";
        System.out.println(smallestWindowBrute(s));
    }

    public static String smallestWindowBrute(String s){
        int n = s.length();
        int distinctCount = 0;
        int size = Integer.MAX_VALUE;
        String res = "";
        Map<Character,Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        distinctCount = map.size();

        for (int i = 0; i < n; i++) {
            int count = 0;
            int visited[] = new int[256];
            Arrays.fill(visited, 0);
            String sub = "";
            for (int j = 0; j < n; j++) {
                if(visited[s.charAt(i)]==0){
                    count++;
                    visited[s.charAt(i)] = 1;
                }
                sub += s.charAt(j);
                if(count == distinctCount) break;
            }
            if(sub.length() < size && count == distinctCount){
                res = sub;
                size = res.length();
            }
        }
        return res;
    }
}
