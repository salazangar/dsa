//Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
// replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced
// by more than one root, replace it with the root that has the shortest length.
//Return the sentence after the replacement.

import java.util.Locale;

public class Main {

    static Trie root;
    public static void main(String[] args) {
        String[] dictionary = {"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";

        System.out.println(replace(dictionary, sentence));
    }


    public static String replace(String[] dict, String sentence){
        root = new Trie();
        for (String s : dict){
            insert(s);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for(String s : words){
            sb.append(search(s));
            sb.append(" ");
        }

        return sb.toString();
    }

    public static String search(String s){
        Trie node = root;
        int j = 0;

        for(char c :s.toCharArray()){
            int i = c - 'a';

            if(node.children[i] == null){
                return s;
            }else if(node.children[i].isEnd){
                return s.substring(0,j+1);
            }else{
                node = node.children[i];
                j++;
            }
        }
        return s;
    }

    public static void insert(String s){
        Trie curr = root;

        for(char c : s.toCharArray()){
            int i = c - 'a';

            if(curr.children[i] == null){
                curr.children[i] = new Trie();
            }
            curr = curr.children[i];
        }
        curr.isEnd = true;
    }
}
class Trie{
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}