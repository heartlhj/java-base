package lhj.base;

import lhj.base.util.Node;

import java.util.LinkedList;

/**
 * @ProjectName: java-base
 * @Package: com.base
 * @ClassName: TreeNode
 * @Author: LiAy
 * @Description: 二叉树
 * @Date: 2019-8-26 15:49
 * @Version: 1.0
 */
public class TreeNode {

    /**
     * @Description 前序遍历
     * @Param [node, outPutList]
     * @Date 2019-8-26 16:39
     * @Version 1.0
     */
    public void preOrderTraveral(Node node, LinkedList<Integer> outPutList) {
        if (node != null) {
            outPutList.add(node.data);
            preOrderTraveral(node.leftNode, outPutList);
            preOrderTraveral(node.rightNode, outPutList);
        }
    }

    /**
     * @Description 中序遍历
     * @Param [node, outPutList]
     * @Date 2019-8-26 16:39
     * @Version 1.0
     */
    public void inOrderTraveral(Node node, LinkedList<Integer> outPutList) {
        if (node != null) {
            inOrderTraveral(node.leftNode, outPutList);
            outPutList.add(node.data);
            inOrderTraveral(node.rightNode, outPutList);
        }
    }

    /**
     * @Description `后续遍历
     * @Param [node, outPutList]
     * @Date 2019-8-26 16:43
     * @Version 1.0
     */
    public void postOrderTraveral(Node node, LinkedList<Integer> outPutList) {
        if (node != null) {
            inOrderTraveral(node.leftNode, outPutList);
            inOrderTraveral(node.rightNode, outPutList);
            outPutList.add(node.data);
        }
    }
}
