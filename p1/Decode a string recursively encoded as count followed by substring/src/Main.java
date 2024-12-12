//An encoded string (s) is given, the task is to decode it.
// The pattern in which the strings are encoded is as follows.
//
//<count>[sub_str] ==> The substring 'sub_str'
//                      appears count times.

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        System.out.println(decode(str));
        System.out.println(decodeUsing1Stack(str));
    }

    public static String decode(String s){
        int n = s.length();
        String res = "";

        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = 10 * count + s.charAt(i)-'0';
                    i++;
                }
                i--;
                intStack.push(count);
            }
            else if(s.charAt(i) == ']'){
                String temp = "";
                int repetition = 0;
                if(!intStack.isEmpty()) {
                    repetition = intStack.pop();
                }
                while(!charStack.isEmpty() && charStack.peek() != '['){
                    temp = charStack.pop() + temp;
                }
                charStack.pop();  // to pop the '[' from the stack

                for (int j = 0; j < repetition; j++) {
                    res = res + temp;
                }

                for (int j = 0; j < res.length(); j++) {
                    charStack.push(res.charAt(j));
                }
                res = "";

            } else if (s.charAt(i) == '[') {
                charStack.push('[');
            }
            else{
                charStack.push(s.charAt(i));
            }
        }
        while(!charStack.isEmpty()){
            res = charStack.pop() + res;
        }
        return res;
    }

    public static String decodeUsing1Stack(String s){
        int n = s.length();
        String result = "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ']'){
                String temp = "";
                while(!stack.isEmpty() && stack.peek()!= '['){
                    temp = stack.pop() + temp;
                }
                stack.pop();  // remove '['
                int count = 0;

                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    count = 10* count + stack.pop() - '0';
                }
                for (int j = 0; j < count; j++) {
                    result += temp;
                }

                for (int j = 0; j < result.length(); j++) {
                    stack.push(result.charAt(j));
                }
                result = "";
            }
            else{
                stack.add(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }
}