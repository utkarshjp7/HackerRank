public class HelloWorld{

    public static class Node {
    
        public int data;
        public Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }

    public static class LinkedList {
        
        public Node head;
        
        public void addFirst(int data) {
            Node n = new Node(data);
            if (this.head == null) {
                this.head = n;
            } else {
                n.next = this.head;
                this.head = n;
            }
        }
        
        public void addLast(int data) {
            Node n = new Node(data);
            if (this.head == null) {
               this.head = n;
            } else {
                Node cur = this.head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = n;    
            }
        }
        
        public void removeDuplicates() {
            if (this.head == null) {
                return;
            }
            
            Node cur = this.head;
            while (cur.next != null) {
                Node runner = cur;
                while (runner.next != null) {
                    if (runner.next.data == cur.data) {
                        runner.next = runner.next.next;    
                    } else {
                        runner = runner.next;
                    }
                }
                cur = cur.next;
            }
        }
        
        public void print() {
            Node cur = this.head;
            if (this.head == null) {
               return;
            }
            
            while (cur.next != null) {
                System.out.println(cur.data);
                cur = cur.next;
            }
            System.out.println("--------------------------");
        }
    }
    
     public static void main(String []args){
        LinkedList l = new LinkedList();
        int[] data = new int[] {2, 4, 10, 1, -2, 37, 2, 48, 1, 0, 0, 37, 10, -56, 100, 10, 44, 44};
        for (int i=0; i<data.length; i++) {
            l.addFirst(data[i]);
        }
        
        l.print();
        l.removeDuplicates();
        l.print();
     }
}
