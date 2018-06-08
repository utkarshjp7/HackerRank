import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

public class BFSShortestReachInGraph {
        
    public static class Graph {
        
        public int size;
        LinkedList<Integer>[] adjListArray;
        public Graph(int size) {
            this.size = size;
            adjListArray = new LinkedList[size];
            for(int i = 0; i < size ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }

        public void addEdge(int first, int second) {
            adjListArray[first].addFirst(second);
            adjListArray[second].addFirst(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] shortestReach = new int[size];
            Arrays.fill(shortestReach, -1);
            
            Queue<Integer> frontier = new LinkedList<>();
            frontier.add(startId);
            
            shortestReach[startId] = 0;            
            while (!frontier.isEmpty()) {                
                int curNode = frontier.poll();                
                for (int item: adjListArray[curNode]) {
                    if (shortestReach[item] == -1) {
                        shortestReach[item] = shortestReach[curNode] + 6;
                        frontier.add(item);                                                                    
                    }
                }                
            }
            return shortestReach;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
