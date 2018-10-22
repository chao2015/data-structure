package MyMap;

import common.FileOperation;

import java.util.ArrayList;

/**
 * Created by chao on 2018/9/22.
 */
public class MapTest {

    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word)+1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "src/common/pride-and-prejudice.txt";

        BSTreeMap<String, Integer> bsTreeMap = new BSTreeMap<>();
        double time1 = testMap(bsTreeMap, filename);
        System.out.println("BST Map: " + time1 + " s");  // 0.288221086 s

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");  // 12.361191784 s

        System.out.println();

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Tree Map: " + time3 + " s");  // 0.105127073 s


    }
}
