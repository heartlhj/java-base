package lhj.leetcode;

/**1208. 尽可能使字符串相等
 * 滑动窗口
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 */
public class SlidingWindow {

    /**
     * 从左往右判断两个字符的 ASCII 码值的差的绝对值的总和是否大于最大预算，记录原字符串满足条件长度（result)
     * 当大于最大预算时，开始计算子字符串，从左一次减去两个字符的 ASCII 码值的差的绝对值
     * 在正向区间和子区间中取最大值
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        //总消耗
        int cost = 0;
        //子字符串起始位置
        int left= 0;
        //返回最大长度
        int result = 0;
        //区间长度
        int right = 0;
        for(int i = 0;i < s.length();i++){
            cost += Math.abs(s.charAt(i)-t.charAt(i));
            if(cost > maxCost){
                cost -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            right ++ ;
            //子字符串区间长度
            int child = right - left;
            result = Math.max(result,child);
        }
        return result;
    }

}