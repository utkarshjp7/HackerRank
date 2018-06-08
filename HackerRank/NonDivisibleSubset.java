import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/non-divisible-subset/problem

public class NonDivisibleSubset {
    
    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        HashMap<Integer, HashSet<Integer>> remainders = new HashMap<>();
        for (int i=0; i<k; i++) {
           remainders.put(i, new HashSet<Integer>()); 
        }
        
        for (int i=0; i<S.length; i++) {
            int r = S[i] % k;
            remainders.get(r).add(S[i]);
        }
        
        int result = 0;
        boolean kIsEven = (k & 1) == 0;
        for (int i=0; i<=k/2; i++) {
            HashSet<Integer> numbers = remainders.get(i);                
            if (i == 0 || (kIsEven && k/2 == i)) { 
                result += Math.min(1, numbers.size());
            } else {
                result += Math.max(numbers.size(), remainders.get(k-i).size());
            }            
        }
        return result;        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
