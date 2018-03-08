import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
    
    public static int numberNeeded(String first, String second) {
        int[] firstCharFreq = calculateCharacterFrequencies(first);
        int[] secondCharFreq = calculateCharacterFrequencies(second);

        int numberNeeded = 0;
        for(int i=0; i<firstCharFreq.length; i++) {
            numberNeeded += Math.abs(firstCharFreq[i] - secondCharFreq[i]);
        }
        
        return numberNeeded;        
    }
    
    private static int[] calculateCharacterFrequencies(String str) {
        int[] charFreq = new int[26];

        for(int i=0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a'; 
            charFreq[c]++;
        }
        return charFreq;
    }
}
