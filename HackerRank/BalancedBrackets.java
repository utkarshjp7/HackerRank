import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            if(isBalanced(expression)) 
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        scanner.close(); 
    }
    
    private static boolean isBalanced(String bracketsString) {
        // Must be even. Number is odd if the last bit is set.
        if ((bracketsString.length() & 1) == 1) 
        {
            return false;
        }
        else
        {        
            Stack<Character> s = new Stack<>();
            for (int i = 0; i < bracketsString.length(); i++) {
                char b = bracketsString.charAt(i);
                switch (b) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.empty() || b != s.peek())
                            return false;
                    s.pop();
                }         
            }
            return s.empty();
        }
    }
}
