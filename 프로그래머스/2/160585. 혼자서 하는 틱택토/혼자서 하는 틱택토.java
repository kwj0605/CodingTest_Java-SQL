class Solution {
    public int solution(String[] board) {
        
        int cntO=0;
        int cntX=0;
        for(String bd : board) {
            for(int i=0; i<3; i++) {
                if(bd.charAt(i) == 'O') cntO++;
                if(bd.charAt(i) == 'X') cntX++;
            }
        }
        
        if(cntO+1 <= cntX) return 0;
        if(cntO >= cntX+2) return 0;
        if(win(board, 'O')) {
            if(cntO<=cntX) return 0;
        }
        if(win(board, 'X')) {
            if(cntX<cntO) return 0;
        }
        
        return 1;
    }
    
    private boolean win(String[] board, char target) {
        // 세로 
        for(int i=0; i<3; i++) {
            if(board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target)
                return true;
        }
        // 가로
        for(int i=0; i<3; i++) {
            if(board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target) 
                return true;
        }
        // 대각선(왼쪽 위 -> 오른쪽 아래)
        if(board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target)
            return true;
        // 대각선(우측 위 -> 외쪽 아래)
        if(board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target)
            return true;
        
        return false;
    }
}

// 1. X가 O보다 1개 더 많은 경우
// 2. O가 X보다 2개 더 많은 경우
// 3. O가 완성됐을 때 X가 같을 경우
// 4. X가 완성됐을 때 O가 더 많은 경우