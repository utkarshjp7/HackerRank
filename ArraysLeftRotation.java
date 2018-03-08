import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int result[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        for(int i=0; i<n; i++) {
            int new_i = (i + a.length - k) % a.length;
            result[new_i] = a[i];
        }
        
        for(int i=0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
