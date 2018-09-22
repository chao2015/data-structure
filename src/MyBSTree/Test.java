package MyBSTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chao on 2018/9/14.
 */
public class Test {

    public static void main(String[] args) {
        BSTree<Integer> bstree = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums)
            bstree.add(num);
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bstree.preOrder();
        // 5 3 2 4 6 8

        System.out.println(bstree);
//                5
//                --3
//                ----2
//                ------null
//                ------null
//                ----4
//                ------null
//                ------null
//                --6
//                ----null
//                ----8
//                ------null
//                ------null

        bstree.inOrder();
        // 2 3 4 5 6 8

        System.out.println();
        bstree.postOrder();
        // 2 4 3 8 6 5

        System.out.println();
        bstree.preOrderNR();
        // 5 3 2 4 6 8

        System.out.println();
        bstree.levelOrder();
        // 5 3 6 2 4 8

//        System.out.println("\nsuccessor: " + bstree.successor(4));

        BSTree<Integer> bstree2 = new BSTree<>();
        Random random = new Random();
        int n = 1000;  // 因为add()方法不添加重复元素，所以nums2数组里的数小于1000个

        // test removeMin
        for (int i=0; i<n; i++)
            bstree2.add(random.nextInt(10000));
        ArrayList<Integer> nums2 = new ArrayList<>();
        while (!bstree2.isEmpty())
            nums2.add(bstree2.removeMin());
        System.out.println("\n" + nums2);
        for (int i=1; i<nums2.size(); i++) {
            if (nums2.get(i-1) > nums2.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("removeMin test completed");

        // test removeMax
        for (int i=0; i<n; i++)
            bstree2.add(random.nextInt(10000));
        nums2 = new ArrayList<>();
        while (!bstree2.isEmpty())
            nums2.add(bstree2.removeMax());
        System.out.println("\n" + nums2);
        for (int i=1; i<nums2.size(); i++) {
            if (nums2.get(i-1) < nums2.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("removeMax test completed");
    }

}
