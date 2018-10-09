package MySegmentTree;

/**
 * Created by chao on 2018/10/9.
 */
public class SegmentTreeTest {

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        // 1. 匿名函数
//    SegmentTree<Integer> segTree = new SegmentTree<>(nums,
//        new Merger<Integer>() {
//            @Override
//            public Integer merge(Integer a, Integer b) {
//                return a + b;
//            }
//        });
        // 2. lambda
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
