import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem

public class RunningMedian {

    private static final Scanner scanner = new Scanner(System.in);
    private static PriorityQueue<Integer> mLowerHalfMaxHeap; 
    private static PriorityQueue<Integer> mUpperHalfMinHeap;
    
    public static void main(String[] args) {
        int n = scanner.nextInt();
        mLowerHalfMaxHeap = new PriorityQueue<Integer>((int)Math.ceil(n/2.0), new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                return -1 * int1.compareTo(int2);
            }
        });
        
        mUpperHalfMinHeap = new PriorityQueue<Integer>((int)Math.ceil(n/2.0));

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            System.out.println(getRunningMedian(aItem));
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }

        scanner.close();
    }
    
    private static double getRunningMedian(int newItem) {
        double median;
        
        if (mLowerHalfMaxHeap.size() == 0 || mLowerHalfMaxHeap.peek() >= newItem)
            mLowerHalfMaxHeap.add(newItem);
        else
            mUpperHalfMinHeap.add(newItem);
        
        int maxHeapSize = mLowerHalfMaxHeap.size(); 
        int minHeapSize = mUpperHalfMinHeap.size();
        if(maxHeapSize - minHeapSize > 1) 
            mUpperHalfMinHeap.add( mLowerHalfMaxHeap.poll()); 
        else if (maxHeapSize - minHeapSize < -1)  
            mLowerHalfMaxHeap.add(mUpperHalfMinHeap.poll());
        
        if(((maxHeapSize + minHeapSize) & 1) == 1)                 
            median = (maxHeapSize > minHeapSize) ? mLowerHalfMaxHeap.peek() : mUpperHalfMinHeap.peek();
        else
            median = (mLowerHalfMaxHeap.peek() + mUpperHalfMinHeap.peek()) / 2.0;
        
        return median;
    }
    
}
