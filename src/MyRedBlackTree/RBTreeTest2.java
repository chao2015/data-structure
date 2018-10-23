package MyRedBlackTree;

import MyAVLTree.AVLTree;
import MyAVLTree.BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chao on 2018/10/23.
 */
public class RBTreeTest2 {

    public static void main(String[] args) {
        int n = 2000000;

        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i=0; i<n; i++)
            testData.add(random.nextInt(Integer.MAX_VALUE));

        // 测试纯粹的添加操作
        // Test BST
        long startTime = System.nanoTime();

        BST<Integer, Integer> bst = new BST<>();
        for (Integer x: testData)
            bst.add(x, null);

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BSTree: " + time + " s");  // 3.915011032 s

        // Test AVL Tree
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        for (Integer x: testData)
            avlTree.add(x, null);

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVLTree: " + time + " s");  // 3.268433284 s

        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer x: testData)
            rbTree.add(x, null);

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");  // 3.497861061 s
    }
}
