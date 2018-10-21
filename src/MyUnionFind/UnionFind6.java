package MyUnionFind;

/**
 * Created by chao on 2018/10/21.
 *
 * 用递归来完成路径压缩，树高2层
 * 性能比非递归差一些
 */
public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;  // rand[i]表示根节点为i的树的高度

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i=0; i<size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找过程，查找元素p所对应的集合编号
    // O(h)复杂度，h为树的高度
    private int find(int p) {
        if (p<0 && p>=parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }

    // O(h)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    // O(h)
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 根据两个元素所在树的rank不同，判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {  // rank[pRoot] == rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
