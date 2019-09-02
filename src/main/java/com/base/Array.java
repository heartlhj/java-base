package com.base;


/**
 * @ProjectName: java-base
 * @Package: com.base.array
 * @ClassName: Array
 * @Author: LiAy
 * @Description: 数组
 * @Date: 2019-8-18 19:26
 * @Version: 1.0
 */
public class Array {
    
    //数据元素
    private int[] array;
    
    //当前数组存储数的个数
    private int size;

    public Array(int capacity){
        this.array = new int[capacity];
        this.size = 0;
    }
    /**
     * @Description
     * @Param  [num 添加的元素]
     * @Date 2019-8-18 20:31
     * @Version  1.0
     */
    public void add(int num){
        //对数组进行扩容
        if(size > array.length){
            resize();
        }
        //添加元素
        array[size++] = num;
    }
    /**
     * @Description 数组插入元素
     * @Param  [element 插入的数据, index 插入的位置]
     * @Date 2019-8-18 19:35
     * @Version  1.0
     */
    public void insert(int element,int index){
        //判断下表是否超出数组范围
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组容量");
        }
        //对数组进行扩容
        if(size > array.length){
            resize();
        }
        for(int i = size - 1;i >= index;i--){
            array[i+1] = array[i];
        }
        //插入元素
        array[index] = element;
        size++;
    }
    /**
     * @Description 对数据进行扩容
     * @Param  null
     * @Date 2019-8-18 19:43
     * @Version  1.0
     */
    private void resize() {
        //数组扩容为原来的2倍
        int[] newArray = new int[array.length * 2];
        //将数据从旧的数组拷贝到新数组
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }
    /**
     * @Description 获取数据
     * @Param  [index 获取数据的下标]
     * @Date 2019-8-18 20:34
     * @Version  1.0
     */
    public int get(int index){
       return array[index];
    }

    //测试
    public static void main(String[] args){
        Array array = new Array(10);
        array.insert(3,0);
        array.insert(2,1);
        array.insert(5,2);
        array.insert(6,3);
        array.insert(7,1);
        array.add(9);
        for (int i = 0; i < array.size; i++) {
            System.out.println(array.get(i));
        }
    }
}
