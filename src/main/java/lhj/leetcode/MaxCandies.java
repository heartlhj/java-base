package lhj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhj
 * @version 1.0
 * @description: TODO
 * @date 2019-12-22 11:15
 */
public class MaxCandies {

    List<Integer> box = new ArrayList<>();
    int count = 0;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        if (initialBoxes.length <= 0) {
            return 0;
        }

        for (int i = 0; i < initialBoxes.length; i++) {
            if (!box.contains(initialBoxes[i])) {
                box.add(initialBoxes[i]);
                count += candies[initialBoxes[i]];
                int[] containedBox = containedBoxes[initialBoxes[i]];
                for (int cbox : containedBox) {
                    if (status[cbox] == 1) {
                        if (!box.contains(cbox)) {
                            box.add(cbox);
                            count += candies[cbox];
                            int[] key = keys[cbox];
                            maxCandies(status, candies, keys, containedBoxes, key);
                        }
                    } else {
                        int[] key = keys[initialBoxes[i]];
                        for (int i1 : key) {
                            if (i1 == cbox) {
                                if (!box.contains(cbox)) {
                                    box.add(cbox);
                                    count += candies[i1];
                                    maxCandies(status, candies, keys, containedBoxes, keys[i1]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
