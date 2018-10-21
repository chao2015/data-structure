package MyUnionFind;

/**
 * Created by chao on 2018/10/21.
 */
public interface UF {

    int getSize();

    // 查看元素p和元素q是否所属一个集合
    boolean isConnected(int p, int q);

    // 合并元素p和元素q所属的集合
    void unionElements(int p, int q);
}
