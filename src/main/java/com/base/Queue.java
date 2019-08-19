package com.base;

/**
 * @ProjectName: java-base
 * @Package: com.base
 * @ClassName: Queue
 * @Author: LiAy
 * @Description: 循环队列 先进先出 FIFO
 * @Date: 2019-8-19 22:00
 * @Version: 1.0
 */
public class Queue {
    //元素数组
    private int[] array;
    //队头
    private int front;
    //队尾
    private int rear;

    public Queue(int capacity){
        this.array = new int[capacity];
    }
    /**
     * @Description 添加元素
     * @Param  [element 入队列的元素]
     * @Date 2019-8-19 22:07
     * @Version  1.0
     */
    public void add(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }
    /**
     * @Description 返回队头元素并删除
     * @Param  []
     * @Date 2019-8-19 22:08
     * @Version  1.0
     */
    public int poll() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        int pollArr = array[front];
        front = (front + 1) % array.length;
        return pollArr;
    }
    /**
     * @Description  返回队头元素
     * @Param  NULL
     * @Date 2019-8-19 22:09
     * @Version  1.0
     */
    public int peek() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        return array[front];
    }

    public void output(){
        for(int i = front; i!=rear;i = (i+1)%array.length){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args){
        try {
            Queue queue = new Queue(10);
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            queue.output();
            System.out.println("*********poll**********");
            queue.poll();
            queue.output();
            System.out.println("**********peek*********");
            queue.peek();
            queue.output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
