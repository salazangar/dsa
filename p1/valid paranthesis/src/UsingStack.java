import java.util.Stack;

public class UsingStack {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        System.out.println(valid(s));
    }

    public static boolean valid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '{' || c == '(' || c== '['){
                stack.push(c);
            }else{
                if(!stack.isEmpty() &&
                        (
                                (stack.peek() == '(' && c == ')') ||
                                (stack.peek() == '[' && c == ']') ||
                                (stack.peek() == '{' && c == '}')
                        )
                ){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
