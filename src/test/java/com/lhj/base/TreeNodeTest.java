package com.lhj.base;

import lhj.base.TreeNode;
import lhj.base.util.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ProjectName: java-base
 * @Package: com.base.test
 * @ClassName: TreeNodeTest
 * @Author: LiAy
 * @Description: 二叉树测试
 * @Date: 2019-8-26 16:13
 * @Version: 1.0
 */
public class TreeNodeTest {
    LinkedList<Integer> inputList = null;
    LinkedList<Integer> outputList = new LinkedList<Integer>();
    Node node = null;

    @Before
    public void before(){
        inputList = new LinkedList<Integer>(Arrays.asList(
                new Integer[]{1,2,4,null,null,5,null,null,3,null,6,null}));
        node = Node.createTreeNode(inputList);
    }
    @Test
    public void testPer(){
        TreeNode treeNode = new TreeNode();
        treeNode.preOrderTraveral(node,outputList);
    }
    @Test
    public void testIn(){
        TreeNode treeNode = new TreeNode();
        treeNode.inOrderTraveral(node,outputList);
    }

    @Test
    public void testPost(){
        TreeNode treeNode = new TreeNode();
        treeNode.postOrderTraveral(node,outputList);
    }
    @After
    public void after(){
        for(Integer out : outputList){
            System.out.println(out);
        }
    }
}
