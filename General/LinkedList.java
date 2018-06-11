public class LinkedListPractice {

    public static class Node {
    
        public int data;
        public Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }

    public static class LinkedList {
        
        public Node head;

        public int size = 0;
        
        public void addFirst(int data) {
            Node n = new Node(data);
            if (this.head == null) {
                this.head = n;
            } else {
                n.next = this.head;
                this.head = n;
            }
            size++;
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
            size++;
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
                        size--;
                    } else {
                        runner = runner.next;
                    }
                }
                cur = cur.next;
            }
        }
        
        public Node findKthToLastItem(int k) {
            //if size is known
            Node cur = this.head;
            
            for (int i=0; i<(this.size-k); i++) {
                cur = cur.next;
            }
            
            return cur;
        }
        
        public Node findKthToLastItem2(int k) {
            //if size is not known
            Node cur = this.head;
            Node runner = this.head;
            for (int i=0; i<k; i++) {
                if (runner == null) {
                   return null; 
                }
                runner = runner.next;
            }
            
            while (runner != null) {
                runner = runner.next;
                cur = cur.next;
            }
                
            return cur;
        }
        
        
        public void print() {
            Node cur = this.head;
            if (this.head == null) {
               return;
            }
            
            System.out.println(cur.data);
            while (cur.next != null) {
                cur = cur.next;
                System.out.println(cur.data);
            }
            System.out.println("--------------------------");
        }
    }
    
     public static void main(String []args) {
        LinkedList l = new LinkedList();
        int[] data = new int[] {2, 4, 10, 1, -2, 37, 2, 48, 1, 0, 0, 37, 10, -56, 100, 10, 44, 44};
        for (int i=0; i<data.length; i++) {
            l.addFirst(data[i]);
        }
        
        l.print();
        l.removeDuplicates();
        l.print();
        
        System.out.println(l.findKthToLastItem2(11).data);
     }
}
