package lhj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]

 */
public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> integers = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        Map<Integer, Long> collect = integers.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        //使用最小堆
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<Integer>((n1, n2) -> collect.get(n1).intValue() - collect.get(n2).intValue());

        for (int n: collect.keySet()) {
            priorityQueue.add(n);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        // 取出最小堆中的元素
        List<Integer> resultList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            resultList.add(priorityQueue.remove());
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        List<Integer> integers = topKFrequent(nums, 2);
        System.out.println("12");
    }
}
