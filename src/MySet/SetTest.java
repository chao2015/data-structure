package MySet;

import common.FileOperation;

import java.util.ArrayList;

/**
 * Created by chao on 2018/9/21.
 */
public class SetTest {

    private static double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "src/common/pride-and-prejudice.txt";

        BSTreeSet<String> bsTreeSet = new BSTreeSet<>();
        double time1 = testSet(bsTreeSet, filename);
        System.out.println("BSTree Set: " + time1 + " s");  // 0.270615484 s

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");  // 3.058801204


    }
}
