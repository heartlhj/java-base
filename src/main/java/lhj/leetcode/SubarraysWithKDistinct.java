package lhj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 */
public class SubarraysWithKDistinct {

    /**
     * 此题主要在理解题意，子数组中整数的个数为k,可以由重复值
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;
        for (int right = 0; right < A.length; right++) {
            int x = A[right];
            window1.add(x);
            window2.add(x);
            // 让window1左指针移动,直到等于K
            while (window1.different() > K) {
                window1.remove(A[left1]);
                left1++;
            }
            // 让window2左指针移动,直到恰好小于K
            while (window2.different() >= K) {
                window2.remove(A[left2]);
                left2++;
            }
            // window2恰好少一个，window1恰好等于K
            // 这时所有以left2为结尾的子数组，都是符合要求的
            ans += left2 - left1;
        }
        return ans;
    }

    class Window {
        Map<Integer, Integer> count;
        int nonzero;

        Window() {
            count = new HashMap();
            nonzero = 0;
        }

        void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1){
                nonzero++;
            }

        }

        void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0){
                nonzero--;
            }

        }

        int different() {
            return nonzero;
        }
    }
}
