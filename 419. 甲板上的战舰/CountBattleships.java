public class CountBattleships {

    public int countBattleships(char[][] board) {
        int res = 0;
        if (board.length == 0)
            return 0;
//        �����true˵���Ѿ�̽������
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (flags[i][j])
                    continue;
                if (board[i][j] == 'X') {
                    res++;
//                    �������죬�º��ҵı߽粻��̽��
                    int row = i + 1;
                    int col = j;
                    while (true) {
                        if (board[i][col] == 'X') {
                            flags[i][col] = true;
                            if (row < board.length) {
                                flags[row][col] = true;
                            }
                            col++;
                            if (col < board[0].length) {
                                flags[i][col] = true;
                            }else {
                                break;
                            }
                        }else {
                            break;
                        }
                    }
//                    �������죬�Һ��µı߽粻��̽��
                    row = i;
                    col = j + 1;
                    while (true) {
                        if (board[row][j] == 'X') {
                            flags[row][j] = true;
                            if (col < board[0].length) {
                                flags[row][col] = true;
                            }
                            row++;
                            if (row < board.length) {
                                flags[row][j] = true;
                            }else {
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

}
