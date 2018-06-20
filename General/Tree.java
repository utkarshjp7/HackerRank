import java.util.*;

public class TreePractice {

    public static class TreeNode {
        
        TreeNode left, right;
        int data;
        
        public TreeNode(int data) {
            this.data = data;
        }
        
        public void add(int nodeData) {
            if (nodeData < this.data) {
                if (left == null) {
                    left = new TreeNode(nodeData);
                }
                else { 
                    left.add(nodeData);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(nodeData);
                }
                else {
                    right.add(nodeData);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);
        tree.add(-10);
        tree.add(10);
        tree.add(-20);
        tree.add(-5);
        tree.add(5);
        tree.add(20);
        tree.add(-30);
        tree.add(-7);
        tree.add(-3);
        tree.add(7);
        
        ArrayList<LinkedList<TreeNode>> x = createLinkeddListForEachDepth(tree);
        for (LinkedList<TreeNode> l : x) {
            for (TreeNode n: l) {
                System.out.println(n.data);
            }
            System.out.println("-------------------------------");
        }
    }
    
    public static boolean isValidBinaryTree(TreeNode root, int min, int max) {
        if (root == null) return true;
        
        boolean isLeftChildValidTree = isValidBinaryTree(root.left, min, root.data);
        boolean isRightChildValidTree = isValidBinaryTree(root.right, root.data, max);

        if (root.data > max || root.data < min) {
            return false;
        }
        
        return isLeftChildValidTree && isRightChildValidTree;
    }
    
    public static ArrayList<LinkedList<TreeNode>> createLinkeddListForEachDepth(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();        
        LinkedList<TreeNode> curLevel = new LinkedList<>();
        curLevel.addLast(root);        
        
        while (!curLevel.isEmpty()) {
            result.add(curLevel);
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node: curLevel) {
                if (node.left != null)
                    nextLevel.addFirst(node.left);
                if (node.right != null)
                    nextLevel.addFirst(node.right);
            }
            curLevel = nextLevel;
        }        
        return result;
    }
}
