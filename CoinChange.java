import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(numOfWaysToMakeChange(n, coins));
    }
    
    private static long numOfWaysToMakeChange(int n, int[] coins) {
        long[] result = new long[n+1];
        result[0] = 1;
        for(int coin : coins) {
            for(int i=coin; i<result.length; i++) {
                result[i] += result[i - coin];
            }
        }
        return result[n];
    }
}
