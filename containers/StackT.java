package containers;
import net.mindview.util.*;

public class StackT {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("U");
       String s =  "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
       for (int i = 0; i < s.length(); i++) {
           if (String.valueOf(s.charAt(i)).equals("+")) {
               stack.push(String.valueOf(s.charAt(i + 1)));
           }
           if (String.valueOf(s.charAt(i)).equals("-")) {
               System.out.print(stack.pop());
           }
       }
    }
}