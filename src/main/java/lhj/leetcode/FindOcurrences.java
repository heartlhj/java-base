package lhj.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 1078. Bigram 分词
 *给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 *
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 */
public class FindOcurrences {
    /**
     * 主要需要考虑位移步长
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        List<String> strList = new ArrayList<String>();
        String[] s = text.split(" ");
        int lenght = 0;
        while (lenght < s.length -2){
            if(s[lenght].equals(first) && s[lenght+1].equals(second)){
                strList.add(s[lenght+2]);
            }
            lenght++;
        }
        return strList.toArray(new String[strList.size()]);
    }
}
