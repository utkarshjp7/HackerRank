import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

public class DFSConnectedCellInGrid {
    
    public static class Point {        
        public int x;
        public int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Point[] getNearbyPoints() {
            return new Point[] { new Point(x-1, y-1), new Point(x-1, y),
                                    new Point(x-1, y+1), new Point(x, y+1),
                                    new Point(x+1, y+1), new Point(x+1, y),
                                    new Point(x+1, y-1), new Point(x, y-1) };
        }
        
        public boolean inBounds(int n, int m) {
            return x >= 0 && x < n && y >= 0 && y < m;
        }
        
        @Override
        public int hashCode() {            
            return this.x * 31 + this.y;
        }

        @Override
        public boolean equals(Object obj) {            
            Point other = (Point) obj;
            if (other == null) {
                return false;
            }             
            return other.x == this.x && other.y == this.y;
        }    
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }
        
        System.out.println(getSizeOfLargestRegion(grid, n, m));

        scanner.close();
    }
    
    private static int getSizeOfLargestRegion(int[][] grid, int n, int m) {
        HashSet<Point> visitedPoints = new HashSet<>();
        int largestRegionSize = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {                      
                Point initPoint = new Point(i, j);                               
                if (grid[i][j] == 0 || visitedPoints.contains(initPoint)) {
                    continue;    
                }
                
                int curRegionSize = grid[i][j];
                
                Stack<Point> frontier = new Stack<>();
                frontier.push(initPoint);        
                visitedPoints.add(initPoint);
                int gridSize = m * n;                
                
                while (!frontier.empty()) {
                    Point curPoint = frontier.pop();
                    for (Point p: curPoint.getNearbyPoints()) {
                        if (p.inBounds(n, m) && grid[p.x][p.y] == 1 && !visitedPoints.contains(p)) {                              
                            curRegionSize++;
                            frontier.push(p);
                            visitedPoints.add(p);
                        }                                
                    }            
                }
                
                if (curRegionSize > largestRegionSize) {
                    largestRegionSize = curRegionSize;
                }
            }
        }
        return largestRegionSize;
    }
}
