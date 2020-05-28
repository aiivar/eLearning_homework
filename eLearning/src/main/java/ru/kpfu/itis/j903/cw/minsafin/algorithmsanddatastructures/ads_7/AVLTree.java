package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_7;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class AVLTree {
    Node root;

    public void dfs(){
        dfs(root);
    }

    private void dfs(Node node){
        if (node != null){
            System.out.println(node);
        }
        if (node.left != null){
            dfs(node.left);
        }
        if (node.right != null){
            dfs(node.right);
        }
    }

    public void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public void add(int key){
        root = add(root, key);
    }

    public void remove(int key){
        root = remove(root, key);
    }

    private int bfactor(Node n) {
        int left, right;
        if (n.left != null) {
            left = n.left.height;
        } else {
            left = 0;
        }
        if (n.right != null) {
            right = n.right.height;
        } else {
            right = 0;
        }
        return right - left;
    }

    private void fixHeight(Node n) {
        int left;
        int right;
        if (n.left != null) {
            left = n.left.height;
        } else {
            left = 0;
        }
        if (n.right != null) {
            right = n.right.height;
        } else {
            right = 0;
        }
        n.height = Math.max(left, right) + 1;
    }

    private Node rightRotation(Node n) {
        Node q = n.left;
        n.left = q.right;
        q.right = n;
        fixHeight(n);
        fixHeight(q);
        return q;
    }

    private Node leftRotation(Node n) {
        Node q = n.right;
        n.right = q.left;
        q.left = n;
        fixHeight(n);
        fixHeight(q);
        return q;
    }

    private Node balance(Node n) {
        fixHeight(n);
        if (bfactor(n) == 2) {
            if (bfactor(n.right) < 0) {
                n.right = rightRotation(n.right);
            }
            return leftRotation(n);
        }
        if (bfactor(n) == -2){
            if (bfactor(n.left) > 0){
                n.left = leftRotation(n.left);
            }
            return rightRotation(n);
        }
        return n;
    }

    private Node add(Node n, int key){
        if (n == null){
            return new Node(key);
        }
        if (key < n.key){
            n.left = add(n.left, key);
        } else {
            n.right = add(n.right, key);
        }
        return balance(n);
    }

    private Node findMin(Node n){
        if (n.left != null){
            return findMin(n.left);
        } else {
            return n;
        }
    }

    private Node removeMin(Node n){
        if (n.left == null){
            return n.right;
        }
        n.left = removeMin(n.left);
        return balance(n);
    }

    private Node remove(Node n, int key){
        if (n == null){
            return null;
        }
        if (key < n.key){
            n.left = remove(n.left, key);
        } else if (key > n.key){
            n.right = remove(n.right, key);
        } else {
            Node q = n.left;
            Node r = n.right;
            if (r == null){
                return q;
            }
            Node min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(n);
    }

    class Node {
        int key;
        int height = 1;
        Node left = null;
        Node right = null;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    height == node.height &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, height, left, right);
        }
    }
}
