import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println(new ValidParanthesis().isValid(input));
    }
}
