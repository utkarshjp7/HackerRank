public class Stack {

    public static class StackNode<T> {
        public T data;
        public StackNode<T> next;
        public T minOfSubstack;
        
        public StackNode(T data) {
            this.data = data;
        }
    }
    
    public static class Stack<T extends Comparable<T>> {
        
        public StackNode<T> top;
        
        public void push (T data) {
            StackNode<T> node = new StackNode<>(data);
            node.next = top;
            top = node;
            
            if (top.next != null) {
                top.minOfSubstack = (top.data.compareTo(top.next.minOfSubstack) < 0) ? top.data : top.next.minOfSubstack;
            }
            else {
                top.minOfSubstack = top.data;
            }
        }
        
        public T pop() {
            if (top == null) return null;
            T topData = top.data;
            top = top.next;
            return topData;
        }
        
        public T peek() {
            if (top == null) return null;
            return top.data;
        }
        
        public boolean isEmpty() {
            return top == null;
        }
        
        public T min() {
            if (top != null)
                return top.minOfSubstack;
            else
                return null;
        }
    }

     public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
        
        stack.push(10);
        System.out.println(stack.min());
        stack.push(20);
        System.out.println(stack.min());
        stack.push(30);
        System.out.println(stack.min());
        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
     }
}
