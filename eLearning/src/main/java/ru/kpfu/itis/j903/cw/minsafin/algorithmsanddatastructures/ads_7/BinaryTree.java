package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_7;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> head;

    public void dfs(){
        dfs(head);
    }

    private void dfs(Node<T> node){
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
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node<T> node = queue.remove();
            System.out.println(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public void add(T value){
        head = add(head, value);
    }

    private Node<T> add(Node<T> current,T value){
        if (current == null){
            return new Node<>(value);
        }
        if (value.compareTo(current.value) < 0){
            current.left = add(current.left, value);
        } else if (value.compareTo(current.value)>0){
            current.right = add(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public BinaryTree(T value) {
        this.head = new Node<>(value);
    }

    private class Node<T extends Comparable<T>> {
        private Node<T> parent = null;
        private Node<T> left = null;
        private Node<T> right = null;
        private T value;

        Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right) &&
                    Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right, value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
