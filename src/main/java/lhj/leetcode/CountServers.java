package lhj.leetcode;

/**1267. 统计参与通信的服务器
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 */
public class CountServers {

    /**
     * 主要理解两台服务器位于同一行或者同一列，而不是必须相连
     * @param grid
     * @return
     */
    public int countServers(int[][] grid) {
        int count = 0;
        for(int i = 0 ;i < grid.length;i++){
            for(int j = 0 ;j < grid[i].length;j++){
                if(grid[i][j]==1){
                    if(findR(grid,i,j) || findT(grid,i,j )){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private Boolean findR(int[][] grid, int row, int col) {
        int n = grid[row].length;
        for (int j = 0; j < n; j++) {
            if (grid[row][j] == 1 && j != col) {
                return true;
            }
        }
        return false;
    }

    private Boolean findT(int[][] grid, int row, int col) {
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            if (grid[i][col] == 1 && i != row) {
                return true;
            }
        }
        return false;
    }

}
