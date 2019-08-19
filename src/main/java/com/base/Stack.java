package com.base;

/**
 * @ProjectName: java-base
 * @Package: com.base
 * @ClassName: Stack
 * @Author: LiAy
 * @Description: 栈 先进后出 FILO
 * @Date: 2019-8-19 21:36
 * @Version: 1.0
 */
public class Stack {
    //链表头节点
    private Node head;
    //链表未节点
    private Node last;
    //链表长度
    private int size;//默认值为0

    /**
     * @Description 入栈
     * @Param  [data 插入的数据]
     * @Date 2019-8-18 21:01
     * @Version  1.0
     */
    public void push(Object data){

        Node inner = new Node(data);
        if(size == 0 ){//链表为空
            head = inner;
            last = inner;
        }else {
            last.next = inner;
            last = inner;
        }
        size++;
    }
    /**
     * @Description 出栈 先进的后出
     * @Param  NULL
     * @Date 2019-8-18 21:28
     * @Version  1.0
     */
    public Node pop() {
        Node popNode = null;
        if(size == 0){
            throw new NullPointerException("栈空间为空");
        }else if(size == 1){
            popNode = head;
            head = null;
            last = null;
        }else{
            Node lastNode = get(size-2);
            popNode = lastNode.next;
            lastNode.next = null;
            last = lastNode;
        }
        size--;
        return popNode;
    }
    /**
     * @Description 根据下标获取表节点
     * @Param  [index 下标]
     * @Date 2019-8-18 23:02
     * @Version  1.0
     */
    public Node get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if(node.next == null){
                break;
            }
        }
        return node;
    }
    /**
     * @Description 输出链表数据
     * @Param  NULL
     * @Date 2019-8-18 23:06
     * @Version  1.0
     */
    public void output(){
        Node next = head;
        while (next !=null && next.next != null){
            System.out.println(next.data);
            next = next.next;
        }
        if(next != null)
        System.out.println(next.data);
    }

    /**
     * @Description 栈节点
     * @Date 2019-8-18 23:04
     * @Version  1.0
     */
    public static class Node {
        //存储的数据
        public Object data;
        //下一节点
        public Node next;
        public Node(Object data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push("123");
        stack.push("abc");
        stack.push(456);
        stack.push(789);
        stack.output();
        System.out.println("********111******");
        stack.pop();
        stack.output();
        System.out.println("*******222*******");
        stack.pop();
        stack.output();
        System.out.println("*******333*******");
        stack.pop();
        stack.output();
        System.out.println("*******444*******");
        stack.pop();
        stack.output();
        System.out.println("*******555*******");
//        stack.pop();//栈为空
//        stack.output();

    }
}
