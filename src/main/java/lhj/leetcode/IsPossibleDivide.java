package lhj.leetcode;

/**
 * @author lhj
 * @version 1.0
 * @description: TODO
 * @date 2019-12-22 10:39
 */
public class IsPossibleDivide {

    public boolean isPossibleDivide(int[] nums, int k) {
        if(k <= 0 && nums.length >= 0){
            return true;
        }
        if(nums.length== 0 && k >0){
            return false;
        }
        if(nums.length/k >= 2 && nums.length%k ==0 ){
            return true;
        }
        return false;
    }
}
