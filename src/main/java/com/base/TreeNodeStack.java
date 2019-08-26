package com.base;

import com.base.util.Node;

import java.util.LinkedList;

/**
 * @ProjectName: java-base
 * @Package: com.base
 * @ClassName: TreeNodeStack
 * @Author: LiAy
 * @Description: 用栈实现
 * @Date: 2019-8-26 17:31
 * @Version: 1.0
 */
public class TreeNodeStack {

    private java.util.Stack<Node> nodeStack = new java.util.Stack<Node>();
    /**
     * @Description 前序遍历
     * @Param  [root]
     * @Date 2019-8-26 20:40
     * @Version  1.0
     */
    public LinkedList<Integer> preOrderTraveral(Node root) {
        Node node =  root;
        LinkedList<Integer> arrayList = new LinkedList<Integer>();
        while (node != null || !nodeStack.isEmpty()){
            while(node != null) {
                arrayList.add(node.data);
                nodeStack.push(node);
                node = node.leftNode;
            }
            if (!nodeStack.isEmpty()) {
                node = nodeStack.pop();
                node = node.rightNode;
            }
        }
        return arrayList;
    }
    /**
     * @Description 中序遍历
     * @Param  [root]
     * @Date 2019-8-26 20:40
     * @Version  1.0
     */
    public LinkedList<Integer> inOrderTraveral(Node root) {
        Node node =  root;
        LinkedList<Integer> arrayList = new LinkedList<Integer>();
        while (node != null || !nodeStack.isEmpty()) {
            while (node != null) {
                nodeStack.push(node);
                node = node.leftNode;
            }
            if (!nodeStack.isEmpty()) {
                node = nodeStack.pop();
                arrayList.add(node.data);
                node = node.rightNode;
            }
        }
        return arrayList;
    }
    /**
     * @Description 后续遍历比较麻烦
     * @Param  [root]
     * @Date 2019-8-26 20:39
     * @Version  1.0
     */
   /* public LinkedList<Integer> postOrderTraveral(Node root) {
        Node node =  root;
        LinkedList<Integer> arrayList = new LinkedList<Integer>();
        java.util.Stack<Node> stack = new java.util.Stack<Node>();
        while (node != null || !nodeStack.isEmpty()) {
            while (node != null) {
                nodeStack.push(node);
                node = node.leftNode;
            }
        }
        return arrayList;
    }*/

}
