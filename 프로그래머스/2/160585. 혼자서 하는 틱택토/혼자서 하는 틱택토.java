import java.util.*;

class Solution {
    static String[] board;
    
    public int solution(String[] board) {
        this.board = board;
        
        int oCnt = 0;
        int xCnt = 0;
        
        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                if(board[i].charAt(j) == 'O')       oCnt++;
                else if(board[i].charAt(j) == 'X')   xCnt++;
            }
        }
        
        // X 갯수가 O 갯수보다 많으면 안 됨
        if(xCnt > oCnt)     return 0;
        
        // O 갯수가 X 갯수+1보다 더 크면 안 됨
        if(oCnt > xCnt + 1) return 0;
        
        // O가 완성되었을 때, O 갯수 == X 갯수면 안 됨
        if(lineOK('O')) {
            if(oCnt == xCnt)
                return 0;
        }
        
        // X가 완성되었을 때, O가 X보다 1개 많으면 안 됨
        if(lineOK('X')) {
            if(oCnt == xCnt + 1)
                return 0;
        }        
                
        return 1;   
    }
    
    private static boolean lineOK(char c) {
        // 가로 검사
        for(int i = 0 ; i < 3 ; i++) {
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
                return true;
        }
        
        // 세로 검사
        for(int i = 0 ; i < 3 ; i++) {
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c)
                return true;
        }
        
        // \ 검사
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            return true;
        
        // / 검사
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)
            return true;
        
        return false;
    }
    
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < 3 && 0 <= y && y < 3;
    }
}