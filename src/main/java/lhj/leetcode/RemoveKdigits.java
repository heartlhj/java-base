package lhj.leetcode;

/**402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * @author lhj
 * @version 1.0
 * @date 2019-12-18 23:30
 */
public class RemoveKdigits {

    /**
     * 从前往后找到最靠前的有序字符串，删除有序最后一位
     * 重新拼接字符串，继续找有序字符串
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        int length = num.length();
        if(length == k){
            return "0";
        }
        if(k==0){
            return delete(num);
        }
        for (int j = 0; j < k; j++) {
            int check = checkFind(num, 0);
            num = num.substring(0,check) + num.substring(check+1,num.length());
        }
        return delete(num);
    }

    /**
     * 递归删除开头为0
     * @param result
     * @return
     */
    private static String delete(String result) {
        int length = result.length();
        for (int i = 0; i < length; i++) {
            if(result.startsWith("0")){
                result = result.substring(1,result.length());
            }
        }
        if(result == null || result.equals("")){
            result = "0";
        }
        return result;
    }

    /**
     * 查找最前面的有序字符串下标
     * @param num
     * @param count
     * @return
     */
    private static int checkFind(String num,int count) {
        if(count == num.length() -1){
            return count;
        }
        if(num.charAt(count) > num.charAt(count + 1)){
            return count;
        }else {
            return checkFind(num,count+1);
        }
    }
}
