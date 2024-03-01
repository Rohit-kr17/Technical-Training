// Importing required Java classes
import java.util.*;

// Definition for a binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BCS6649_Exp_Six {
    // Function to perform preorder traversal of a binary tree
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // Constructing the sample binary tree
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.left = new Node(3);
        root.right.right.left.right = new Node(4);
        root.right.right.right = new Node(6);

        System.out.print("Preorder Traversal: ");
        preOrder(root);
    }
}
