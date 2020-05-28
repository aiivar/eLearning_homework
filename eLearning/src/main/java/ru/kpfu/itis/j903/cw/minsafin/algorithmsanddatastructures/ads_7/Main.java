package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_7;

public class Main {
    public static void main(String[] args) {
        testAVL();
    }

    static void testBinary(){
        BinaryTree<String> binaryTree = new BinaryTree<>("abc");
        binaryTree.add("dom");
        binaryTree.add("ab");
        binaryTree.add("");
        binaryTree.bfs();
        binaryTree.dfs();
    }

    static void testAVL(){
        AVLTree tree = new AVLTree();
        tree.add(2);
        tree.add(321);
        tree.add(32);
        tree.add(324);
        tree.add(2415);
        tree.add(41251);
        tree.add(344);
        tree.bfs();
        System.out.println("-------------------");
        tree.dfs();
        tree.remove(32);
        tree.remove(321);
        System.out.println("___________________");
        tree.bfs();
        System.out.println("-------------------");
        tree.dfs();
    }
}
