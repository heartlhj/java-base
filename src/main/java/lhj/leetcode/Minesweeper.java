package lhj.leetcode;

/**529. 扫雷游戏
 *给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 *
 * 示例 1：
 *
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 */
public class Minesweeper {

    /**
     * 点击方块递归相邻没有相邻地雷的方块都要被标记为B
     * 如果点击的方块相邻的有雷，将雷的个数赋值给点击方块返回
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = click[0];
        int n = click[1];
        if(board[m][n] == 'M'){
            board[m][n] = 'X';
            return board;
        } else {
            if(number(board,m,n) == '0'){
                board[m][n] = 'B';
            } else {
                board[m][n] = number(board,m,n);
                return board;
            }
            for(int i = -1 ; i <= 1; i++){
                for(int j = -1 ; j <= 1; j++){
                    if(m+i >= 0 && n+j >= 0 && m+i < board.length && n+j < board[0].length && board[m+i][n+j] == 'E'){
                        click[0] = m+i;
                        click[1] = n+j;
                        board = updateBoard(board,click);
                    }
                }
            }
            return board;
        }
    }

    private char number(char[][] board,int m,int n){
        char num = '0' ;
        for(int i = -1 ; i <= 1; i++){
            for(int j = -1 ; j <= 1; j++){
                if(m+i >= 0 && n+j >= 0 && m+i < board.length && n+j < board[0].length && board[m+i][n+j] == 'M'){
                    num++;
                }
            }
        }
        return num;
    }
}
