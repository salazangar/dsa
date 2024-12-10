//Given an array of strings words representing an English Dictionary, return the longest word in words
// that can be built one character at a time by other words in words.

//Input: words = ["a","banana","app","appl","ap","apply","apple"]
//Output: "apple"

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};  // return lexicographically smaller if same size
        System.out.println(findWord(words));
    }

    public static String findWord(String[] words){
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";

        for(String s : words){
            if(s.length() == 1 || set.contains(s.substring(0, s.length()-1))){
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }
}