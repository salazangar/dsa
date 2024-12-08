import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"aba","baba","aba","xzxb"};
        String[] q   = {"aba","xzxb","ab"};
//        answerQueryNaive(arr, q);
//        answerQueryTrie(arr, q);
        answerQueryHash(arr,q);
    }

    static void answerQueryNaive(String[] arr, String[] q){
        for (int i = 0; i < q.length; i++) {
            System.out.print(search(arr, q[i]) + " ");

        }
    }

    static void answerQueryTrie(String[] arr, String[] q){
        Trie root = new Trie();

        for (int i = 0; i < arr.length; i++) {
            insert(root, arr[i]);
        }

        for (int i = 0; i < q.length; i++) {
            System.out.print(search(root, q[i]) + " ");

        }
    }
    static int search(String[] arr, String s) {
        int count = 0;
        for (String str : arr) {
            if (str.equals(s)) {
                count++;
            }
        }
        return count;
    }

    static class Trie{
        public int count;
        public Trie[] node = new Trie[26];

        public Trie() {
            count = 0;
            for (int i = 0; i < 26; i++) {
                node[i] = null;
            }
        }
    }
    static Trie insert(Trie root, String s){
        Trie temp = root;
        for (int i = 0; i < s.length(); i++) {
            int ind = (int)s.charAt(i) - (int)'a';

            if(temp.node[ind] == null){
                temp.node[ind] = new Trie();
            }

            temp = temp.node[ind];
        }
        temp.count++;
        return root;
    }

    static int search(Trie root, String s){
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int ind = (int)s.charAt(i) - (int)'a';
            if (root.node[ind] == null){
                return 0;
            }
            root = root.node[ind];
        }
        return root.count;
    }

    static void answerQueryHash(String[] arr, String[] q){
        Map<String, Integer> map = new HashMap<>();

        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : q){
            System.out.print(map.getOrDefault(s,0) + " ");
        }
    }

}