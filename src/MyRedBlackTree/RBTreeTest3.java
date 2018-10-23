package MyRedBlackTree;

import MyAVLTree.AVLTree;
import MyAVLTree.BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chao on 2018/10/23.
 */
public class RBTreeTest3 {

    public static void main(String[] args) {
        int n = 10000000;

        ArrayList<Integer> testData = new ArrayList<>();
        for (int i=0; i<n; i++)
            testData.add(i);

        // 测试纯粹的添加操作（顺序）
        // Test BST
//        long startTime = System.nanoTime();
//
//        BST<Integer, Integer> bst = new BST<>();
//        for (Integer x: testData)
//            bst.add(x, null);
//
//        long endTime = System.nanoTime();
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BSTree: " + time + " s");  // 5.038517827 s

        // Test AVL Tree
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        for (Integer x: testData)
            avlTree.add(x, null);

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVLTree: " + time + " s");  // 5.038517827 s

        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer x: testData)
            rbTree.add(x, null);

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");  // 3.455618594 s
    }
}
