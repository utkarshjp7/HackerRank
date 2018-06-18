import java.util.*;

public class GraphPractice {

    public static class Node {
        
        public int data;
        public LinkedList<Node> adjNodes;
        
        public Node(int data) {
            this.data = data;
            adjNodes = new LinkedList<>();
        } 
        
        public void addEdge(Node toNode) {
            adjNodes.addFirst(toNode);
        } 
        
        @Override
        public boolean equals(Object obj) {
            Node on = (Node) obj;
            if (on == null) return false;
            
            return this.data == on.data;
        }
        
        @Override
        public int hashCode() {
            return data;
        } 
    }

    public static class Graph {
        
        public int size;
        public Node[] nodes;
        
        public Graph(int size) {
            this.size = size;
            nodes = new Node[size];
            for (int i = 0; i < size ; i++) {
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int first, int second) {
            nodes[first].addEdge(nodes[second]);
        }        
    }

    public static void main(String []args) {
        Graph G = new Graph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 3);
        G.addEdge(3, 2);
        G.addEdge(3, 1);
        G.addEdge(2, 4);
        
        for(Node adjNode: G.nodes[0].adjNodes) {
            System.out.println(adjNode.data);
        }
        
        System.out.println(search(G, G.nodes[0], G.nodes[4]));
        System.out.println(search(G, G.nodes[0], G.nodes[5]));

    }
    
    //BFS
    public static boolean search(Graph G, Node from, Node to) {
        LinkedList<Node> frontier = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        
        frontier.addLast(from);
        while (!frontier.isEmpty()) {
            Node curNode = frontier.removeFirst();
            if (!visited.contains(curNode.data)) {
                if (curNode.data == to.data) {
                    return true;
                } else {
                    for (Node adjNode: curNode.adjNodes) {
                        frontier.add(adjNode);
                    }
                }
                visited.add(curNode);
            }
        }
        return false;
    }        
}
