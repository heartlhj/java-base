package lhj.leetcode;

/**558. 四叉树交集
 四叉树是一种树数据，其中每个结点恰好有四个子结点：topLeft、topRight、bottomLeft 和 bottomRight。四叉树通常被用来划分一个二维空间，递归地将其细分为四个象限或区域。

 我们希望在四叉树中存储 True/False 信息。四叉树用来表示 N * N 的布尔网格。对于每个结点, 它将被等分成四个孩子结点直到这个区域内的值都是相同的。每个节点都有另外两个布尔属性：isLeaf 和 val。当这个节点是一个叶子结点时 isLeaf 为真。val 变量储存叶子结点所代表的区域的值。

 例如，下面是两个四叉树 A 和 B：

 A:
 +-------+-------+   T: true
 |       |       |   F: false
 |   T   |   T   |
 |       |       |
 +-------+-------+
 |       |       |
 |   F   |   F   |
 |       |       |
 +-------+-------+
 topLeft: T
 topRight: T
 bottomLeft: F
 bottomRight: F

 B:
 +-------+---+---+
 |       | F | F |
 |   T   +---+---+
 |       | T | T |
 +-------+---+---+
 |       |       |
 |   T   |   F   |
 |       |       |
 +-------+-------+
 topLeft: T
 topRight:
 topLeft: F
 topRight: F
 bottomLeft: T
 bottomRight: T
 bottomLeft: T
 bottomRight: F
  

 你的任务是实现一个函数，该函数根据两个四叉树返回表示这两个四叉树的逻辑或(或并)的四叉树。

 A:                 B:                 C (A or B):
 +-------+-------+  +-------+---+---+  +-------+-------+
 |       |       |  |       | F | F |  |       |       |
 |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
 |       |       |  |       | T | T |  |       |       |
 +-------+-------+  +-------+---+---+  +-------+-------+
 |       |       |  |       |       |  |       |       |
 |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
 |       |       |  |       |       |  |       |       |
 +-------+-------+  +-------+-------+  +-------+-------+

  

 提示：
扫雷
 A 和 B 都表示大小为 N * N 的网格。
 N 将确保是 2 的整次幂。
 逻辑或的定义如下：如果 A 为 True ，或者 B 为 True ，或者 A 和 B 都为 True，则 "A 或 B" 为 True。
 */
public class FourTree {

    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf){
            if(quadTree1.val) {
                return quadTree1;
            }else{
                return quadTree2;
            }
        }
        if(quadTree2.isLeaf){
            if(quadTree2.val) {
                return quadTree2;
            }else{
                return quadTree1;
            }
        }
        Node topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight,quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);

        if(topLeft.isLeaf &&  topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val &&  topRight.val && bottomLeft.val && bottomRight.val){
            return new Node(true,true,null,null,null,null);
        }
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }

    }
}
