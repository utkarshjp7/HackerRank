import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/ctci-contacts/problem

public class TriesContacts {

    public static class Node {
        private HashMap<Character, Node> childern = new HashMap<Character, Node>();
        public int size;
        
        public void addChild(char c) {
            Node childNode = new Node();
            childern.put(c, childNode);            
        }
        
        public Node getChild(char c) {
            return childern.getOrDefault(c, null);
        }
        
        public boolean contains(char c) {
            return childern.containsKey(c);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);    
    private static final String ADD_OP = "add";
    private static final String FIND_OP = "find";
    private static Node root = new Node();
    
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];
            if(op.equals(ADD_OP)) {
                addContact(contact);
            } else if (op.equals(FIND_OP)) {
                System.out.println(findContacts(contact));        
            }
        }
        scanner.close();
    }
    
    private static void addContact(String name) {
        Node p = root;
        for (int i=0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(!p.contains(c)) {
                p.addChild(c);                
            }                                        
            p = p.getChild(c);
            p.size += 1;
        }
    }
    
    private static int findContacts(String q) {
        Node p = root;
        for (int i=0; i < q.length(); i++) {
            char c = q.charAt(i);
            if (p.contains(c)) {
                p = p.getChild(c);
            } else {
                return 0;
            }
        }        
        return p.size;
    }
}

