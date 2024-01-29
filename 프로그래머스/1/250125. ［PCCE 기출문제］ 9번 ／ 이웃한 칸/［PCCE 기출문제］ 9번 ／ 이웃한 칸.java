import java.util.*;

class Solution {
    static int[] dh = {0,1,-1,0};
    static int[] dw = {1,0,0,-1};
    
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        String target = board[h][w];
        
        for(int d = 0 ; d < 4 ; d++) {
            int h_check = h + dh[d];
            int w_check = w + dw[d];
            
            if(h_check < 0 || h_check >= board.length || w_check < 0 || w_check >= board[0].length)    continue;
            if(board[h_check][w_check].equals(target)) {
                count++;
            }
        }        
        
        return count;
    }    
}