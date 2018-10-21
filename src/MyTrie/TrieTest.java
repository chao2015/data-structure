package MyTrie;

import MySet.BSTreeSet;
import common.FileOperation;

import java.util.ArrayList;

/**
 * Created by chao on 2018/10/21.
 */
public class TrieTest {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("/Users/chao/Documents/java/data-structure/src/common/pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

            BSTreeSet<String> bsTreeSet = new BSTreeSet<>();
            for (String word: words)
                bsTreeSet.add(word);

            for (String word: words)
                bsTreeSet.contains(word);

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + bsTreeSet.getSize());
            System.out.println("BSTreeSet: " + time + " s");  // 0.138785718 s

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word: words)
                trie.add(word);

            for (String word: words)
                trie.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + bsTreeSet.getSize());
            System.out.println("Trie: " + time + " s");  // 0.11210993 s


        }
    }
}
