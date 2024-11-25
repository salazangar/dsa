//Input : I AM A GEEK
//Output : GEEK A AM I

public class ReverseOrderOfWords {
    public static void main(String[] args) {
        String s = "I AM A GEEK";
        System.out.println(reverseOrder(s));
    }

    public static String reverseOrder(String s){
        StringBuilder sb = new StringBuilder();

        for (String word : s.split(" ")){
            sb.insert(0, word + " ");
        }
        return sb.toString();
    }

}
