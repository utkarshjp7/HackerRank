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
            int[] memory = new int[n];
            memory = numberOfWaysToReachTop(n, memory);
            System.out.println(memory[n-1]);
        }
    }
    
    private static int[] numberOfWaysToReachTop(int steps, int[] memory) {     
        if(memory[steps-1] != 0) {
            return memory;
        }
        
        if(steps == 1) {
            memory[steps-1] = 1;
            return memory;
        }
        if(steps == 2) {
            memory[steps-1] = 2;
            return memory;
        }
        if(steps == 3) {
            memory[steps-1] = 4;
            return memory;
        }
        
        memory = numberOfWaysToReachTop(steps-1, memory);
        memory = numberOfWaysToReachTop(steps-2, memory);
        memory = numberOfWaysToReachTop(steps-3, memory);
        int result = memory[steps-2] + memory[steps-3] + memory[steps-4];
        memory[steps-1] = result;
        return memory;
    }
}
