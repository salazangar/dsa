// Given a string, find the smallest window length with all distinct characters of the given string.
// For ex: str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
//        System.out.println(smallestWindowBrute(s));
        System.out.println(smallestWindowSlidingWindow(s));
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
            for (int j = i; j < n; j++) {
                if(visited[s.charAt(j)]==0){
                    count++;
                    visited[s.charAt(j)] = 1;
                }
                sub += s.charAt(j);
                if(count == distinctCount) break;
            }
            if(sub.length() < size && count == distinctCount){
                res = sub;
                size = res.length();
            }
        }
        return res ;
    }

    public static String smallestWindowSlidingWindow(String s){
        int n = s.length();
        boolean[] visited = new boolean[256];
        Arrays.fill(visited,false);
        int distinct = 0;

        for(char c : s.toCharArray()){
            if( !visited[c]){
                visited[c] = true;
                distinct++;
            }
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        String minWindow = "";
        int[] charCount = new int[256];
        int count = 0;

        for(int i = 0; i < n; i++){
            charCount[s.charAt(i)]++;

            if(charCount[s.charAt(i)] == 1){
                count++;
            }

            if(distinct == count){
                while(charCount[s.charAt(start)] > 1) {
                    charCount[s.charAt(start)]--;
                    start++;
                }

                int currLength = i - start + 1;
                if(currLength < min) {
                    min = currLength;
                    minWindow = s.substring(start, start + min);
                }
            }
        }
        return minWindow;
    }
}
