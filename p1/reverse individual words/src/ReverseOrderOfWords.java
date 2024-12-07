//Input : I AM A GEEK
//Output : GEEK A AM I

public class ReverseOrderOfWords {
    public static void main(String[] args) {
        String s = "I AM A GEEK";
//        System.out.println(reverseOrder(s));
        System.out.println(reverseOrderNoSpace(s));
    }

    public static String reverseOrder(String s){
        StringBuilder sb = new StringBuilder();

        for (String word : s.split(" ")){
            sb.insert(0, word + " ");
        }
        return sb.toString();
    }

    public static String reverseOrderNoSpace(String s){
        {
            int left = 0, i = 0, n = s.length();
            while (s.charAt(i) == ' '){
                i++;
            }

            left = i;

            while (i < n)
            {
                if (i + 1 == n || s.charAt(i) == ' ')
                {
                    int j = i - 1;
                    if (i + 1 == n)
                        j++;

                    while (left<n && j<n && left < j){
                        char ch[] = s.toCharArray();
                        char temp = ch[left];
                        ch[left] = ch[j];
                        ch[j] = temp;
                        s = String.valueOf(ch);
                        left++;
                        j--;
                    }

                    left = i + 1;
                }
                if (left < n && s.charAt(left) == ' ' && i > left)
                    left = i;

                i++;
            }
            // reversing the string
            char ch[] = s.toCharArray();
            int len = s.length();
            for (i=0; i < (len/2); i++)
            {
                char temp = ch[i];
                ch[i] = ch[len - i - 1];
                ch[len - i- 1] = temp;
            }
            s = String.valueOf(ch);

            return s;
        }
    }

}
