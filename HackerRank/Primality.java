import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            if (isPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
    
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i=2; i <= Math.sqrt(number); i++) {
            if((number % i) == 0) {
                return false;         
            }
        }
        return true;
    }
}
