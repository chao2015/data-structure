package MySegmentTree;

/**
 * Created by chao on 2018/10/9.
 */
public class Solution307 {

    private SegmentTree<Integer> segTree;
    public Solution307(int[] nums) {

        if(nums.length != 0){
            Integer[] data = new Integer[nums.length];
            for(int i = 0 ; i < nums.length ; i ++)
                data[i] = nums[i];
            segTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        if(segTree == null)
            throw new IllegalArgumentException("Error");
        segTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if(segTree == null)
            throw new IllegalArgumentException("Error");
        return segTree.query(i, j);
    }

}
