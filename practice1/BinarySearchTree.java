package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
    private class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node head, int value) {
        if (head == null) {
            head = new Node(value);
            return head;
        }

        if (value < head.val) {
            head.left = insert(head.left, value);
        } else {
            head.right = insert(head.right, value);
        }
        return head;
    }

    public List<Integer> inorder(){
        List<Integer> vals = new ArrayList<>();
        inorder(root,vals);
        return vals;
    }

    public void inorder(Node root, List<Integer> vals) {
        if (root != null) {
            inorder(root.left, vals);
            vals.add(root.val);
            inorder(root.right, vals);
        }
    }

    public boolean search(int num){
        return search(root, num);
    }

    private boolean search(Node head, int num){
        if(head == null){
            return false;
        }
        if(head.val == num){
            return true;
        }
        if(num<head.val){
            return search(head.left, num);
        }
        return search(head.right, num);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int a[] = {5, 8, 1, 0, 10, 6, 7};
        for(int n: a){
            bst.insert(n);
        }
        List<Integer> inorder = bst.inorder();
        System.out.println(Arrays.toString(inorder.toArray()));
        System.out.println(bst.search(10));
        System.out.println(bst.search(20));
    }
}
