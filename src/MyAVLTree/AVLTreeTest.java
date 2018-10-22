package MyAVLTree;

import common.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by chao on 2018/10/22.
 */
public class AVLTreeTest {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/common/pride-and-prejudice.txt", words)) {

            // 排序：创造BST的最坏情况
//            Collections.sort(words);
////            BST: 19.829293543 s
////            AVL: 0.091719131 s

            // Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word: words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");  // 0.181356634 s

            // Test AVL Tree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word))
                    avlTree.set(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }

            for (String word: words)
                avlTree.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");  // 0.134873215 s
        }

    }
}
