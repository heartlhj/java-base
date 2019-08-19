package com.base.array;

/**
 * @ProjectName: java-base
 * @Package: com.base.array
 * @ClassName: Linked
 * @Author: LiAy
 * @Description: 链表
 * @Date: 2019-8-18 20:53
 * @Version: 1.0
 */
public class Linked {
    //链表头节点
    private Node head;
    //链表未节点
    private Node last;
    //链表长度
    private int size;//默认值为0

    /**
     * @Description 链表末尾追加数据
     * @Param  [data 添加的数据]
     * @Date 2019-8-18 21:38
     * @Version  1.0
     */
    public void add(Object data) {
        Node inner = new Node(data);
        if(size == 0){
            head = inner;
            last = inner;
        }else{
           /* 没有理解对象引用
            Node node = get(size-1); //node==last
            node.next = inner;
            last = inner;*/
            //Node node = get(size-1);
            //System.out.println(node == last);//true
            last.next = inner;
            last = inner;
        }
        size++;
    }
    /**
     * @Description 链表插入元素
     * @Param  [data 插入的数据, index 插入的位置]
     * @Date 2019-8-18 21:01
     * @Version  1.0
     */
    public void insert(Object data,int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node inner = new Node(data);
        if(size == 0 ){//链表为空
            head = inner;
            last = inner;
        }else if(index == 0 ){//插入头部
            //System.out.println(head == last);//true 操作head相当于操作last
            inner.next = head;
            head = inner;
            //System.out.println(head.next == last);//true
            //System.out.println(inner.next == last);//true
        }else if(index == size){//尾部插入
            last.next = inner;
            last = inner;
        }else {//插入中间
            Node prevNode = get(index-1);
            if(prevNode == null){
                throw new NullPointerException("下标链表为空！");
            }
            inner.next = prevNode.next;
            prevNode.next = inner;
        }
        size++;
    }
    /**
     * @Description
     * @Param  [index 删除的下标]
     * @Date 2019-8-18 21:28
     * @Version  1.0
     */
    public Node remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node removeNode = null;
        if(index == 0){//删除头部
            removeNode = head;
            head = head.next;
        }else if(index == size){//删除尾部
            Node lastNode = get(index-1);
            removeNode = lastNode.next;
            lastNode.next = null;
            last = lastNode;
        }else{//删除中间
            Node pervNode = get(index-1);
            pervNode.next = pervNode.next.next;
            removeNode = pervNode.next;
        }
        return removeNode;
    }
    /**
     * @Description 根据下标获取链表节点
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
        while (next.next != null){
            System.out.println(next.data);
            next = next.next;
        }
        System.out.println(next.data);
    }
    /**
     * @Description 链表节点
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
        Linked linked = new Linked();
        linked.add("123");
        linked.add(1234);
        linked.add("ad");
        linked.add("trt");
        linked.insert("111",0);
        linked.insert("222",2);
        linked.insert("333",6);
        linked.output();
        System.out.println("**************************");
        linked.remove(4);
        linked.output();

    }
}
