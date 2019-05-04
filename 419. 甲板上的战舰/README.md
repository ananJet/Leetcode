# 419. 甲板上的战舰

#### 我的解法

用一个二维状态数组记录是否需要探索当前格子

如果碰到标记为X的字符，则分别向右和向下探索，更新二维数组，在探索的过程中同时更新在右边和在下边的隔一个空格位置的状态，跟战舰的位置一起标记为不需再探索

#### 其他解法

统计战舰尾


```
class Solution {
    public int countBattleships(char[][] board) {
        int res=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    if((i==board.length-1||board[i+1][j]=='.')&&(j==board[0].length-1||board[i][j+1]=='.')){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
```
