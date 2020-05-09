package lhj.leetcode;

/**
 * @author lhj
 * @version 1.0
 * @description: TODO
 * @date 2019-12-22 10:34
 */
public class FindNumbers {

    public int findNumbers(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            String s = String.valueOf(num);
            if(s.length()%2 == 0){
                count++;
            }
        }
        return count;
    }
}
