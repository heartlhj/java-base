package lhj.leetcode;

/** 1219. 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 */
public class MaximumGold {

    /**
     * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
     * 输出：28
     *
     *  [[1,0,7],
     *  [2,0,6],
     *  [3,4,5],
     *  [0,3,0],
     *  [9,0,20]]
     * @param grid
     * @return
     */
    public int getMaximumGold(int[][] grid) {
        int maxResult = 0;
        for(int i = 0 ;i < grid.length;i++){
            for(int j = 0 ;j < grid[i].length;j++){
               int max = findMax(grid,i,j);
                maxResult = Math.max(maxResult, max);
            }
        }
        return maxResult;
    }

    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int findMax(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        int v = grid[i][j];
        //赋值为0，阻止迭代时回溯，子迭代不能回退
        grid[i][j] = 0;
        int ret = 0;
        for (int[] dir : dirs) {
            int nR = i + dir[0], nC = j + dir[1];
            ret = Math.max(ret, v + findMax(grid, nR, nC));
        }
        grid[i][j] = v;
        return ret;
    }

}
