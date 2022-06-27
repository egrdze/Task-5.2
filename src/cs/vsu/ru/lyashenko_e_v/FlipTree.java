package cs.vsu.ru.lyashenko_e_v;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FlipTree {

    public static Node flipBinaryTree(Node root) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null)
            return root;

        Node flippedRoot = flipBinaryTree(root.left);


        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return flippedRoot;
    }


    public static void printLevelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;
            
            while (nodeCount > 0) {
                Node node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        System.out.println("Enter Numbers: ");
        Scanner sc = new Scanner(System.in);
        Node root = new Node(sc.nextInt());
        root.left = new Node(sc.nextInt());
        root.right = new Node(sc.nextInt());
        root.right.left = new Node(sc.nextInt());
        root.right.right = new Node(sc.nextInt());
        System.out.println("Tree which we have");
        printLevelOrder(root);

        root = flipBinaryTree(root);
        System.out.println("Tree which flipped");
        printLevelOrder(root);
    }
}
