import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 터뜨려 사라진 인형 개수
        
        Stack<Integer> bucket = new Stack<>();
        
        for(int move : moves) {
            for(int i = 0 ; i < board.length ; i++) {
                if(board[i][move - 1] == 0)  {
                    continue;
                } else {
                    if(!bucket.isEmpty() && board[i][move-1] == bucket.peek()) {
                        answer += 2;
                        bucket.pop();
                    } else {
                        bucket.add(board[i][move-1]);
                    }
                    
                    board[i][move - 1] = 0; // 인형 뽑기
                    break;
                }
            }
        }
        
        
        return answer;
    }
}