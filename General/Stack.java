public class Stack {

    public static class StackNode<T> {
        public T data;
        public StackNode next;
        
        public StackNode(T data) {
            this.data = data;
        }
    }
    
    public static class Stack<T> {
        
        public StackNode<T> top;
        
        public void push (T data) {
            StackNode<T> node = new StackNode<>(data);
            node.next = top;
            top = node;
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
    }

     public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack.pop());
     }
}
