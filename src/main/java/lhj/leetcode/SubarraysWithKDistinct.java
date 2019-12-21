package lhj.leetcode;

import java.util.ArrayList;
import java.util.List;
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
    public static int subarraysWithKDistinct(int[] A, int K) {
        if(A.length < K){
            return 0;
        }
        for (int i = 0; i < A.length - K +1; i++) {
            sumCount(A,i,K,K);
        }
        return count;
    }

    private static void sumCount(int[] a, int i, int k,int l) {
        if(i+l > a.length){
            return;
        }
        int t =i;
        List<Integer> list = new ArrayList<>();

        for (int i1 = 0; i1 < l; i1++) {
            if (t < a.length) {
                list.add(a[t]);
                t++;
            }
        }
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        if(collect.size() <= k ){
            if(collect.size() == k){
                count++;
            }
            sumCount(a,i,k,l+1);
        }

    }
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,4};
        subarraysWithKDistinct(arr,3);
    }
}
