package com.base.test;

import com.base.TreeNode;
import com.base.TreeNodeStack;
import com.base.util.Node;
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
public class TreeNodeStackTest {
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
        TreeNodeStack treeNode = new TreeNodeStack();
        outputList = treeNode.preOrderTraveral(node);
    }
    @Test
    public void testIn(){
        TreeNodeStack treeNode = new TreeNodeStack();
        outputList = treeNode.inOrderTraveral(node);
    }

    @After
    public void after(){
        for(Integer out : outputList){
            System.out.println(out);
        }
    }
}
