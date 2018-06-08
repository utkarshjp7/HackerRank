import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        scanner.close();
        
        HashMap<String, Integer> ransomWordCount = countWordOccurances(ransomItems);
        HashMap<String, Integer> magazineWordCount = countWordOccurances(magazineItems);
        for (String word: ransomWordCount.keySet()) {
            int c = ransomWordCount.get(word);
            if(c > magazineWordCount.getOrDefault(word, 0)) {
                System.out.println("No");
                return;
            }
        }
        
        System.out.println("Yes");
    }
    
    private static HashMap<String, Integer> countWordOccurances(String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
