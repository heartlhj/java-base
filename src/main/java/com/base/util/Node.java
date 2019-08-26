package com.base.util;

import java.util.LinkedList;

/**
 * @ProjectName: java-base
 * @Package: com.base
 * @ClassName: TreeNode
 * @Author: LiAy
 * @Description: 二叉树节点
 * @Date: 2019-8-26 15:49
 * @Version: 1.0
 */
public class Node {
    //存储数据
    public int data;
    //左节点
    public Node leftNode;
    //右节点
    public Node rightNode;

    public Node(int date) {
            this.data = date;
        }

    /**
     * @Description 构建二叉树
     * @Param [inputList]
     * @Date 2019-8-26 15:58
     * @Version 1.0
     */
    public static Node createTreeNode(LinkedList<Integer> inputList) {
        Node node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new Node(data);
            node.leftNode = createTreeNode(inputList);
            node.rightNode = createTreeNode(inputList);
        }
        return node;
    }

}