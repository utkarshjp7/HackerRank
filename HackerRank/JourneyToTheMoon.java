import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/journey-to-the-moon/problem
public class JourneyToTheMoon {

    public static class Graph {     
        private ArrayList<ArrayList<Integer>> adjList;
        private int V;
            
        public Graph (int V) {
            adjList = new ArrayList<>();
            this.V = V;
            
            for (int i=0; i<V; i++) {
                adjList.add(new ArrayList<Integer>());
            }
        }
        
        public void addEdge(int node1, int node2) {
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        
        public ArrayList<Integer> getAdjNodes(int node) {
            return adjList.get(node);
        }        
    }
        
    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {        
        Graph graph = new Graph(n);
        
        for (int i=0; i<astronaut.length; i++) {
            graph.addEdge(astronaut[i][0], astronaut[i][1]);               
        }
        
        long numOfPairs = 0;
        HashSet<Integer> visited = new HashSet<>();
                
        for (int i=0; i<n; i++) {                        
            if (!visited.contains(i)) {
                Stack<Integer> frontier = new Stack<Integer>();    
                frontier.push(i);
                visited.add(i);
                int curPathSize = 1;

                while (!frontier.isEmpty()) {
                    int curNode = frontier.pop();    
                    for (int node: graph.getAdjNodes(curNode)) {
                        if (!visited.contains(node)) {
                           curPathSize++;
                           frontier.push(node);
                           visited.add(node);
                        }                
                    }
                }                
                numOfPairs += curPathSize * (visited.size() - curPathSize);
            }            
        }                
        return numOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
