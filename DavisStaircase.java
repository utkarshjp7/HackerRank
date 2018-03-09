import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(numberOfWaysToReachTop(n));
        }
    }
    
    private static long numberOfWaysToReachTop(int steps) {
        long[] result = new long[Math.max(steps, 3)];
        result[0] = 1;
        result[1] = 2;
        result[2] = 4;
        
        for(int i=3; i<result.length; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        
        return result[steps-1];
    }
}
